/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Lenovo
 */
@MultipartConfig

public class uploadDeleteImage extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("delete".equals((String) request.getParameter("reqType"))) {
            String fileName = "D:\\magdy\\Projects\\mobProject\\MalekPhone\\web\\images\\" + (String)request.getParameter("file");
            File file  = new File(fileName);
            file.delete();
        } else {
            Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            File uploads = new File("D:\\magdy\\Projects\\mobProject\\MalekPhone\\web\\images\\");
            File file = new File(uploads, fileName);
            Files.copy(fileContent, file.toPath());
            response.sendRedirect("doneUploading.html");
        }
    }
}