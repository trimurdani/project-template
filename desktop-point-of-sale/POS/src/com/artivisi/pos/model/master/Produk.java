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

    @Column(name="STOK",nullable=false)
    private Integer stok = 0;

    @Column(name="TOTAL_PEMBELIAN",nullable=false)
    private Long totalPembelian = 0l;

    @Column(name="SATUAN",length=90)
    private String satuan;

    @Column(name="HARGA_JUAL1")
    private BigDecimal hargaJual1 = BigDecimal.ZERO;

    @Column(name="HARGA_BELI1")
    private BigDecimal hargaBeli1 = BigDecimal.ZERO;

    @Column(name="STOK1",nullable=false)
    private Integer stok1 = 0;

    @Column(name="SATUAN1",length=90)
    private String satuan1;

    @Column(name="TOTAL_PEMBELIAN1",nullable=false)
    private Long totalPembelian1 = 0l;

    @Column(name="PULSA_ELEKTRIK",nullable=false)
    private Boolean pulsaElektrik = Boolean.FALSE;

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

    public BigDecimal getHargaBeli1() {
        return hargaBeli1;
    }

    public void setHargaBeli1(BigDecimal hargaBeli1) {
        this.hargaBeli1 = hargaBeli1;
    }

    public BigDecimal getHargaJual1() {
        return hargaJual1;
    }

    public void setHargaJual1(BigDecimal hargaJual1) {
        this.hargaJual1 = hargaJual1;
    }

    public Integer getStok1() {
        return stok1;
    }

    public void setStok1(Integer stok1) {
        this.stok1 = stok1;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getSatuan1() {
        return satuan1;
    }

    public void setSatuan1(String satuan1) {
        this.satuan1 = satuan1;
    }

    public Long getTotalPembelian() {
        return totalPembelian;
    }

    public void setTotalPembelian(Long totalPembelian) {
        this.totalPembelian = totalPembelian;
    }

    public Long getTotalPembelian1() {
        return totalPembelian1;
    }

    public void setTotalPembelian1(Long totalPembelian1) {
        this.totalPembelian1 = totalPembelian1;
    }

    public Boolean isPulsaElektrik() {
        return pulsaElektrik;
    }

    public void setPulsaElektrik(Boolean pulsaElektrik) {
        this.pulsaElektrik = pulsaElektrik;
    }


}
