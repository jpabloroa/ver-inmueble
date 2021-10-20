/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sources;

import com.components.TourComponent;
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
@WebServlet(name = "Tour", urlPatterns = {"/recorrido-virtual"})
public class Tour extends HttpServlet {

    /**
     *
     */
    TourComponent json;

    /**
     *
     */
    private ArrayList<TourComponent.instance> images;

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

        String tourStepString = request.getParameter("tourStep");
        String tourBtnPressed = request.getParameter("tourBtnPressed");

        if (tourBtnPressed == null) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(tourInit(usuario.instanciaSolicitada));
            out.flush();
        } else {
            if (tourStepString != null) {
                int tourStep = Integer.parseInt(tourStepString);
                if (tourStep >= 0 && tourStep <= json.instances.size()) {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    Object[] rest = getNewSession(tourStep, tourBtnPressed);
                    out.print(rest[0].toString());
                    out.flush();
                }
            } else if (usuario.tourStep >= 0 && usuario.tourStep <= json.instances.size()) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                Object[] rest = getNewSession(usuario.tourStep, tourBtnPressed);
                out.print(rest[0].toString());
                usuario.tourStep = (int) rest[1];
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
    public String tourInit(String usuario) throws IOException {

        /**
         *
         */
        StringBuilder jsonResponse = new StringBuilder();
        BufferedReader jsonReadBuffer = new BufferedReader(new InputStreamReader(MainResponse.context.getResourceAsStream("/META-DATA/user/component/" + usuario + "/component/tour/component/tour.component.json")));
        while (jsonReadBuffer.ready()) {
            jsonResponse.append(String.valueOf((char) jsonReadBuffer.read()));
        }
        json = new Gson().fromJson(jsonResponse.toString(), TourComponent.class);

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
        return json.getTourHTML(htmlResponse.toString(), MainResponse.context.getContextPath(), usuario);
    }

    /**
     *
     */
    Object[] getNewSession(int step, String btnPressed) {
        int tourStep = step;
        switch (btnPressed) {
            case "next":
                if (tourStep < json.instances.size() - 1) {
                    tourStep++;
                }
                break;
            case "previous":
                if (tourStep > 0) {
                    tourStep--;
                }
                break;
        }
        Map<String, Object> options = new LinkedHashMap<>();
        options.put("title", json.instances.get(tourStep).title);
        options.put("image", json.instances.get(tourStep).image);
        options.put("bntProp", json.instances.get(tourStep).properties);

        return new Object[]{new Gson().toJson(options), tourStep};
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
