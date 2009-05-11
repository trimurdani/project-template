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
import org.hibernate.annotations.Cascade;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="TR_PEMBELIAN")
public class Pembelian extends BaseEntity implements Serializable{

    @Id
    @Column(name="ID_PEMBELIAN",length=15)
    private String id;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="TANGGAL",nullable=false)
    private Date tanggal;

    @Column(name="TOTAL",nullable=false)
    private BigDecimal total;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="pembelian")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<PembelianDetail> details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addDetail(PembelianDetail detail){
        if(details == null){
            details = new ArrayList<PembelianDetail>();
        }
        detail.setPembelian(this);
        details.add(detail);
    }

    public List<PembelianDetail> getDetails() {
        return details;
    }

    public void setDetails(List<PembelianDetail> details) {
        this.details = details;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
}
