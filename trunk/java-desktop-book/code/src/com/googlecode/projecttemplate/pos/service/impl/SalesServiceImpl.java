/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.projecttemplate.pos.service.impl;

import com.googlecode.projecttemplate.pos.dao.SalesDao;
import com.googlecode.projecttemplate.pos.model.Sales;
import com.googlecode.projecttemplate.pos.service.SalesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu
 */
@Service(value="salesService")
@Transactional(readOnly=true)
public class SalesServiceImpl implements SalesService{

    @Autowired SalesDao salesDao;

    @Transactional
    public Sales save(Sales sales) {
        return salesDao.save(sales);
    }

    @Transactional
    public Sales delete(Sales sales) {
        return salesDao.delete(sales);
    }

    public Sales getSales(Integer id) {
        return salesDao.getById(id);
    }

    public List<Sales> getSales() {
        return salesDao.getAll();
    }

    public List<Sales> getSales(int start, int num) {
        return salesDao.getAll(start, num);
    }

}
