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
public class TourComponent {
    // <editor-fold defaultstate="collapsed" desc="Clase TourConf">

    /**
     *
     */
    String background;
    String favicon;
    String title;
    String scriptSheet;
    String styleSheet;
    public List<instance> instances;
    List<footer> footer;

    /**
     *
     * @param htmlFile
     * @param context
     * @param SessionName
     * @return
     */
    public String getTourHTML(String htmlFile, String context, String SessionName) {
        StringBuilder htmlResponse = new StringBuilder();
        Document htmlResponse_htmlFile = Jsoup.parse(htmlFile);
        Element head = htmlResponse_htmlFile.head();
        head.append(setTourHeadConf(context, SessionName));
        Element main = htmlResponse_htmlFile.getElementById("app-module");
        main.html(setTourBodyConf());
        htmlResponse.append(htmlResponse_htmlFile.html());
        return htmlResponse.toString();
    }

    /**
     *
     * @return
     */
    String setTourHeadConf(String context, String SessionName) {
        StringBuilder content = new StringBuilder();
        content.append(setHead(context, SessionName));
        return content.toString();
    }

    /**
     *
     * @return
     */
    String setTourBodyConf() {
        StringBuilder content = new StringBuilder();
        content.append(setTourConf());
        return content.toString();
    }

    String setHead(String context, String SessionName) {
        StringBuilder respuesta = new StringBuilder();
        respuesta.append("<link rel='shortcut icon' href='").append(this.favicon).append("' type='image/x-icon'>");
        respuesta.append("<link rel='stylesheet' href='").append(context).append("/META-DATA/app/component/app.style.css' type='text/css'>");
        respuesta.append("<link rel='stylesheet' href='").append(context).append("/META-DATA/app/component/tour/component/tour.component.css' type='text/css'>");
        respuesta.append("<link rel='stylesheet' href='").append(context).append("/META-DATA/user/component/").append(SessionName).append("/component/tour/component/tour.component.css' type='text/css'>");
        respuesta.append("<script src='").append(context).append("/META-DATA/app/component/app.script.js' type='text/javascript'></script>");
        respuesta.append("<script src='").append(context).append("/META-DATA/app/component/tour/component/tour.component.js' type='text/javascript'></script>");
        respuesta.append("<title>").append(title).append("</title>");
        return respuesta.toString();
    }

    /**
     *
     * @return
     */
    String setTourConf() {
        StringBuilder respuesta = new StringBuilder();
        respuesta.append("<div id='tour-main-container' class='tour-main-container'>")
                .append("<p id='tour-top-frame' class='tour-cover-frame tour-top-frame'>")
                .append("<h1 id='tour-main-title' class='tour-main-title'><h1>")
                .append("</p>")
                .append("<p id='tour-left-frame' class='tour-cover-frame tour-left-frame'></p>")
                .append("<p id='tour-right-frame' class='tour-cover-frame tour-right-frame'></p>")
                .append("<p id='tour-bottom-frame' class='tour-cover-frame tour-bottom-frame'></p>")
                .append("<img id='tour-main-image' class='tour-main-image'>")
                .append("<input id='tour-button_view_cen' class='tour-inputLayOut' type='button' onclick=\"newTourImage('cen')\" style='visibility: hidden;'>")
                .append("<input id='tour-button_view_izq' class='tour-inputLayOut' type='button' onclick=\"newTourImage('izq')\" style='visibility: hidden;'>")
                .append("<input id='tour-button_view_der' class='tour-inputLayOut' type='button' onclick=\"newTourImage('der')\" style='visibility: hidden;'>")
                .append("<input id='tour-button_view_bak' class='tour-inputLayOut' type='button' onclick=\"newTourImage('bak')\" value='Volver' style='top:4%;right:16%;visibility: hidden;'>")
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
    public class instance {

        /**
         *
         */
        public String type;
        public String title;
        public String image;
        public List<button> properties;

        public class button {

            public String id;
            public String visibility;
            public String top;
            public String left;

            public button(String id, String visibility, String top, String left) {
                this.id = id;
                this.visibility = visibility;
                this.top = top;
                this.left = left;
            }
        }

        public instance getStoredSession(String type) {
            switch (type) {
                case "alcoba":
//                    this.properties.add(new button());
                    break;
                default:
                    break;
            }
            return this;
        }
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
