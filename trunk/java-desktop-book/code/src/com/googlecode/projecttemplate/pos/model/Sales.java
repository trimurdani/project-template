package com.googlecode.projecttemplate.pos.model;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ifnu
 */
@Entity
@Table(name="T_SALES")
public class Sales {

    @Id @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="SALES_DATE",nullable=false)
    private Date salesDate;

    @OneToMany(mappedBy="sales",cascade=CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<SalesDetail> salesDetails;

    @Column(name="TOTAL_SALES",precision=18,scale=0,nullable=false)
    private BigDecimal totalSales;

}
