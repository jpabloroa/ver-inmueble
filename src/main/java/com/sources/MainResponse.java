/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sources;

import com.tagreader.Reader;
import com.tagreader.Reader.Tag;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "MainResponse", urlPatterns = {"/ver/*"})
public class MainResponse extends HttpServlet {

    private boolean validation = false;
    private StringBuffer res;
    private PrintWriter out;
    public static ServletContext context;
    public static String JSONResponse;

    private RequestDispatcher rd;

    public class Usuario {

        /**
         *
         */
        String instanciaSolicitada;
        String sesionSolicitada;
        String nombre;
        String correo;
        String celular;

        /**
         *
         */
        int galleryStep = 0;
        int tourStep = 0;

    }
    private final Reader reader = new Reader();
    private ArrayList<Tag> tags;

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

        /**
         *
         */
        context = getServletContext();
        res = new StringBuffer();
        out = response.getWriter();

        /**
         *
         */
        ArrayList<String> urlParams = getURLParams(request.getPathInfo().substring(1));

        /**
         *
         */
        Usuario usuario = new Usuario();

        if (urlParams.size() > 0) {
            usuario.instanciaSolicitada = urlParams.get(0).toUpperCase();
            if (urlParams.size() > 1) {
                usuario.sesionSolicitada = urlParams.get(1).toLowerCase();
            } else {
                usuario.sesionSolicitada = "principal";
            }
        } else {
            usuario.instanciaSolicitada = "DEFAULT";
            usuario.sesionSolicitada = "principal";
        }

        /**
         *
         */
        HttpSession misession = request.getSession(true);
        misession.setAttribute("user", usuario);

        /**
         *
         */
        validation = true;
        /**
         *
         */

        /**
         *
         */
        if (!validation) {
            rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
            throw new IOException(" ¡ La instancia " + usuario.instanciaSolicitada + " no fue encontrada !");
        }

        /**
         *
         */
        switch (usuario.sesionSolicitada) {

            case "testing":
                rd = request.getRequestDispatcher("/inmueble.html");
                rd.forward(request, response);
                break;

            case "principal":
                rd = request.getRequestDispatcher("/principal");
                rd.forward(request, response);
                break;

            case "recorrido-virtual":
                rd = request.getRequestDispatcher("/recorrido-virtual");
                rd.forward(request, response);
                break;

            case "galeria":
                rd = request.getRequestDispatcher("/galeria");
                rd.forward(request, response);
                break;
            default:
                if (usuario.instanciaSolicitada == null) {
                    rd = request.getRequestDispatcher("/inicio");
                    rd.forward(request, response);
                } else {
                    rd = request.getRequestDispatcher("/principal");
                    rd.forward(request, response);
                }
                break;
        }

    }

// <editor-fold defaultstate="collapsed" desc="Funciones">
    /**
     *
     */
    private ArrayList<String> getURLParams(String URLPath) {
        String path = URLPath;
        String auxiliar = "";
        ArrayList<String> respuesta = new ArrayList<>();
        for (int i = 0; i < path.length(); i++) {
            if ("/".equals(path.substring(i, i + 1))) {
                respuesta.add(auxiliar);
                auxiliar = "";
            } else {
                auxiliar += path.substring(i, i + 1);
            }
        }
        respuesta.add(auxiliar);
        return respuesta;
    }
    // </editor-fold>

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods">
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
