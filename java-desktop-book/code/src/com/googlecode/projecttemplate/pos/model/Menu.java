package com.googlecode.projecttemplate.pos.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="T_MENU")
public class Menu {

    @Id @GeneratedValue
    @Column(name="MENU_ID")
    private Long id;

    private String name;

    @ManyToMany(mappedBy="menus")
    private Set<Role> roles;

}
