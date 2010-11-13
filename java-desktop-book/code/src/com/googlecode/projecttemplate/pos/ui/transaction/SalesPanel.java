/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SalesPanel.java
 *
 * Created on Nov 7, 2010, 7:21:25 AM
 */

package com.googlecode.projecttemplate.pos.ui.transaction;

import com.googlecode.projecttemplate.pos.Main;
import com.googlecode.projecttemplate.pos.model.Sales;
import com.googlecode.projecttemplate.pos.model.SalesDetail;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author ifnu
 */
public class SalesPanel extends javax.swing.JInternalFrame {

    private Sales sales;
    private List<SalesDetail> salesDetails = new ArrayList<SalesDetail>();
    private List<Sales> salesList;
    private static Logger log = Logger.getLogger(SalesPanel.class);

    /** Creates new form SalesPanel */
    public SalesPanel() {
        initComponents();
        tblSalesDetail.setAutoCreateColumnsFromModel(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalesDetail = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtProductId = new javax.swing.JTextField();
        btnLookupProduct = new javax.swing.JButton();
        lblTotal = new java.awt.Label();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudoor.png"))); // NOI18N
        btnExit.setText("Keluar");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuCancel.png"))); // NOI18N
        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuSave.png"))); // NOI18N
        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudelete.png"))); // NOI18N
        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuManuaEdit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuNew.png"))); // NOI18N
        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuFind.png"))); // NOI18N
        btnSearch.setText("Cari");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblSalesDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Harga Satuan", "Kuantitas", "Sub Total"
            }
        ));
        jScrollPane1.setViewportView(tblSalesDetail);

        jLabel1.setText("Kode Barang");

        txtProductId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductIdActionPerformed(evt);
            }
        });

        btnLookupProduct.setText("...");
        btnLookupProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLookupProductActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Courier New", 1, 24));
        lblTotal.setText("Rp. 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLookupProduct)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnCancel, btnDelete, btnEdit, btnExit, btnSave, btnSearch});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnEdit)
                    .addComponent(btnSearch)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLookupProduct))
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnCancel, btnDelete, btnEdit, btnExit, btnSave, btnSearch});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearForm(){
        txtProductId.setText("");
        lblTotal.setText("Rp. 0");
    }

    private void enableForm(boolean status){
        txtProductId.setEnabled(status);
        btnLookupProduct.setEnabled(status);
        tblSalesDetail.setEnabled(status);
    }

    private boolean validateForm(){
        if(salesDetails==null || salesDetails.isEmpty()){
            JOptionPane.showMessageDialog(this, "Transaksi tidak boleh kosong!"
                    ,"Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void loadFormToModel(){
        sales.
    }

    private void refreshTable(){
        tblSalesDetail.setModel(new SalesDetailTableModel(salesDetails));
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Main.getFrame().salesPanel = null;
        dispose();
}//GEN-LAST:event_btnExitActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearForm();
        enableForm(false);
        //pengaturan tombol
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);
        btnCancel.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(validateForm()){
            if(sales == null){
                sales = new Sales();
            }
            loadFormToModel();
            try{
                Main.getSalesService().save(sales);
                clearForm();
                refreshTable();
                enableForm(false);
                //pengaturan tombol
                btnDelete.setEnabled(false);
                btnAdd.setEnabled(true);
                btnCancel.setEnabled(false);
                btnEdit.setEnabled(false);
                btnSave.setEnabled(false);
            } catch(Exception ex){
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data gagal disimpan!"
                        ,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(sales!=null){
            try{
                Main.getSalesService().delete(sales);
                clearForm();
                sales = null;
                refreshTable();
                enableForm(false);
                //pengaturan tombol
                btnDelete.setEnabled(false);
                btnAdd.setEnabled(true);
                btnCancel.setEnabled(false);
                btnEdit.setEnabled(false);
                btnSave.setEnabled(false);
            } catch(Exception ex){
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data masih digunakan tidak bisa dihapus!"
                        ,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(sales!=null){
            enableForm(true);
            btnDelete.setEnabled(false);
            btnAdd.setEnabled(false);
            btnCancel.setEnabled(true);
            btnEdit.setEnabled(false);
            btnSave.setEnabled(true);
        }
}//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        clearForm();
        enableForm(true);
        //pengaturan tombol
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(false);
        btnCancel.setEnabled(true);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
}//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductIdActionPerformed
        
    }//GEN-LAST:event_txtProductIdActionPerformed

    private void btnLookupProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLookupProductActionPerformed
        
    }//GEN-LAST:event_btnLookupProductActionPerformed

    private class SalesDetailTableModel extends AbstractTableModel{

        private List<SalesDetail> salesDetails;

        SalesDetailTableModel(List<SalesDetail> salesDetails) {
            this.salesDetails = salesDetails;
        }

        public int getRowCount() {
            return salesDetails.size();
        }

        public int getColumnCount() {
            return 5;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            SalesDetail s = salesDetails.get(rowIndex);
            switch(columnIndex){
                case 0: return s.getProduct().getId();
                case 1: return s.getProduct().getName();
                case 2: return s.getPrice();
                case 3: return s.getQuantity();
                case 4: return s.getSubtotal();
                default: return "";
            }
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLookupProduct;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label lblTotal;
    private javax.swing.JTable tblSalesDetail;
    private javax.swing.JTextField txtProductId;
    // End of variables declaration//GEN-END:variables

}
