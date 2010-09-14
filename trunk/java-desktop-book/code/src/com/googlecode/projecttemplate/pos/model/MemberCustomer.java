package com.googlecode.projecttemplate.pos.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ifnu
 */
@Entity
@Table(name="T_MEMBER_CUSTOMER")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class MemberCustomer extends Customer{

    @Column(name="MEMBER_ID",unique=true)
    private String memberId;

    @Column(name="POINTS")
    private Long points;


}
