/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import com.components.LandingComponent;
import com.google.gson.Gson;
import com.sources.Landing;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Juan Pablo - Roverin Technologics
 */
public class Test3 {

    public void algo(){
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Document htmlResponse_htmlFile = Jsoup.parse("<!DOCTYPE html>\n"
//                + "<html lang=\"en\">\n"
//                + "<head>\n"
//                + "    <meta charset=\"UTF-8\">\n"
//                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
//                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
//                + "    <link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\">\n"
//                + "    <script type=\"module\" src=\"./app.script.js\"></script>\n"
//                + "    <link rel=\"stylesheet\" href=\"app.style.css\">\n"
//                + "    <title>P&aacute;gina Principal</title>\n"
//                + "</head>\n"
//                + "<body>\n"
//                + "    <div id=\"main\" class=\"main\"></div>\n"
//                + "</body>\n"
//                + "</html>");
//        Element main = htmlResponse_htmlFile.head();
//        main.append("<link rel=\"yono se pa\" href=\"FUNCIONOOOO\">");
//        Element body = htmlResponse_htmlFile.body();
//        body.attr("style", "ey nooooooOOOOOOO");
//        Element hug = htmlResponse_htmlFile.getElementById("main");
//        hug.html("<p>FUNCIONOOOO</p>");
        System.out.println(new com.components.GalleryComponent().getGalleryHTML("<html><head><head><body><div id='app-module'></div><body</html>", "no-context", "instance"));
//        String jsonexample = "{\n"
//                + "    \"background\": \"https://drive.google.com/uc?export=view&id=1ioYHUQhLnGwNxCNe3CR8iZjZF70Co1h9\",\n"
//                + "    \"header\": [{\n"
//                + "        \"link\": \"\",\n"
//                + "        \"title\": \"Edificio Sotavento\",\n"
//                + "        \"subtitle\": \"Nuevo proyecto\",\n"
//                + "        \"mainPhoto\": \"https://drive.google.com/uc?export=view&id=1ioYHUQhLnGwNxCNe3CR8iZjZF70Co1h9\",\n"
//                + "        \"upperPhoto\": \"https://drive.google.com/uc?export=view&id=1l9khySfW67nmZ_Ca1jSxGl2rbMwcI2tr\"\n"
//                + "    }],\n"
//                + "    \"linkers\": [\n"
//                + "        {\n"
//                + "            \"element\": \"location\",\n"
//                + "            \"cssStyle\": \"location\",\n"
//                + "            \"indexedLink\" : false,\n"
//                + "            \"link\": \"https://goo.gl/maps/bmbkrZif69y6yL2Q8\",\n"
//                + "            \"title\": \"C&oacute;mo llegar al proyecto\",\n"
//                + "            \"imgSource\": \"https://drive.google.com/uc?export=view&id=10DpHHhb7DhKNOJ5URJu-aHJt6SJV92yD\"\n"
//                + "        },\n"
//                + "        {\n"
//                + "            \"element\": \"whatsapp\",\n"
//                + "            \"cssStyle\": \"whatsapp\",\n"
//                + "            \"indexedLink\" : false,\n"
//                + "            \"link\": \"https://wa.me/573175526429?text=¡Hola!%20Quiero%20conocer%20el%20proyecto\",\n"
//                + "            \"title\": \"Hable con un asesor\",\n"
//                + "            \"imgSource\": \"https://drive.google.com/uc?export=view&id=1zILgNv5NNVJ6eQODq4H9EzpoW7XhuD9t\"\n"
//                + "        },\n"
//                + "        {\n"
//                + "            \"element\": \"gallery\",\n"
//                + "            \"cssStyle\": \"gallery\",\n"
//                + "            \"indexedLink\" : false,\n"
//                + "            \"link\": \"https://www.youtube.com/watch?v=qtiElvmH5qM\",\n"
//                + "            \"title\": \"Galer&iacute;a de im&aacute;genes\",\n"
//                + "            \"imgSource\": \"https://drive.google.com/uc?export=view&id=13mgWZ-ThTYbtLzfv-RRLCPLZZUn8LM9d\"\n"
//                + "        },\n"
//                + "        {\n"
//                + "            \"element\": \"proyects\",\n"
//                + "            \"cssStyle\": \"proyects\",\n"
//                + "            \"indexedLink\" : false,\n"
//                + "            \"link\": \"https://www.nuestrosproyectos.com.co/proyecto-edificio-sotavento/\",\n"
//                + "            \"title\": \"Conozca nuestros proyectos\",\n"
//                + "            \"imgSource\": \"https://drive.google.com/uc?export=view&id=1Fd693k4nhkbGN8f4WtWthg5Q935KBBwk\"\n"
//                + "        }\n"
//                + "    ],\n"
//                + "    \"footer\": [{\n"
//                + "        \"link\": \"https://jpabloroa.github.io/index.html\",\n"
//                + "        \"imgSource\": \"https://drive.google.com/uc?export=view&id=16iwTbMoqSnSSoKl7kbcRJzZUkwANcDdf\"\n"
//                + "    }]\n"
//                + "}";
//
//        LandingComponent lan = new Gson().fromJson(jsonexample, LandingComponent.class);
////        data dat = new Gson().fromJson("{\"contenido\":\"hola\",\"link\":[{\"css\":\"nulangas\"}]}", data.class);
//        System.out.println(lan.setLandingBodyConf());
//        System.out.println(dat.link.get(0).css);
//        System.out.println(jsonexample);

    }

    class data {

        String contenido;
        List<linker> link;

        class linker {

            String css;
        }
    }

}
