/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.dao.transaksi;

import com.artivisi.pos.model.transaksi.Penjualan;
import com.artivisi.pos.model.transaksi.PenjualanDetail;
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
public class PenjualanDao {

    @Autowired private SessionFactory sessionFactory;

    public void simpan(Penjualan p){
        sessionFactory.getCurrentSession()
                .saveOrUpdate(p);
    }

    public List<Penjualan> semua(){
        return sessionFactory.getCurrentSession()
                .createCriteria(Penjualan.class)
                .list();
    }

    public void hapus(Penjualan p){
        sessionFactory.getCurrentSession().delete(p);
    }
    
    public Penjualan cariBerdasarId(String id) {
        Penjualan penjualan = (Penjualan) sessionFactory.getCurrentSession().load(Penjualan.class, id);
        if(penjualan!=null){
            Hibernate.initialize(penjualan.getDetails());
            for(PenjualanDetail d : penjualan.getDetails()){
                Hibernate.initialize(d.getProduk());
            }
        }
        return penjualan;
    }
}
