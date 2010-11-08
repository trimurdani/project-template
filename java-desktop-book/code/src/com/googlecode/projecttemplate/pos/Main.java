/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.projecttemplate.pos;

import com.googlecode.projecttemplate.pos.service.SecurityService;
import com.googlecode.projecttemplate.pos.ui.MainFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ifnu
 */
public class Main {

    private static SecurityService securityService;
    private static MainFrame frame;

    public static SecurityService getSecurityService() {
        return securityService;
    }

    public static MainFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext applicationContext =
                        new ClassPathXmlApplicationContext("applicationContext.xml");
                securityService = (SecurityService) applicationContext.getBean("securityService");
                frame = new MainFrame();
                frame.setVisible(true);
            }
        });

    }
}


























