/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MasterPeran.java
 *
 * Created on Apr 29, 2009, 10:25:26 AM
 */
package com.artivisi.pos.ui.sekuriti;

import com.artivisi.pos.model.sekuriti.Peran;
import com.artivisi.pos.ui.frame.FrameUtama;
import com.artivisi.pos.util.BigDecimalRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kurusgw
 */
public class PeranPanel extends javax.swing.JInternalFrame {

    private List<Peran> daftarPeran;
    private Peran pilihanPeran;

    /** Creates new form MasterPeran */
    public PeranPanel() {
        initComponents();

        initListener();
        kondisiAwal();
        isiTableDaftarPeran();
        tblPeran.setAutoCreateColumnsFromModel(false);
        tblPeran.setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
    }

    private void initListener() {
        // Listener untuk table ketika table di Klik 
        tblPeran.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent arg0) {
                //kalau tidak ada row yang di pilih maka akan menghasilkan -1
                if (tblPeran.getSelectedRow() > -1) {
                    //ambil row yang di Pilihan
                    int row = tblPeran.getSelectedRow();

                    pilihanPeran = daftarPeran.get(row);

                    txtNama.setText(pilihanPeran.getId());
                    txtDeskripsi.setText(pilihanPeran.getDeskripsi());

                    buttonPanelMaster1.getBtnEdit().setEnabled(true);
                    buttonPanelMaster1.getBtnHapus().setEnabled(true);
                }
            }
        });

        //button edit di Klik
        buttonPanelMaster1.getBtnEdit().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                kondisiEdit();
                buttonPanelMaster1.kondisiTambah();
            }
        });

        // Ketika Button Tambah di Klick
        buttonPanelMaster1.getBtnTambah().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                kondisiTambah();
                buttonPanelMaster1.kondisiTambah();
            }
        });

        // Ketika Tombol Batal di Klik
        buttonPanelMaster1.getBtnBatal().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                kondisiAwal();
            }
        });

        // Ketika Tombol Keluar di Klik
        buttonPanelMaster1.getBtnKeluar().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });

        // Ketika tombol Simpan di Klik
        buttonPanelMaster1.getBtnSimpan().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                //buat Object Peran terlebih dahulu
                if (validasi()) {
                    //buat Object Peran terlebih dahulu
                    if (pilihanPeran == null) {
                        pilihanPeran = new Peran();
                    }

                    //ambil value kemudian dari text field kemudian di save ke dalam database
                    pilihanPeran.setId(txtNama.getText());
                    pilihanPeran.setDeskripsi(txtDeskripsi.getText());

                    //simpan ke database dengan Menggunakan Method Simpan di Object Service
                    FrameUtama.getSekuritiService().simpan(pilihanPeran);

                    //Kembali Kondisi Awal
                    kondisiAwal();
                    //refresh table Peran
                    isiTableDaftarPeran();
                }
            }
        });
    }

    private void isiTableDaftarPeran() {
        daftarPeran = FrameUtama.getSekuritiService().semuaPeran();
        tblPeran.setModel(new PeranTableModel(daftarPeran));

    }

    private boolean validasi() {
        // Periksa Kalau Kode Kosong tampilkan Message Box
        if (txtNama.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Kode Harus di isi", "Field Harus di isi", JOptionPane.ERROR_MESSAGE);
            txtNama.requestFocus();
            return false;
        }
        // Periksa Kalau Nama Kosong tampilkan Message Box
        if (txtDeskripsi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nama Harus di isi", "Field Harus di isi", JOptionPane.ERROR_MESSAGE);
            txtDeskripsi.requestFocus();
            return false;
        }

        return true;
    }

    private void kondisiAwal() {
        txtNama.setEnabled(false);
        txtDeskripsi.setEnabled(false);

        tblPeran.setEnabled(true);
        buttonPanelMaster1.kondisiAwal();

    }

    public void kondisiTambah() {
        //hilangkan Pilihan Peran
        pilihanPeran = null;
        //hilangkan Pilihan di table
        tblPeran.clearSelection();

        txtNama.setText("");
        txtDeskripsi.setText("");

        txtNama.requestFocus();
        txtNama.setEnabled(true);
        txtDeskripsi.setEnabled(true);

        tblPeran.setEnabled(false);
    }

    public void kondisiEdit() {
        txtDeskripsi.requestFocus();
        txtNama.setEnabled(false);
        txtDeskripsi.setEnabled(true);

        tblPeran.setEnabled(false);

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
        txtNama = new javax.swing.JTextField();
        txtDeskripsi = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeran = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        buttonPanelMaster1 = new com.artivisi.pos.ui.toolbar.ButtonPanelMaster();

        setClosable(true);
        setTitle("Master Produk");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Form"));

        jLabel3.setText("Nama");

        jLabel4.setText("Deskripsi");

        txtDeskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeskripsiActionPerformed(evt);
            }
        });

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama"
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(150);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(150);

        jTabbedPane1.addTab("Pengguna", jScrollPane2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama", "Insert", "Update", "Delete"
            }
        ));
        jScrollPane3.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setMinWidth(100);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(100);
        jTable2.getColumnModel().getColumn(2).setMinWidth(40);
        jTable2.getColumnModel().getColumn(2).setMaxWidth(40);
        jTable2.getColumnModel().getColumn(3).setMinWidth(40);
        jTable2.getColumnModel().getColumn(3).setMaxWidth(40);
        jTable2.getColumnModel().getColumn(4).setMinWidth(40);
        jTable2.getColumnModel().getColumn(4).setMaxWidth(40);

        jTabbedPane1.addTab("Menu", jScrollPane3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(352, 352, 352))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtDeskripsi, txtNama});

        jTabbedPane1.getAccessibleContext().setAccessibleName("tab 1");

        tblPeran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Deskripsi"
            }
        ));
        tblPeran.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPeran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeran);
        tblPeran.getColumnModel().getColumn(0).setMinWidth(100);
        tblPeran.getColumnModel().getColumn(0).setMaxWidth(100);

        jLabel1.setText("Search Character");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(buttonPanelMaster1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonPanelMaster1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDeskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeskripsiActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtDeskripsiActionPerformed

    private void tblPeranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeranMouseClicked
//        System.out.println("di Klik table nya");
}//GEN-LAST:event_tblPeranMouseClicked

    private class PeranTableModel extends AbstractTableModel{
        private List<Peran> daftarPeran;

        public PeranTableModel(List<Peran> daftarPeran) {
            this.daftarPeran = daftarPeran;
        }

        public int getRowCount() {
            return daftarPeran.size();
        }

        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int col) {
            switch(col){
                case 0 : return "Key";
                case 1 : return "Value";
                default : return "";
            }

        }

        public Object getValueAt(int row, int col) {
            Peran p = daftarPeran.get(row);
            switch(row){
                case 0 : return p.getId();
                case 1 : return p.getDeskripsi();
                default : return "";
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.artivisi.pos.ui.toolbar.ButtonPanelMaster buttonPanelMaster1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tblPeran;
    private javax.swing.JTextField txtDeskripsi;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
