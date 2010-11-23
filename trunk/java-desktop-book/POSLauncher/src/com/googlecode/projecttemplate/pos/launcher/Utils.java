/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.projecttemplate.pos.launcher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author ifnu
 */
public class Utils {

    public static String fileExtention(String filename){
        int dotIndex = filename.lastIndexOf(".");
        if(dotIndex>=0 && dotIndex < filename.length() ){
            return filename.substring(dotIndex+1,filename.length());
        } else {
            return "";
        }
    }
    public static String callUrl(String url){
        try {
            return callUrl(new URL(url));
        } catch (MalformedURLException ex) {
        }
        return null;
    }
        public static String callUrl(URL url){
            if(url == null) return null;
            try {
                URLConnection connection = url.openConnection();

                InputStream dataInputStream = connection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                int ch;
                while((ch=dataInputStream.read())!=-1){
                    buffer.append((char)ch);
                }
                dataInputStream.close();
                return buffer.toString();
            } catch (Exception ex) {
            }
            return null;
        }

    /**
     * filename berisi full path file name
     * @param url
     * @param fileName
     */
    public static void writeFile(String url, String fileName){
        try {
            writeFile(new URL(url), fileName);
        } catch (MalformedURLException ex) {
        }
    }
    public static void writeFile(URL url, String fileName){
        if(url == null) return;
        try {
            URLConnection connection = url.openConnection();
            InputStream dataInputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(new File(fileName));
            byte[] bytes = new byte[1024];
            int data;
            while((data = dataInputStream.read(bytes))>0){
                outputStream.write(bytes, 0, data);
            }
            dataInputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
        }
        return;
    }


}
