/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.dao.master;

import com.artivisi.pos.model.master.Produk;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author endy
 */
@Repository
public class ProdukDao{
    @Autowired private SessionFactory sessionFactory;

    public void simpan(Produk p){
        sessionFactory.getCurrentSession()
                .saveOrUpdate(p);
    }

    public List<Produk> semua(){
        return sessionFactory.getCurrentSession()
                .createCriteria(Produk.class)
                .list();
    }

    public void hapus(Produk p){
        sessionFactory.getCurrentSession().delete(p);
    }

    public Produk cariBerdasarId(String id){
        return (Produk) sessionFactory.getCurrentSession().load(Produk.class, id);
    }

}
