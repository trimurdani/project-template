package com.googlecode.projecttemplate.pos.model;


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="T_SALES_DETAIL")
public class SalesDetail {

    @Id @GeneratedValue
    @Column(name="ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID",nullable=false)
    private Product product;

    @Column(name="QUANTITY",nullable=false)
    private Integer quantity;

    @Column(name="PRICE",nullable=false,precision=18,scale=0)
    private BigDecimal price;

    @Column(name="SUBTOTAL",nullable=false,precision=18,scale=0)
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name="SALES_ID",nullable=false)
    private Sales sales;

}
