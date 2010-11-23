/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.projecttemplate.pos.server;

import com.googlecode.projecttemplate.pos.util.MD5FileHashUtil;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import com.sun.net.httpserver.Headers;
import java.util.ArrayList;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author ifnu
 */
public class XmlServlet implements HttpHandler {

    private static final Logger LOGGER = Logger.getLogger(XmlServlet.class);
    private static final String TERMOS_FOLDER = "/opt/termos";
    private static final String LIB_FOLDER = "/opt/termos/lib";
    private String[] jars;

    public XmlServlet() {
        try {
            //ambil jar apa saja yang diperlukan oleh
            Properties p = new Properties();
            p.load(getClass().getResourceAsStream("/com/googlecode/projecttemplate.pos.server/client-jars.properties"));
            String jarString = p.getProperty("client-jar");
            jars = jarString.split(",");
        } catch (IOException ex) {
            LOGGER.error("client-jars.properties tidak ditemukan!",ex);
        }
    }
    
    public void handle(HttpExchange he) throws IOException {
        LOGGER.info("Request xml dari :" + he.getRequestURI().getHost());
        String servletPath = he.getHttpContext().getPath();
        if (servletPath.startsWith("/")) {
            servletPath = servletPath.substring(1, servletPath.length());
        }
        Headers headers = he.getRequestHeaders();
        List<String> contentDisposition = new ArrayList<String>();
        contentDisposition.add("attachment; filename=arsip.jnlp");
        headers.put("Content-Disposition", contentDisposition);
        List<String> contentType = new ArrayList<String>();
        contentType.add("application/x-java-jnlp-file");
        headers.put("Content-Type", contentType);

        BufferedWriter writer = new BufferedWriter(new PrintWriter(he.getResponseBody()));
        //baca dari jar dan buatkan metadatanya
        writer.write(getMetaData());
        writer.close();
    }
    
    /**
     * daftar jar yang diperlukan client
     * @return 
     */
    public String getMetaData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        builder.append("<pos-app>\n");
        for (String jar : jars) {
            File jarFile = getJarFile(jar);
            byte[] fileContent = getByte(jarFile);
            String md5 = MD5FileHashUtil.createChecksum(fileContent);
            String jarTag = "  <jar href=\""+ jarFile.getName()
                    + "\" md5=\"" + md5
                    + "\" size=\"" +jarFile.length()
                    + "\" timestamp=\"" + jarFile.lastModified() + "\"/>\n";
            builder.append(jarTag);
        }
        builder.append("</termos-app>\n");
        return builder.toString();
    }
    
    private byte[] getByte(File f){
        InputStream fis = null;
        try {
            fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream complete = new ByteArrayOutputStream();
            int numRead;
            while ((numRead = fis.read(buffer)) != -1) {
                complete.write(buffer, 0, numRead);
            }
            fis.close();
            return complete.toByteArray();
        } catch (FileNotFoundException ex) {
            LOGGER.error(ex);
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
        return null;
    }
    public File getJarFile(String name) {
        File jarFile = new File(LIB_FOLDER + File.separatorChar + name);
        if (!jarFile.exists()) {
            jarFile = new File(TERMOS_FOLDER + File.separatorChar + name);
        }
        if (!jarFile.exists()) {
            //Develomment mencari jar di dalam dist folder
            jarFile = new File(System.getProperty("user.dir") + File.separatorChar + "dist" + File.separatorChar + name);
        }
        if (!jarFile.exists()) {
            //Develomment mencari jar di dalam dist folder
            jarFile = new File(System.getProperty("user.dir") + File.separatorChar + "dist" + File.separatorChar + "lib" + File.separatorChar + name);
        }
        return jarFile;
    }

}
