/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sources;

import com.components.GalleryComponent;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan Pablo - Roverin Technologics
 */
@WebServlet(name = "Galeria", urlPatterns = {"/galeria"})
public class Galeria extends HttpServlet {

    /**
     *
     */
    GalleryComponent json;

    /**
     *
     */
    private ArrayList<GalleryComponent.image> images;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession misession = (HttpSession) request.getSession();

        MainResponse.Usuario usuario = (MainResponse.Usuario) misession.getAttribute("user");
        if (usuario.instanciaSolicitada == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }

        String galleryStepString = request.getParameter("galleryStep");
        String galleryBtnPressed = request.getParameter("galleryBtnPressed");

        if (galleryBtnPressed == null) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(galleryinit(usuario.instanciaSolicitada));
            out.flush();
        } else {
            if (galleryStepString != null) {
                int galleryStep = Integer.parseInt(galleryStepString);
                if (galleryStep >= 0 && galleryStep <= json.images.size()) {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    Object[] rest = getNewSession(galleryStep, galleryBtnPressed);
                    out.print(rest[0].toString());
                    out.flush();
                }
            } else if (usuario.galleryStep >= 0 && usuario.galleryStep <= json.images.size()) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                Object[] rest = getNewSession(usuario.galleryStep, galleryBtnPressed);
                out.print(rest[0].toString());
                usuario.galleryStep = (int) rest[1];
                misession.setAttribute("user", usuario);
                out.flush();
            }
        }

    }

    /**
     *
     * @param usuario
     * @return
     * @throws IOException
     */
    public String galleryinit(String usuario) throws IOException {

        /**
         *
         */
        StringBuilder jsonResponse = new StringBuilder();
        BufferedReader jsonReadBuffer = new BufferedReader(new InputStreamReader(MainResponse.context.getResourceAsStream("/META-DATA/user/component/" + usuario + "/component/gallery/component/gallery.component.json")));
        while (jsonReadBuffer.ready()) {
            jsonResponse.append(String.valueOf((char) jsonReadBuffer.read()));
        }
        json = new Gson().fromJson(jsonResponse.toString(), GalleryComponent.class);

        /**
         *
         */
        StringBuilder htmlResponse = new StringBuilder();
        BufferedReader htmlReadBuffer = new BufferedReader(new InputStreamReader(MainResponse.context.getResourceAsStream("/META-DATA/app/component/app.page.html")));
        while (htmlReadBuffer.ready()) {
            htmlResponse.append(String.valueOf((char) htmlReadBuffer.read()));
        }

        /**
         *
         */
        return json.getGalleryHTML(htmlResponse.toString(), MainResponse.context.getContextPath(), usuario);
    }

    /**
     *
     */
    Object[] getNewSession(int step, String btnPressed) {
        String vsb_bnext = "", vsb_bprevious = "";
        int galleryStep = step;
        switch (btnPressed) {
            case "next":
                if (galleryStep < json.images.size() - 1) {
                    galleryStep++;
                }
                break;
            case "previous":
                if (galleryStep > 0) {
                    galleryStep--;
                }
                break;
        }
        if (galleryStep == 0) {
            vsb_bnext = "visible";
            vsb_bprevious = "hidden";
        } else if (galleryStep > 0 && galleryStep < 0) {
            vsb_bnext = "visible";
            vsb_bprevious = "visible";
        } else if (galleryStep == json.images.size() - 1) {
            vsb_bnext = "hidden";
            vsb_bprevious = "visible";
        }
        Map<String, String> options = new LinkedHashMap<>();
        options.put("title", json.images.get(galleryStep).title);
        options.put("image", json.images.get(galleryStep).image);
        options.put("link", json.images.get(galleryStep).link);
        options.put("vsb_bnext", String.valueOf(vsb_bnext));
        options.put("vsb_bprevious", String.valueOf(vsb_bprevious));
        options.put("pValue", String.valueOf(galleryStep));

        return new Object[]{new Gson().toJson(options), galleryStep};
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
