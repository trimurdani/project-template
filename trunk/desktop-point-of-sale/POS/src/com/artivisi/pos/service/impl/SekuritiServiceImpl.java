/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.service.impl;

import com.artivisi.pos.dao.sekuriti.PenggunaDao;
import com.artivisi.pos.model.sekuriti.Menu;
import com.artivisi.pos.model.sekuriti.Pengguna;
import com.artivisi.pos.model.sekuriti.Peran;
import com.artivisi.pos.dao.sekuriti.MenuDao;
import com.artivisi.pos.service.SekuritiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu
 */
@Service("sekuritiService")
@Transactional(readOnly=true)
public class SekuritiServiceImpl implements SekuritiService{

    @Autowired private PenggunaDao penggunaDao;
    @Autowired private MenuDao menuDao;

    @Transactional
    public void hapus(Peran p) {
    }

    @Transactional(isolation=Isolation.SERIALIZABLE)
    public void simpan(Peran p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Peran> semuaPeran() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Peran PeranBerdasarId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transactional
    public void hapus(Pengguna p) {
        penggunaDao.hapus(p);
    }

    @Transactional(isolation=Isolation.SERIALIZABLE)
    public void simpan(Pengguna p) {
        penggunaDao.simpan(p);
    }

    public List<Pengguna> semuaPengguna() {
        return penggunaDao.semua();
    }

    public Pengguna penggunaBerdasarId(String id) {
        return penggunaDao.penggunaBerdasarId(id);
    }

    @Transactional
    public void hapus(Menu p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transactional(isolation=Isolation.SERIALIZABLE)
    public void simpan(Menu p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Menu> semuaMenu() {
        return menuDao.semua();
    }

    public Menu menuBerdasarId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer maximumMenuLevel() {
        return menuDao.maximumMenuLevel();
    }

}
