/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Lenovo
 */
public class category {
    private int id;
    private String name;
    private String img_path;

    public category(int id, String name, String img_path) {
        this.id = id;
        this.name = name;
        this.img_path = img_path;
    }

    public category() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImg_path() {
        return img_path;
    }
    
    
    public void addCategory() {
        try {
            DBConnect db = new DBConnect();
            db.excuteDml("INSERT INTO malekphone.category (id, `name`) VALUES (" + this.id + ", '" + this.name + "')");
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void updateCategory() {
        try {
            DBConnect db = new DBConnect();
            db.excuteDml("update category  set  name= '" + this.name + "' where id=" + this.id);
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void deleletCategory(){
       try {
            DBConnect db = new DBConnect();
            db.excuteDml("DELETE FROM malekphone.category WHERE id =" + this.id);
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }  
    }
    
    public static ConcurrentHashMap getAll() throws SQLException {
        DBConnect db = new DBConnect();
        ConcurrentHashMap<Integer,category> allCA = new ConcurrentHashMap<>();
        try {
            ResultSet rs;
            
            rs = db.excuteSelect("SELECT * FROM category");
            while (rs.next()) {
                category ca = new category();
                ca.id = rs.getInt(1);
                ca.name = rs.getString(2);
                ca.img_path = rs.getString(3);
                allCA.put(ca.id, ca);
            }
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }

        return allCA;
    }
}
