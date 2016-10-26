/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import classes.category;
import classes.phone;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import servlets.set_products_context;

/**
 * Web application lifecycle listener.
 *
 * @author Lenovo
 */
public class NewServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
         // get all category
        ConcurrentHashMap allCA = null;
        try {
            allCA = category.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(set_products_context.class.getName()).log(Level.SEVERE, null, ex);
        }
        servletContext.setAttribute("allCA", allCA);
        
        // get all phones
        ConcurrentHashMap<Integer,phone> allPH = null;
        try {
            allPH = phone.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(set_products_context.class.getName()).log(Level.SEVERE, null, ex);
        }
        servletContext.setAttribute("allPH", allPH);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // don't do anything
    }
}
