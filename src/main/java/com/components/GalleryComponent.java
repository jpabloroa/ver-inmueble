/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.components;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Juan Pablo - Roverin Technologics
 */
public class GalleryComponent {
    // <editor-fold defaultstate="collapsed" desc="Clase GalleryConf">

    /**
     *
     */
    String favicon;
    String title;
    String scriptSheet;
    String styleSheet;
    public List<image> images;
    public String contact_link;
    List<footer> footer;

    /**
     *
     * @param htmlFile
     * @param context
     * @param SessionName
     * @return
     */
    public String getGalleryHTML(String htmlFile, String context, String SessionName) {
        StringBuilder htmlResponse = new StringBuilder();
        Document htmlResponse_htmlFile = Jsoup.parse(htmlFile);
        Element head = htmlResponse_htmlFile.head();
        head.append(setGalleryHeadConf(context, SessionName));
        Element main = htmlResponse_htmlFile.getElementById("app-module");
        main.html(setGalleryBodyConf());
        htmlResponse.append(htmlResponse_htmlFile.html());
        return htmlResponse.toString();
    }

    /**
     *
     * @return
     */
    String setGalleryHeadConf(String context, String SessionName) {
        StringBuilder content = new StringBuilder();
        content.append(setHead(context, SessionName));
        return content.toString();
    }

    /**
     *
     * @return
     */
    String setGalleryBodyConf() {
        StringBuilder content = new StringBuilder();
        content.append(setGalleryConf());
        return content.toString();
    }

    String setHead(String context, String SessionName) {
        StringBuilder respuesta = new StringBuilder();
        respuesta.append("<link rel='shortcut icon' href='").append(this.favicon).append("' type='image/x-icon'>");
        respuesta.append("<link rel='stylesheet' href='").append(context).append("/META-DATA/app/component/app.style.css' type='text/css'>");
        respuesta.append("<link rel='stylesheet' href='").append(context).append("/META-DATA/app/component/gallery/component/gallery.component.css' type='text/css'>");
        respuesta.append("<link rel='stylesheet' href='").append(context).append("/META-DATA/user/component/").append(SessionName).append("/component/gallery/component/gallery.component.css' type='text/css'>");
        respuesta.append("<script src='").append(context).append("/META-DATA/app/component/app.script.js' type='text/javascript'></script>");
        respuesta.append("<script src='").append(context).append("/META-DATA/app/component/gallery/component/gallery.component.js' type='text/javascript'></script>");
        respuesta.append("<title>").append(title).append("</title>");
        return respuesta.toString();
    }

    /**
     *
     * @return
     */
    String setGalleryConf() {
        StringBuilder respuesta = new StringBuilder();
        respuesta.append("")
                .append("<div id='gallery-main-container' class='gallery-main-container'>")
                .append("<div id='gallery-main-image-container' class='gallery-main-image-container'>")
                .append("<img id='gallery-main-image' class='gallery-main-image'>")
                .append("<div id='gallery-main-title-container' class='gallery-main-title-container'>")
                .append("<a id='gallery-link-saber_mas' class='gallery-link-saber_mas'>")
                .append("<i id='gallery-link-whatsapp' class='gallery-icon-saber_mas icon-th-large'></i>")
                .append("</a>")
                .append("<p id='gallery-main-title' class='gallery-main-title'></p>")
                .append("<a id='gallery-link-contact' class='gallery-link-whatsapp' href='").append(this.contact_link).append("'>")
                .append("<i id='gallery-link-whatsapp' class='gallery-icon-whatsapp icon-whatsapp'></i>")
                .append("</a>")
                .append("</div>")
                .append("</div>")
                .append("<a id='gallery-next-button' type='button' value='Siguiente' class='gallery-button gallery-next-button' onclick='newGalleryImage(\"next\")'>&#10095;</a>")
                .append("<a id='gallery-previous-button' type='button' value='Anterior' class='gallery-button gallery-previous-button' onclick='newGalleryImage(\"previous\")'>&#10094;</a>")
                .append("</div>");
        return respuesta.toString();
    }

    /**
     *
     * @return
     */
    String setFooterConf() {
        footer foot = this.footer.get(0);
        StringBuilder respuesta = new StringBuilder();
        respuesta.append("<div id='footer' class='footer landing-footer tour-footer gallery-footer'>")
                .append("<a id='footer' class='footer-link landing-footer-link tour-footer-link gallery-footer-link' href='").append(foot.link).append("'>")
                .append("<img id='footer-main-photo' class='footer-main-photo' src='").append(foot.imgSource).append("'>")
                .append("</a>")
                .append("</div>");
        return respuesta.toString();
    }

    /**
     *
     */
    public class image {

        /**
         *
         */
        public String title;
        public String image;
        public String link;

    }

    /**
     *
     */
    class footer {

        /**
         *
         */
        String link;
        String imgSource;

    }
}// </editor-fold>
