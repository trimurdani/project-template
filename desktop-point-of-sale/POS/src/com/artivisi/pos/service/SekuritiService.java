/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.service;

import com.artivisi.pos.model.sekuriti.Menu;
import com.artivisi.pos.model.sekuriti.Pengguna;
import com.artivisi.pos.model.sekuriti.Peran;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface SekuritiService {

    public void hapus(Peran p);
    public void simpan(Peran p);
    public List<Peran> semuaPeran();
    public Peran PeranBerdasarId(String id);

    public void hapus(Pengguna p);
    public void simpan(Pengguna p);
    public List<Pengguna> semuaPengguna();
    public Pengguna penggunaBerdasarId(String id);

    public void hapus(Menu p);
    public void simpan(Menu p);
    public List<Menu> semuaMenu();
    public Menu menuBerdasarId(String id);
    public Integer maximumMenuLevel();


}
