/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.projecttemplate.pos;

import com.googlecode.projecttemplate.pos.service.SecurityService;
import com.googlecode.projecttemplate.pos.ui.FrameUtama;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ifnu
 */
public class Main {

    private static SecurityService securityService;
    private static FrameUtama frame;

    public static SecurityService getSecurityService() {
        return securityService;
    }

    public static FrameUtama getFrame() {
        return frame;
    }


    public static void main(String[] args) throws ClassNotFoundException {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext applicationContext =
                        new ClassPathXmlApplicationContext("applicationContext.xml");
                securityService = (SecurityService) applicationContext.getBean("securityService");
                frame = new FrameUtama();
                frame.setVisible(true);
            }
        });

    }
}


























