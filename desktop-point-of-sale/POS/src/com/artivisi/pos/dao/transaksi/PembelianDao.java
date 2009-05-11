/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.dao.transaksi;

import com.artivisi.pos.model.transaksi.Pembelian;
import com.artivisi.pos.model.transaksi.PembelianDetail;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class PembelianDao {

    @Autowired private SessionFactory sessionFactory;

    public void simpan(Pembelian p){
        sessionFactory.getCurrentSession()
                .saveOrUpdate(p);
    }

    public List<Pembelian> semua(){
        return sessionFactory.getCurrentSession()
                .createCriteria(Pembelian.class)
                .list();
    }

    public void hapus(Pembelian p){
        sessionFactory.getCurrentSession().delete(p);
    }

    public Pembelian cariBerdasarId(String id) {
        Pembelian pembelian = (Pembelian) sessionFactory.getCurrentSession().load(Pembelian.class, id);
        if(pembelian!=null){
            Hibernate.initialize(pembelian.getDetails());
            for(PembelianDetail d : pembelian.getDetails()){
                Hibernate.initialize(d.getProduk());
            }
        }
        return pembelian;
    }

}
