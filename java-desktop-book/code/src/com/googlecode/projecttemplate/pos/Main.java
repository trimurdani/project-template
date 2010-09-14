/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.projecttemplate.pos;

/**
 *
 * @author ifnu
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        int total = 0;
        for(int i=0;i<100;i++){
            if(i%5 == 0){
                total+=i;
            }
        }
        System.out.println(total);

        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    }
}


























