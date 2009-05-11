/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.util;

import java.awt.Component;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author ifnu
 */
public class BigDecimalRenderer extends JFormattedTextField implements TableCellRenderer {

    public BigDecimalRenderer() {
        setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        setAlignmentY(JFormattedTextField.RIGHT_ALIGNMENT);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof BigDecimal){
            try {
                setValue(value);
                commitEdit();
                return this;
            } catch (ParseException ex) {
                Logger.getLogger(BigDecimalRenderer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this;
    }

}
