/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.service.impl;

import com.artivisi.pos.dao.master.ProdukDao;
import com.artivisi.pos.dao.master.RunningNumberDao;
import com.artivisi.pos.dao.transaksi.PembelianDao;
import com.artivisi.pos.dao.transaksi.PenjualanDao;
import com.artivisi.pos.model.master.Produk;
import com.artivisi.pos.model.master.constant.TransaksiRunningNumberEnum;
import com.artivisi.pos.model.transaksi.Pembelian;
import com.artivisi.pos.model.transaksi.PembelianDetail;
import com.artivisi.pos.model.transaksi.Penjualan;
import com.artivisi.pos.model.transaksi.PenjualanDetail;
import com.artivisi.pos.service.TransaksiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author endy
 */
@Service("transaksiService")
@Transactional(readOnly=false)
public class TransaksiServiceImpl implements TransaksiService{
    @Autowired private PenjualanDao penjualanDao;
    @Autowired private PembelianDao pembelianDao;
    @Autowired private RunningNumberDao runningNumberDao;
    @Autowired private ProdukDao produkDao;

    @Transactional
    public void hapus(Penjualan p) {
        penjualanDao.hapus(p);
    }

    @Transactional
    public void simpan(Penjualan penjualan) {
        if(penjualan.getId() ==null){//insert penjualan
            penjualan.setId(runningNumberDao.ambilBerikutnyaDanSimpan(TransaksiRunningNumberEnum.PENJUALAN));
            int i=1;
            for(PenjualanDetail detail : penjualan.getDetails()){
                detail.setId(penjualan.getId() + i++);
                Produk p = produkDao.cariBerdasarId(detail.getProduk().getId());
                p.setStok(p.getStok() - detail.getKuantitas());
                produkDao.simpan(p);
            }
            penjualanDao.simpan(penjualan);
        } else {
            //update :
            List<PenjualanDetail> penjualanDetails =
                    penjualanDao.cariBerdasarId(penjualan.getId()).getDetails();
            //mengecek semua penjualan detail dari form
            for(PenjualanDetail p : penjualan.getDetails()){
                Produk produk = produkDao.cariBerdasarId(p.getProduk().getId());
                if(penjualanDetails.contains(p)){ //kalau di database ada penjualan detail ini!
                    //mendapapatkan penjualan detail yang sama dari database
                    PenjualanDetail detailDb = penjualanDetails.get(penjualanDetails.indexOf(p));
                    //stok sekarang + penjualan detail lama - penjualan detail baru
                    produk.setStok(produk.getStok() + detailDb.getKuantitas() - p.getKuantitas());
                    produkDao.simpan(produk);
                } else { //penjualan detail baru atau tambahan
                    produk.setStok(produk.getStok() - p.getKuantitas());
                    produkDao.simpan(produk);
                }
            }
            //mengecek penjualan dari database dicari penjualan yang dihapus
            for(PenjualanDetail p : penjualanDetails){
                //dicari yang ada didatabase tapi tidak ada di form
                //artinya penjualan detail ini dihapus
                if(!penjualan.getDetails().contains(p)) {
                    Produk produk = produkDao.cariBerdasarId(p.getProduk().getId());
                    //tambah stoknya
                    produk.setStok(produk.getStok() + p.getKuantitas());
                    produkDao.simpan(produk);
                }
            }
            penjualanDao.merge(penjualan);
        }
    }

    public Penjualan cariPenjualan(String id) {
        return penjualanDao.cariBerdasarId(id);
    }

    public List<Penjualan> semuaPenjualan() {
        return penjualanDao.semua();
    }

    @Transactional
    public void hapus(Pembelian pembelian) {
        pembelian = pembelianDao.cariBerdasarId(pembelian.getId());
        for(PembelianDetail d : pembelian.getDetails()){
            Produk p = produkDao.cariBerdasarId(d.getProduk().getId());
            p.setStok(p.getStok() - d.getKuantitas());
            PembelianDetail pembelianTerakhir = pembelianDao.pembelianTerakhir(d.getProduk(),pembelian);
            if(pembelianTerakhir!=null){
                p.setHargaBeli(pembelianTerakhir.getHarga());
            }
            produkDao.simpan(p);
        }
        pembelianDao.hapus(pembelian);    }

    @Transactional
    public void simpan(Pembelian pembelian) {
        if(pembelian.getId() == null){ //insert pembelian
            pembelian.setId(runningNumberDao.ambilBerikutnyaDanSimpan(TransaksiRunningNumberEnum.PEMBELIAN));
            int i = 1;
            for(PembelianDetail detail : pembelian.getDetails()){
                detail.setId(pembelian.getId() + i++);
            }
            for(PembelianDetail d : pembelian.getDetails()){
                Produk p = produkDao.cariBerdasarId(d.getProduk().getId());
                p.setStok(p.getStok() + d.getKuantitas());
                p.setHargaBeli(d.getHarga());
                produkDao.simpan(p);
            }
            pembelianDao.simpan(pembelian);
        } else { //update stok dan harga beli
            //update pembelian, perlu dicek satu persatu detailnya untuk update stok
            Pembelian pembelianDb =  pembelianDao.cariBerdasarId(pembelian.getId());
                List<PembelianDetail> pembelianDetails = pembelianDb.getDetails();
                //mengecek semua pembelian detail dari form
                for(PembelianDetail p : pembelian.getDetails()){
                    Produk produk = produkDao.cariBerdasarId(p.getProduk().getId());
                    if(pembelianDetails.contains(p)){ //kalau di database ada pembelian detail ini!
                        //mendapapatkan pembelian detail yang sama dari database
                        PembelianDetail detailDb = pembelianDetails.get(pembelianDetails.indexOf(p));
                        //stok sekarang - pembelian detail lama + pembelian detail baru
                        produk.setStok(produk.getStok() - detailDb.getKuantitas() + p.getKuantitas());
                        //harga beli diupdate ke pembelian terbaru
                        produk.setHargaBeli(p.getHarga());
                        produkDao.simpan(produk);
                    } else { //pembelian detail baru atau tambahan
                        produk.setStok(produk.getStok() + p.getKuantitas());
                        produk.setHargaBeli(p.getHarga());
                        produkDao.simpan(produk);
                    }
                }
                //mengecek pembelian dari database dicari pembelian yang dihapus
                for(PembelianDetail p : pembelianDetails){
                    //dicari yang ada didatabase tapi tidak ada di form
                    //artinya pembelian detail ini dihapus
                    if(!pembelian.getDetails().contains(p)) {
                        Produk produk = produkDao.cariBerdasarId(p.getProduk().getId());
                        //cari pembelian terakhir dari database
                        PembelianDetail pembelianTerakhir = pembelianDao.pembelianTerakhir(produk,pembelian);
                        if(pembelianTerakhir!=null){
                            produk.setHargaBeli(pembelianTerakhir.getHarga());
                        }
                        //kurangi stoknya
                        produk.setStok(produk.getStok() - p.getKuantitas());
                        produkDao.simpan(produk);
                    }
                }
            pembelianDao.merge(pembelian);
        }
    }

    public Pembelian cariPembelian(String id) {
        return pembelianDao.cariBerdasarId(id);
    }

    public List<Pembelian> semuaPembelian() {
        return pembelianDao.semua();
    }
    

}
