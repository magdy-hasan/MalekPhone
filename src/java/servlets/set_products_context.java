/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.category;
import classes.phone;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class set_products_context extends HttpServlet {
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
        /*System.out.println("\n\nin context init");
        // get all category
        ConcurrentHashMap allCA = null;
        try {
            allCA = category.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(set_products_context.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("allCA", allCA);
        
        // get all phones
        ConcurrentHashMap<Integer,phone> allPH = null;
        int category_t = -1;
        if(null != request.getParameter("category_type")){
            category_t = Integer.parseInt((String) request.getParameter("category_type"));
        }
        try {
            allPH = phone.getAll(category_t);
        } catch (SQLException ex) {
            Logger.getLogger(set_products_context.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("allPH", allPH);
        request.getRequestDispatcher("view_cate.jsp").forward(request, response);
    */
    }
}
