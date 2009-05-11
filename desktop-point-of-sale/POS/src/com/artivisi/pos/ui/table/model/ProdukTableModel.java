/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.ui.table.model;

import com.artivisi.pos.model.master.Produk;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kurusgw
 */
public class ProdukTableModel extends AbstractTableModel {

    private List<Produk> daftarProduk;

    public ProdukTableModel(List<Produk> daftarProduk) {
        this.daftarProduk = daftarProduk;
    }
    
    public int getRowCount() {
        return daftarProduk.size();
    }

    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int col) {
        switch(col){
            case 0 : return "Kode barang";
            case 1 : return "Nama Barang";
            case 2 : return "Harga Beli";
            case 3 : return "Harga Jual";
            case 4 : return "Stok";
            default : return "";
        }

    }

    public Object getValueAt(int row, int col) {
        Produk p = daftarProduk.get(row);
        switch(row){
            case 0 : return p.getId();
            case 1 : return p.getNama();
            case 2 : return p.getHargaBeli();
            case 3 : return p.getHargaJual();
            case 4 : return p.getStok();
            default : return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 2 : return BigDecimal.class;
            case 3 : return BigDecimal.class;
            case 4 : return Integer.class;
            default : return String.class;
        }
    }

}
