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
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class updateCategory extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String go_to = "admincont.jsp";
        ServletContext context = request.getServletContext();
        ConcurrentHashMap<Integer, category> allCA = (ConcurrentHashMap) context.getAttribute("allCA");
        category ca = new category();
        // get category id
        int ca_id = Integer.parseInt(request.getParameter("caId"));
        ca.setId(ca_id);
        if ("delete".equals((String) request.getParameter("updateType"))) {
            ca.deleletCategory();
            phone ph = new phone();
            ph.setCategory_id(ca_id);
            ph.deleletPhonesWithCategoryId();
            allCA.remove(ca_id);
            go_to += "?update_message=CategoryDeletedSuccessfully";
        } else {
            // get newname
            String newName = request.getParameter("newName");
            // make a new catgeory
            ca.setName(newName);
            // updata this category in database
            if("changeName".equals((String) request.getParameter("updateType")))
                ca.updateCategory();
            else
                ca.addCategory();
            // update this category in he conext
            allCA.put(ca_id, ca);
            // go back to admin
            go_to += "?update_message=CategoryUpdateChangedSuccessfully";
        }

        context.setAttribute("allCA", allCA);
        response.sendRedirect(go_to);
    }
}
