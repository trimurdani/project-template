/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MasterSystemProperty.java
 *
 * Created on Apr 29, 2009, 10:25:26 AM
 */
package com.artivisi.pos.ui.master;

import com.artivisi.pos.model.master.SystemProperty;
import com.artivisi.pos.ui.frame.FrameUtama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kurusgw
 */
public class SystemPropertyPanel extends javax.swing.JInternalFrame {

    private List<SystemProperty> daftarSystemProperty;
    private SystemProperty pilihanSystemProperty;

    /** Creates new form MasterSystemProperty */
    public SystemPropertyPanel() {
        initComponents();

        initListener();
        kondisiAwal();
        buttonPanelMaster1.getBtnTambah().setEnabled(false);
        isiTableDaftarSystemProperty();
        tblSystemProperty.setAutoCreateColumnsFromModel(false);
    }

    private void initListener() {
        // Listener untuk table ketika table di Klik 
        tblSystemProperty.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent arg0) {
                //kalau tidak ada row yang di pilih maka akan menghasilkan -1
                if (tblSystemProperty.getSelectedRow() > -1) {
                    //ambil row yang di Pilihan
                    int row = tblSystemProperty.getSelectedRow();

                    pilihanSystemProperty = daftarSystemProperty.get(row);

                    txtKey.setText(pilihanSystemProperty.getId());
                    txtValue.setText(pilihanSystemProperty.getVal());

                    buttonPanelMaster1.getBtnEdit().setEnabled(true);
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

                //buat Object SystemProperty terlebih dahulu
                if (validasi()) {
                    //buat Object SystemProperty terlebih dahulu
                    if (pilihanSystemProperty == null) {
                        pilihanSystemProperty = new SystemProperty();
                    }

                    //ambil value kemudian dari text field kemudian di save ke dalam database
                    pilihanSystemProperty.setId(txtKey.getText());
                    pilihanSystemProperty.setVal(txtValue.getText());

                    //simpan ke database dengan Menggunakan Method Simpan di Object Service
                    FrameUtama.getMasterService().simpan(pilihanSystemProperty);

                    //Kembali Kondisi Awal
                    kondisiAwal();
                    //refresh table SystemProperty
                    isiTableDaftarSystemProperty();
                }
            }
        });
    }

    private void isiTableDaftarSystemProperty() {
        daftarSystemProperty = FrameUtama.getMasterService().semuaSystemProperty();
        tblSystemProperty.setModel(new SystemPropertyTableModel(daftarSystemProperty));

    }

    private boolean validasi() {
        // Periksa Kalau Kode Kosong tampilkan Message Box
        if (txtKey.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Kode Harus di isi", "Field Harus di isi", JOptionPane.ERROR_MESSAGE);
            txtKey.requestFocus();
            return false;
        }
        // Periksa Kalau Nama Kosong tampilkan Message Box
        if (txtValue.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nama Harus di isi", "Field Harus di isi", JOptionPane.ERROR_MESSAGE);
            txtValue.requestFocus();
            return false;
        }
        // Periksa Kalau HArga Kosong tampilkan Message Box

        return true;
    }

    private void kondisiAwal() {
        txtKey.setEnabled(false);
        txtValue.setEnabled(false);

        tblSystemProperty.setEnabled(true);
        buttonPanelMaster1.kondisiAwal();

    }

    public void kondisiTambah() {
        //hilangkan Pilihan SystemProperty
        pilihanSystemProperty = null;
        //hilangkan Pilihan di table
        tblSystemProperty.clearSelection();

        txtKey.setText("");
        txtValue.setText("");

        txtKey.requestFocus();
        txtKey.setEnabled(true);
        txtValue.setEnabled(true);

        tblSystemProperty.setEnabled(false);
    }

    public void kondisiEdit() {
        txtKey.requestFocus();
        txtKey.setEnabled(true);
        txtValue.setEnabled(true);

        tblSystemProperty.setEnabled(false);

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
        txtKey = new javax.swing.JTextField();
        txtValue = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSystemProperty = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        buttonPanelMaster1 = new com.artivisi.pos.ui.toolbar.ButtonPanelMaster();

        setClosable(true);
        setTitle("Master Produk");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Form"));

        jLabel3.setText("Key");

        jLabel4.setText("Value");

        txtValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValueActionPerformed(evt);
            }
        });

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
                    .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(355, 355, 355))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtKey, txtValue});

        tblSystemProperty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Key", "Value"
            }
        ));
        tblSystemProperty.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSystemProperty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSystemPropertyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSystemProperty);

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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValueActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtValueActionPerformed

    private void tblSystemPropertyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSystemPropertyMouseClicked
//        System.out.println("di Klik table nya");
}//GEN-LAST:event_tblSystemPropertyMouseClicked

    private class SystemPropertyTableModel extends AbstractTableModel{
        private List<SystemProperty> daftarSystemProperty;

        public SystemPropertyTableModel(List<SystemProperty> daftarSystemProperty) {
            this.daftarSystemProperty = daftarSystemProperty;
        }

        public int getRowCount() {
            return daftarSystemProperty.size();
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
            SystemProperty p = daftarSystemProperty.get(row);
            switch(row){
                case 0 : return p.getId();
                case 1 : return p.getVal();
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
    private javax.swing.JTable tblSystemProperty;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
