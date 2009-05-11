/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.service;

import com.artivisi.pos.model.transaksi.Pembelian;
import com.artivisi.pos.model.transaksi.Penjualan;
import java.util.List;

/**
 *
 * @author endy
 */
public interface TransaksiService {

    public void hapus(Penjualan p);
    public void simpan(Penjualan p);
    public Penjualan cariPenjualan(String id);
    public List<Penjualan> semuaPenjualan();

    public void hapus(Pembelian p);
    public void simpan(Pembelian p);
    public Pembelian cariPembelian(String id);
    public List<Pembelian> semuaPembelian();

}
