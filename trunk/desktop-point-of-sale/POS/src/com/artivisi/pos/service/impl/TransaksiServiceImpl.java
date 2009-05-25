/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.service.impl;

import com.artivisi.pos.dao.transaksi.PembelianDao;
import com.artivisi.pos.dao.transaksi.PenjualanDao;
import com.artivisi.pos.model.transaksi.Pembelian;
import com.artivisi.pos.model.transaksi.Penjualan;
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

    @Transactional
    public void hapus(Penjualan p) {
        penjualanDao.hapus(p);
    }

    @Transactional
    public void simpan(Penjualan p) {
        penjualanDao.simpan(p);
    }

    public Penjualan cariPenjualan(String id) {
        return penjualanDao.cariBerdasarId(id);
    }

    public List<Penjualan> semuaPenjualan() {
        return penjualanDao.semua();
    }

    @Transactional
    public void hapus(Pembelian p) {
        pembelianDao.hapus(p);
    }

    @Transactional
    public void simpan(Pembelian p) {
        pembelianDao.simpan(p);
    }

    public Pembelian cariPembelian(String id) {
        return pembelianDao.cariBerdasarId(id);
    }

    public List<Pembelian> semuaPembelian() {
        return pembelianDao.semua();
    }
    

}
