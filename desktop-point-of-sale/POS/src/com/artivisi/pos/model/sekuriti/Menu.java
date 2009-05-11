/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.model.sekuriti;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="SEC_MENU")
public class Menu implements Serializable {

    @Id
    @Column(name="ID_MENU",length=10)
    private String id;

    @Column(name="PANEL_CLASS",length=70,nullable=false)
    private String panelClass;

    @Column(name="MENU_LEVEL",nullable=false)
    private Integer menuLevel;

    @Column(name="URUTAN",nullable=false)
    private Integer urutan;

    @ManyToMany(mappedBy = "menus",cascade=CascadeType.ALL)
    private List<Peran> perans;

    public List<Peran> getPerans() {
        return perans;
    }

    public void setPerans(List<Peran> perans) {
        this.perans = perans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getPanelClass() {
        return panelClass;
    }

    public void setPanelClass(String panel) {
        this.panelClass = panel;
    }

    public Integer getUrutan() {
        return urutan;
    }

    public void setUrutan(Integer urutan) {
        this.urutan = urutan;
    }

}
