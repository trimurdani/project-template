/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewSplash.java
 *
 * Created on Oct 21, 2009, 11:16:38 PM
 */

package com.googlecode.projecttemplate.pos.launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author ifnu
 */
public class NewSplash extends javax.swing.JFrame {

    /** Creates new form NewSplash */
    public NewSplash() {
        initComponents();
        final ImageIcon icon = new ImageIcon(getClass().getResource("/termos.jpg"));
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g){
                    g.drawImage(icon.getImage(), 0, 0, null);
            }
        };
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        panel.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        getContentPane().add(panel,BorderLayout.CENTER);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        setLocation(x, y);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        getContentPane().add(progressBar,BorderLayout.SOUTH);
        pack();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setUndecorated(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewSplash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}