/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.dao.master;

import com.artivisi.pos.dao.BaseDaoHibernate;
import com.artivisi.pos.model.master.SystemProperty;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class SystemPropertyDao extends BaseDaoHibernate<SystemProperty>{

    public SystemProperty cariBerdasarId(String id){
        return (SystemProperty) sessionFactory.getCurrentSession().load(SystemProperty.class, id);
    }

}
