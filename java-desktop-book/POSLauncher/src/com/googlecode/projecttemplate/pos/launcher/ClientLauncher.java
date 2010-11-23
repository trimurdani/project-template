/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.projecttemplate.pos.launcher;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import javax.swing.JFrame;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author ifnu
 */
public class ClientLauncher {

    private static final File JAR_FOLDER =  new File(System.getProperty("user.home")
            + File.separatorChar + ".pos" + File.separatorChar+"jar");

    public void checkUpdateFolder(){
        if(!JAR_FOLDER.exists()){
            JAR_FOLDER.mkdirs();
        }
        //Download jar setiap kali mau dijalankan
        downloadJar(JAR_FOLDER.getAbsolutePath());
        runApplication();
    }

    public void downloadJar(String jarDir){
        try {
            String xml = Utils.callUrl(getApplicationMetaDataUrl());
            //dapatkan url untuk dapetin application meta data xml
            ApplicationMetaDataHandler handler = new ApplicationMetaDataHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            byte[] bytes = xml.getBytes();
            parser.parse(new ByteArrayInputStream(bytes), handler);

            //dapetin jar
            for(ApplicationMetaDataHandler.JarData jarData : handler.getJars()){
                Utils.writeFile(getJarUrl(jarData.getName()), jarDir +
                        File.separatorChar  + jarData.getName());
            }
            //simpan xml

        } catch (Exception ex) {
        }
    }

    public void runApplication(){
        String os = System.getProperty("os.name").toLowerCase();
        String exec  =null;
        if(os.equals("mac os x") || os.equals("linux")){
            exec  = "java -cp " + JAR_FOLDER.getAbsolutePath()
                    + File.separatorChar + "*" + File.pathSeparatorChar
                    + " com.googlecode.projecttemplate.pos.Main";
        } else {
            exec  = "java -cp \"" + JAR_FOLDER.getAbsolutePath()
                    + File.separatorChar + "*\"" + File.pathSeparatorChar
                    + " com.googlecode.projecttemplate.pos.Main";
        }
        try {
            Runtime.getRuntime().exec(exec);
        } catch (IOException ex) {
        }
    }

    public Properties getServerProperty(){
        try {
            Properties p = new Properties();
            p.load(getClass().getResourceAsStream("/server.properties"));
            return p;
        } catch (IOException ex) {
        }
        return null;
    }

    public URL getApplicationMetaDataUrl() throws MalformedURLException{
        return new URL("http://" + getServerProperty().getProperty("server.ip") +
                    ":" +
                    getServerProperty().getProperty("server.port") +
                    "/app/application-meta-data.xml");
    }
    public URL getJarUrl(String jarName) throws MalformedURLException{
        return new URL("http://" + getServerProperty().getProperty("server.httpinvoker.host") +
                    ":" +
                    getServerProperty().getProperty("server.httpinvoker.port") +
                    "/app/" + jarName);
    }

    public static void main(String[] args) throws InterruptedException {
        final JFrame splash =  new NewSplash();
        new Thread(new Runnable() {

            public void run() {
                splash.setVisible(true);
            }
        }).start(); 

        ClientLauncher launcher = new ClientLauncher();
        launcher.checkUpdateFolder();
        Thread.sleep(4000l);
        splash.setVisible(false);
        splash.dispose();
    }
}
