
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.service;

import com.artivisi.pos.model.master.Cabang;
import com.artivisi.pos.model.master.Produk;
import com.artivisi.pos.model.master.RunningNumber;
import com.artivisi.pos.model.master.SystemProperty;
import com.artivisi.pos.model.master.constant.MasterRunningNumberEnum;
import com.artivisi.pos.model.master.constant.TransaksiRunningNumberEnum;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface MasterService {
    public void hapus(Produk p);
    public void simpan(Produk p);
    public List<Produk> semuaProduk();
    public Produk produkBerdasarId(String id);

    public void hapus(Cabang p);
    public void simpan(Cabang p);
    public List<Cabang> semuaCabang();
    public Cabang cabangBerdasarId(String id);

    public void simpan(RunningNumber p);
    public List<RunningNumber> semuaRunningNumber();
    public String ambilBerikutnya(MasterRunningNumberEnum id, String idCabang);
    public String ambilBerikutnya(TransaksiRunningNumberEnum id,Date date,String idCabang);

    public void simpan(SystemProperty p);
    public List<SystemProperty> semuaSystemProperty();
    public SystemProperty systemPropertyBerdasarId(String id);

}
