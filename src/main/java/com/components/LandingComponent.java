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
public class LandingComponent {
    // <editor-fold defaultstate="collapsed" desc="Clase LandingConf">

    /**
     *
     */
    String backgroundColor;
    String backgroundImage;
    String favicon;
    String title;
    String scriptSheet;
    String styleSheet;
    List<header> header;
    List<linker> linkers;
    List<footer> footer;

    /**
     *
     * @param htmlFile
     * @param context
     * @param SessionName
     * @return
     */
    public String getLandingHTML(String htmlFile, String context, String SessionName) {
        StringBuilder htmlResponse = new StringBuilder();
        Document htmlResponse_htmlFile = Jsoup.parse(htmlFile);
        Element head = htmlResponse_htmlFile.head();
        head.append(setLandingHeadConf(context,SessionName));
        Element main = htmlResponse_htmlFile.getElementById("app-module");
        main.html(setLandingBodyConf(context));
        htmlResponse.append(htmlResponse_htmlFile.html());
        return htmlResponse.toString();
    }

    /**
     *
     * @return
     */
    String setLandingHeadConf(String context,String SessionName) {
        StringBuilder content = new StringBuilder();
        content.append(setHead(context, SessionName));
        return content.toString();
    }

    /**
     *
     * @return
     */
    String setLandingBodyConf(String context) {
        StringBuilder content = new StringBuilder();
        content.append(setHeaderConf());
        content.append(setLinkersConf(context));
//        content.append(setFooterConf());
        return content.toString();
    }

    String setHead(String context, String SessionName) {
        StringBuilder respuesta = new StringBuilder();
        respuesta.append("<link rel='shortcut icon' href='").append(this.favicon).append("' type='image/x-icon'>");
        respuesta.append("<link rel='stylesheet' href='").append(context).append("/META-DATA/app/component/app.style.css' type='text/css'>");
        respuesta.append("<link rel='stylesheet' href='").append(context).append("/META-DATA/app/component/landing/component/landing.component.css' type='text/css'>");
        respuesta.append("<link rel='stylesheet' href='").append(context).append("/META-DATA/user/component/").append(SessionName).append("/component/landing/component/landing.component.css' type='text/css'>");
        respuesta.append("<script src='").append(context).append("/META-DATA/app/component/app.script.js' type='text/javascript'></script>");
        respuesta.append("<script src='").append(context).append("/META-DATA/app/component/landing/component/landing.component.js' type='text/javascript'></script>");
        respuesta.append("<title>").append(title).append("</title>");
        return respuesta.toString();
    }

    /**
     *
     * @return
     */
    String setHeaderConf() {
        header head = this.header.get(0);
        StringBuilder respuesta = new StringBuilder();
        respuesta.append("<div id='landing-header-main' class='landing-header-main'>")
                .append("<a id='landing-header-link' class='landing-header-link' href='").append(head.link).append("'>")
                .append("<div id='landing-header-photo-container' class='landing-header-photo-container'>")
                .append("<img id='landing-header-photo' class='landing-header-photo' src='").append(head.mainPhoto).append("'>")
                .append("</div>")
                .append("<h1 id='landing-header-subtitle' class='landing-header-subtitle'>").append(head.subtitle).append("</h1>")
                .append("<h1 id='landing-header-title' class='landing-header-title'>").append(head.title).append("</h1>")
                .append("</a>")
                .append("</div>");
        return respuesta.toString();
    }

    /**
     *
     * @return
     */
    String setLinkersConf(String context) {
        linker link = null;
        StringBuilder respuesta = new StringBuilder();
        String indexed = "";
        respuesta.append("<div id='landing-link-main' class='landing-link-main'>");
        for (int i = 0; i < this.linkers.size(); i++) {
            link = this.linkers.get(i);
            if (link.indexedLink) {
                indexed = context + link.link;
            } else {
                indexed = link.link;
            }
            String value = link.element, cssStyle = link.cssStyle;
            respuesta.append("<a id='landing-link-").append(value).append("-link' class='landing-link-link ").append(cssStyle).append("-link' href='").append(indexed).append("'>")
                    .append("<div id='landing-link-").append(value).append("-main' class='landing-link-container ").append(cssStyle).append("-link'>")
                    .append("<img id='landing-link-").append(value).append("-photo' class='landing-link-photo ").append(cssStyle).append("-link' src='").append(link.imgSource).append("'>")
                    .append("<h1 id='landing-link-").append(value).append("-title' class='landing-link-title ").append(cssStyle).append("-link'>").append(link.title).append("</h1>")
                    .append("</div></a>");
        }
        respuesta.append("</div>");
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
    class header {

        /**
         *
         */
        String link;
        public String title;
        String subtitle;
        String mainPhoto;
        String upperPhoto;
    }

    class linker {

        /**
         *
         */
        String element;
        String cssStyle;
        boolean indexedLink;
        String link;
        String title;
        String imgSource;

    }

    class footer {

        /**
         *
         */
        String link;
        String imgSource;

    }
}// </editor-fold>
