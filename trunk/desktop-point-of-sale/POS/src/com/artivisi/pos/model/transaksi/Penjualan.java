/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.model.transaksi;

import com.artivisi.pos.model.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author endy
 */
@Entity @Table(name="T_PENJUALAN")
public class Penjualan extends BaseEntity implements Serializable {

    @Id
    @Column(name="ID_PENJUALAN",length=16)
    private String id;

    @Temporal(TemporalType.DATE)
    @Column(name="TANGGAL")
    private Date tanggal;

    @Column(name="TOTAL")
    private BigDecimal total = BigDecimal.ZERO;

    @OneToMany(mappedBy="penjualan", cascade=CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<PenjualanDetail> details = new ArrayList<PenjualanDetail>();


    public List<PenjualanDetail> getDetails() {
        return details;
    }

    public void setDetails(List<PenjualanDetail> details) {
        this.details = details;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
