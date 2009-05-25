/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.dao.sekuriti;

import com.artivisi.pos.dao.BaseDaoHibernate;
import com.artivisi.pos.model.sekuriti.Menu;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class MenuDao extends BaseDaoHibernate<Menu>{
    public Integer maximumMenuLevel(){
        return (Integer) sessionFactory.getCurrentSession().createQuery("select max(menuLevel) from Menu").uniqueResult();
    }

    @Override
    public List<Menu> semua() {
        return sessionFactory.getCurrentSession().createQuery("from Menu m left join fetch m.parent order by m.menuLevel,m.urutan").list();
    }

}
