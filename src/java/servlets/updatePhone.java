/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.category;
import classes.manageIMG;
import classes.phone;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Lenovo
 */
public class updatePhone extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String go_to = "admincont.jsp";
        go_to += "?update_message=PhoneUpdateChangedSuccessfully";
        ServletContext context = request.getServletContext();
        ConcurrentHashMap<Integer, phone> allPH = (ConcurrentHashMap<Integer, phone>) context.getAttribute("allPH");
        phone ph;
        int phId;
        
        if("addPhone".equals((String)request.getParameter("reqType"))){
            System.out.println("\n\nin add phone");
            phId = Integer.parseInt(request.getParameter("phId"));
            String newName = (String)request.getParameter("newName");
            int newCategoryId = Integer.parseInt(request.getParameter("newCategoryId"));
            int newCost = Integer.parseInt(request.getParameter("newCost"));
            String newImgName = request.getParameter("newImgName");
            ph = new phone(phId,newName,newCategoryId,newImgName,newCost,"");
            System.out.println("\n\n phone is" + ph);
            ph.addPhone();
            System.out.println("phone is added" + ph);
            go_to = "uploadFilePage.html";
        }else{
            phId = Integer.parseInt(request.getParameter("phId"));
            ph = new phone();
            ph.setId(phId);
            ph.fillPhone();

            if("editName".equals((String)request.getParameter("reqType"))){ // edit name
                String newName = (String)request.getParameter("newName");
                ph.setName(newName);
            }else if("editCategoryId".equals((String)request.getParameter("reqType"))){ // edit category_id
                int newCategoryId = Integer.parseInt(request.getParameter("newCategoryId"));
                ph.setCategory_id(newCategoryId);
            }else if("editCost".equals((String)request.getParameter("reqType"))){ // edit phone_cost
                int newCost = Integer.parseInt(request.getParameter("newCost"));
                System.out.println("\n\nin edit cost, id is:" + phId + ", new cost is" + newCost);
                ph.setCost(newCost);
            }else if("editIMG".equals((String)request.getParameter("reqType"))){ // edit Photo
                manageIMG.deleteIMG(ph.getImg_path());
                String newImgPath = request.getParameter("newImgPath");
                ph.setImg_path(newImgPath);
                go_to = "uploadFilePage.html";
            }else{
                manageIMG.deleteIMG(ph.getImg_path());
                ph.deleletPhone();
                allPH.remove(phId);
                context.setAttribute("allPH", allPH);
                response.sendRedirect(go_to);
                return;
            }
        }
        ph.change();
        allPH.put(phId, ph);
        context.setAttribute("allPH", allPH);
        response.sendRedirect(go_to);
    }
}
