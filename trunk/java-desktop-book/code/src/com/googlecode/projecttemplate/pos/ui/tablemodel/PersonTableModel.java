/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.projecttemplate.pos.ui.tablemodel;

import com.googlecode.projecttemplate.pos.model.Person;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ifnu
 */
public class PersonTableModel extends AbstractTableModel{
    private static final long serialVersionUID = 1L;

    private List<Person> persons;

    public PersonTableModel(List<Person> persons) {
        this.persons = persons;
    }

    public int getRowCount() {
        return persons.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Person p = persons.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getId();
            case 1: return p.getName();
            case 2: return p.getBirthDate();
            default: return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0: return Long.class;
            case 1: return String.class;
            case 2: return Date.class;
            default: return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 1 || columnIndex ==2){
            return true;
        }
        return false;
    }



}
