/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MasterProduk.java
 *
 * Created on Apr 29, 2009, 10:25:26 AM
 */
package com.artivisi.pos.ui.master;

import com.artivisi.pos.model.master.Produk;
import com.artivisi.pos.ui.frame.FrameUtama;
import com.artivisi.pos.util.BigDecimalRenderer;
import com.artivisi.pos.util.TextComponentUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kurusgw
 */
public class MasterProdukPanel extends javax.swing.JInternalFrame {

    private List<Produk> daftarProduk;
    private Produk pilihanProduk;

    /** Creates new form MasterProduk */
    public MasterProdukPanel() {
        initComponents();

        initListener();
        isiTableDaftarProduk();

        enableForm(false);

        tblProduk.setAutoCreateColumnsFromModel(false);
        tblProduk.setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());

        TextComponentUtils.setAutoUpperCaseText(30,txtKode);
        TextComponentUtils.setAutoUpperCaseText(90,txtNama);
        TextComponentUtils.setAutoUpperCaseText(txtSearch);
        TextComponentUtils.setAutoUpperCaseText(90,txtSatuan);
        TextComponentUtils.setNumericTextOnly(txtTotalPembelian);
        TextComponentUtils.setNumericTextOnly(txtStok);
        TextComponentUtils.setCurrency(txtHargaBeli);
        TextComponentUtils.setCurrency(txtHargaJual);
        TextComponentUtils.setAutoUpperCaseText(90,txtSatuan1);
        TextComponentUtils.setNumericTextOnly(txtTotalPembelian1);
        TextComponentUtils.setNumericTextOnly(txtStok1);
        TextComponentUtils.setCurrency(txtHargaBeli1);
        TextComponentUtils.setCurrency(txtHargaJual1);
    }

    private void initListener() {
        // Listener untuk table ketika table di Klik 
        tblProduk.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent arg0) {
                refreshBarisTableProduk();
            }
        });

        //ketika tombol delete di Klik
        masterToolbarPanel1.getBtnHapus().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                askDelete();
                FrameUtama.getMasterService().hapus(pilihanProduk);
                isiTableDaftarProduk();
                clearForm();
                enableForm(false);
                masterToolbarPanel1.kondisiAwal();
            }
        });

        
        //button edit di Klik
        masterToolbarPanel1.getBtnEdit().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                enableForm(true);
                masterToolbarPanel1.kondisiTambah();
            }
        });

        // Ketika Button Tambah di Klick
        masterToolbarPanel1.getBtnTambah().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                clearForm();
                enableForm(true);
                masterToolbarPanel1.kondisiTambah();
            }
        });

        // Ketika Tombol Batal di Klik
        masterToolbarPanel1.getBtnBatal().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                enableForm(false);
                clearForm();
                masterToolbarPanel1.kondisiAwal();
            }
        });

        // Ketika Tombol Keluar di Klik
        masterToolbarPanel1.getBtnKeluar().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                FrameUtama.getInstance().removeInternalFrame(MasterProdukPanel.this);
            }
        });

        // Ketika tombol Simpan di Klik
        masterToolbarPanel1.getBtnSimpan().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                //buat Object Produk terlebih dahulu
                if (validasi()) {
                    //buat Object Produk terlebih dahulu
                    if (pilihanProduk == null) {
                        pilihanProduk = new Produk();
                    }

                    //ambil value kemudian dari text field kemudian di save ke dalam database
                    pilihanProduk.setId(txtKode.getText());
                    pilihanProduk.setNama(txtNama.getText());
                    pilihanProduk.setHargaBeli(TextComponentUtils.parseNumberToBigDecimal(txtHargaBeli.getText()));
                    pilihanProduk.setHargaJual(TextComponentUtils.parseNumberToBigDecimal(txtHargaJual.getText()));
                    pilihanProduk.setStok(Integer.valueOf(txtStok.getText()));
                    pilihanProduk.setSatuan(txtSatuan.getText());
                    pilihanProduk.setTotalPembelian(Long.valueOf(txtTotalPembelian.getText()));

                    pilihanProduk.setHargaBeli1(TextComponentUtils.parseNumberToBigDecimal(txtHargaBeli1.getText()));
                    pilihanProduk.setHargaJual1(TextComponentUtils.parseNumberToBigDecimal(txtHargaJual1.getText()));
                    pilihanProduk.setStok1(Integer.valueOf(txtStok1.getText()));
                    pilihanProduk.setSatuan1(txtSatuan1.getText());
                    pilihanProduk.setTotalPembelian1(Long.valueOf(txtTotalPembelian1.getText()));

                    //simpan ke database dengan Menggunakan Method Simpan di Object Service
                    FrameUtama.getMasterService().simpan(pilihanProduk);

                    //Kembali Kondisi Awal
                    clearForm();
                    enableForm(false);
                    masterToolbarPanel1.kondisiAwal();
                    //refresh table Produk
                    isiTableDaftarProduk();
                }
            }
        });
    }

    private void refreshBarisTableProduk(){
        //kalau tidak ada row yang di pilih maka akan menghasilkan -1
        if (tblProduk.getSelectedRow() >= 0) {
            //ambil row yang di Pilihan
            int row = tblProduk.getSelectedRow();

            pilihanProduk = FrameUtama.getMasterService().produkBerdasarId(daftarProduk.get(row).getId());
            daftarProduk.set(row, pilihanProduk);
            tblProduk.tableChanged(new TableModelEvent(tblProduk.getModel(), row));

            txtKode.setText(pilihanProduk.getId());
            txtNama.setText(pilihanProduk.getNama());

            txtHargaBeli.setText(TextComponentUtils.formatNumber(pilihanProduk.getHargaBeli()));
            txtHargaJual.setText(TextComponentUtils.formatNumber(pilihanProduk.getHargaJual()));
            txtStok.setText(pilihanProduk.getStok().toString());
            txtSatuan.setText(pilihanProduk.getSatuan());
            txtTotalPembelian.setText(pilihanProduk.getTotalPembelian().toString());

            txtHargaBeli1.setText(TextComponentUtils.formatNumber(pilihanProduk.getHargaBeli1()));
            txtHargaJual1.setText(TextComponentUtils.formatNumber(pilihanProduk.getHargaJual1()));
            txtStok1.setText(pilihanProduk.getStok1().toString());
            txtSatuan1.setText(pilihanProduk.getSatuan1());
            txtTotalPembelian1.setText(pilihanProduk.getTotalPembelian1().toString());

            enableForm(false);
            masterToolbarPanel1.kondisiTabelTerpilih();
        } else {
            //dianggap batal
            enableForm(false);
            clearForm();
            masterToolbarPanel1.kondisiAwal();
        }
    }

    private void clearForm(){
        txtKode.setText("");
        txtNama.setText("");
        txtHargaBeli.setText("");
        txtHargaJual.setText("");
        txtStok.setText("");
        txtSatuan.setText("");
        txtTotalPembelian.setText("");
        txtHargaBeli1.setText("");
        txtHargaJual1.setText("");
        txtStok1.setText("");
        txtSatuan1.setText("");
        txtTotalPembelian1.setText("");
        tblProduk.getSelectionModel().clearSelection();
    }

    private void enableForm(boolean status){
        txtKode.setEnabled(status);
        txtNama.setEnabled(status);

        txtHargaBeli.setEnabled(status);
        txtHargaJual.setEnabled(status);
        txtStok.setEnabled(status);
        txtSatuan.setEnabled(status);
        txtTotalPembelian.setEnabled(status);
        txtHargaBeli1.setEnabled(status);
        txtHargaJual1.setEnabled(status);
        txtStok1.setEnabled(status);
        txtSatuan1.setEnabled(status);
        txtTotalPembelian1.setEnabled(status);
    }

    private void isiTableDaftarProduk() {
        daftarProduk = FrameUtama.getMasterService().semuaProduk();
        tblProduk.setModel(new ProdukTableModel(daftarProduk));

    }

    private class ProdukTableModel extends AbstractTableModel {

        private List<Produk> daftarProduk;

        public ProdukTableModel(List<Produk> daftarProduk) {
            this.daftarProduk = daftarProduk;
        }

        public int getRowCount() {
            return daftarProduk.size();
        }

        public int getColumnCount() {
            return 5;
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
            switch(col){
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

    private void askDelete(){
        JOptionPane.showConfirmDialog(this, "Yakin ???");
    }

    private boolean validasi() {
        // Periksa Kalau Kode Kosong tampilkan Message Box
        if (txtKode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Kode Harus di isi", "Field Harus di isi", JOptionPane.ERROR_MESSAGE);
            txtKode.requestFocus();
            return false;
        }
        // Periksa Kalau Nama Kosong tampilkan Message Box
        if (txtNama.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nama Harus di isi", "Field Harus di isi", JOptionPane.ERROR_MESSAGE);
            txtNama.requestFocus();
            return false;
        }
        // Periksa Kalau HArga Kosong tampilkan Message Box
        if (txtHargaBeli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Harga Harus di isi", "Field Harus di isi", JOptionPane.ERROR_MESSAGE);
            txtHargaBeli.requestFocus();
            return false;
        }

        return true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHargaBeli = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHargaJual = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        txtHargaBeli1 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtStok1 = new javax.swing.JTextField();
        txtHargaJual1 = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSatuan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTotalPembelian = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSatuan1 = new javax.swing.JTextField();
        txtTotalPembelian1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        masterToolbarPanel1 = new com.artivisi.pos.ui.toolbar.MasterToolbarPanel();

        setClosable(true);
        setTitle("Master Produk");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Form"));

        jLabel3.setText("Kode Produk");

        jLabel4.setText("Nama Produk");

        jLabel5.setText("Harga Beli");

        jLabel6.setText("Stok");

        txtHargaJual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));

        jLabel7.setText("Harga Jual");

        jLabel8.setText("Harga Beli");

        jLabel9.setText("Harga Jual");

        jLabel10.setText("Stok");

        txtHargaJual1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));

        jLabel11.setText("Satuan");

        jLabel12.setText("Total Pembelian");

        jLabel13.setText("Satuan");

        jLabel14.setText("Total Pembelian");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalPembelian1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSatuan1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStok1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaJual1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaBeli1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargaBeli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargaJual1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStok1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSatuan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPembelian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(25, 25, 25))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtHargaBeli, txtKode, txtNama});

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama", "Harga Beli", "Harga Jual", "Stok"
            }
        ));
        tblProduk.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduk);

        jLabel1.setText("Search Character");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterToolbarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(masterToolbarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
        refreshBarisTableProduk();
    }//GEN-LAST:event_tblProdukMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.artivisi.pos.ui.toolbar.MasterToolbarPanel masterToolbarPanel1;
    private javax.swing.JTable tblProduk;
    private javax.swing.JFormattedTextField txtHargaBeli;
    private javax.swing.JFormattedTextField txtHargaBeli1;
    private javax.swing.JFormattedTextField txtHargaJual;
    private javax.swing.JFormattedTextField txtHargaJual1;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtSatuan;
    private javax.swing.JTextField txtSatuan1;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtStok1;
    private javax.swing.JTextField txtTotalPembelian;
    private javax.swing.JTextField txtTotalPembelian1;
    // End of variables declaration//GEN-END:variables
}
