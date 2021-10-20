/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Juan Pablo - Roverin Technologics
 */
public class Reader implements Constants {

    //<editor-fold defaultstate="collapsed" desc=" Código generado automáticamente"> 
    private Object getTag(String tagContent) throws IOException {
        String[] result = tagContent.split("&");
        if (result.length > 1) {
            return new Tag(result[0], result[1]);
        } else {
            throw new IOException(" ¡ Error de sintaxis ! ");
        }
    }

    /**
     *
     */
    private ArrayList<Tag> tags;
    private FileReader lector;
    private BufferedReader readBuffer;

    public class Tag {

        public String name;
        public String state;
        public String content;

        public Tag(String name, String state) {
            this.name = name;
            this.state = state;

        }

        public void setContent(String content) {
            this.content = content;
        }
    }
//</editor-fold> 
    /**
     * Función Read
     * 
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ArrayList<Tag> read(InputStream file) throws FileNotFoundException, IOException {
//<editor-fold defaultstate="collapsed" desc="">    

        /**
         *
         */
        readBuffer = new BufferedReader(new InputStreamReader(file));

        /**
         *
         */
        StringBuilder res = new StringBuilder();
        while (readBuffer.ready()) {
            res.append(String.valueOf((char) readBuffer.read()));
        }

        /**
         *
         */
        res.append("...");
        String raster = res.toString();
        String auxiliar = "";

        /**
         *
         */
        boolean isOpen = false;
        String tagContent = "";
        StringBuilder content = new StringBuilder();

        /**
         *
         */
        Tag tg = null;
        tags = new ArrayList<>();

        /**
         * Lector
         */
        for (int i = 0; i < raster.length() - 3; i++) {
            auxiliar = raster.substring(i, i + 3);
            if (auxiliar.equals("<?%")) {
                i += 3;
                if (isOpen) {
                    tagContent = content.toString();
                }
                content.setLength(0);
            } else if (auxiliar.equals("%?>")) {
                i += 3;
                tg = (Tag) getTag(content.toString());
                if (tg.state.equals(TAG_OPEN)) {
                    isOpen = true;

                } else if (tg.state.equals(TAG_CLOSE)) {
                    isOpen = false;
                    tg.content = tagContent;
                    tags.add(tg);
                }
                content.setLength(0);
            }
            content.append(raster.substring(i, i + 1));

        }
       
        return tags;
          
    }
//</editor-fold> 
}
