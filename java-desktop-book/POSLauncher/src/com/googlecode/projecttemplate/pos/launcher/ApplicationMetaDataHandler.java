/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.projecttemplate.pos.launcher;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author ifnu
 */
public class ApplicationMetaDataHandler extends DefaultHandler{

    private List<JarData> jars = new ArrayList<JarData>();
    private String revision;
    private SqlData sqlData;

    private String value;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("revision")){
            revision = value;
        } 
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("jar")){
            String jar = attributes.getValue("href");
            JarData jarData = new JarData();
            if(jar!=null && !jar.equals("") && Utils.fileExtention(jar).equalsIgnoreCase("jar")){
                jarData.setName(jar);
            }
            jarData.setMd5(attributes.getValue("md5"));
            try{
                jarData.setSize(Long.valueOf(attributes.getValue("size")));
            } catch(NumberFormatException ex){
                jarData.setSize(0l);
            }
            try {
                jarData.setTimestamp(Long.valueOf(attributes.getValue("timestamp")));
            } catch (NumberFormatException ex) {
                jarData.setTimestamp(0l);
            }
            jars.add(jarData);
        } else if(qName.equalsIgnoreCase("sql")){
            String jar = attributes.getValue("href");
            SqlData sql = new SqlData();
            if(jar!=null && !jar.equals("") && Utils.fileExtention(jar).equalsIgnoreCase("jar")){
                sql.setName(jar);
            }
            sql.setMd5(attributes.getValue("md5"));
            try{
                sql.setSize(Long.valueOf(attributes.getValue("size")));
            } catch(NumberFormatException ex){
                sql.setSize(0l);
            }
            try {
                sql.setTimestamp(Long.valueOf(attributes.getValue("timestamp")));
            } catch (NumberFormatException ex) {
                sql.setTimestamp(0l);
            }            sqlData = sql;
        }
    }

    public List<JarData> getJars() {
        return jars;
    }

    public void setJars(List<JarData> jars) {
        this.jars = jars;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public SqlData getSqlData() {
        return sqlData;
    }

    public void setSqlData(SqlData sqlData) {
        this.sqlData = sqlData;
    }

    public static class JarData{
        private String name;
        private String md5;
        private Long size;
        private Long timestamp;

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }
        
    }
    public static class SqlData{
        private String name;
        private String md5;
        private Long size;
        private Long timestamp;

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

    }

}
