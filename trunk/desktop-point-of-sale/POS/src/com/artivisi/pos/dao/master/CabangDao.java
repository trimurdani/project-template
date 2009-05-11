/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.dao.master;

import com.artivisi.pos.model.master.Cabang;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class CabangDao{
 @Autowired private SessionFactory sessionFactory;

    public void simpan(Cabang p){
        sessionFactory.getCurrentSession()
                .saveOrUpdate(p);
    }

    public List<Cabang> semua(){
        return sessionFactory.getCurrentSession()
                .createCriteria(Cabang.class)
                .list();
    }

    public void hapus(Cabang p){
        sessionFactory.getCurrentSession().delete(p);
    }

    public Cabang cariBerdasarId(String id) {
        return (Cabang) sessionFactory.getCurrentSession().createQuery("from Cabang where id=:id")
                .setString("id", id)
                .uniqueResult();
    }
}
