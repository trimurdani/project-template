/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.model.master;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author endy
 */
@Entity @Table(name="MST_PRODUK")
public class Produk implements Serializable {
    @Id
    @Column(name="ID_PRODUK",length=30)
    private String id;

    @Column(name="NAMA",length=90)
    private String nama;

    @Column(name="HARGA_JUAL")
    private BigDecimal hargaJual = BigDecimal.ZERO;

    @Column(name="HARGA_BELI")
    private BigDecimal hargaBeli = BigDecimal.ZERO;

    @Column(name="STOK")
    private Integer stok;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BigDecimal getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(BigDecimal hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public BigDecimal getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(BigDecimal hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    
}
