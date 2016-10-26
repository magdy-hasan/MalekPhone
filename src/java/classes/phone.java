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
public class phone {

    private int id;
    private String name;
    private int category_id;
    private String img_path;
    private int cost;
    private String description;

    public phone() {
    }

    public phone(int id, String name, int category_id, String img_path, int cost, String description) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
        this.img_path = img_path;
        this.cost = cost;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getImg_path() {
        return img_path;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public void addPhone() {
        try {
            DBConnect db = new DBConnect();
            db.excuteDml("insert into phone values (" + this.id + " , '" + this.name + "','" + this.category_id + "','"
                    + this.img_path + "','" + this.cost + "', '" + this.description + "')");
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void change() {
        try {
            DBConnect db = new DBConnect();
            db.excuteDml("UPDATE malekphone.phone SET `name` = '" + this.name + "', `category_id` = '" + this.category_id + 
                         "', `img_path` = '" + this.img_path + "', `cost` = '" + this.cost + "' WHERE id = '" + this.id + "'");
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    public void fillPhone() {
        try {
            DBConnect db = new DBConnect();
            ResultSet rs = db.excuteSelect("SELECT * FROM phone where id=" + this.id);
            rs.next();
            this.name = rs.getString(2);
            this.category_id = rs.getInt(3);
            this.img_path = rs.getString(4);
            this.cost = rs.getInt(5);
            this.description = rs.getString(6);
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void deleletPhone(){
       try {
            DBConnect db = new DBConnect();
            db.excuteDml("DELETE FROM malekphone.phone WHERE id =" + this.id);
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }  
    }
    
    public void deleletPhonesWithCategoryId(){
       try {
            DBConnect db = new DBConnect();
            db.excuteDml("DELETE FROM malekphone.phone WHERE category_id =" + this.category_id);
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }  
    }

    public static ConcurrentHashMap<Integer,phone> getAll() throws SQLException {
        DBConnect db = new DBConnect();
        ConcurrentHashMap<Integer,phone> allPH = new ConcurrentHashMap<>();
        try {
            ResultSet rs;
                rs = db.excuteSelect("SELECT * FROM phone");
            while (rs.next()) {
                phone ph = new phone();
                ph.id = rs.getInt(1);
                ph.name = rs.getString(2);
                ph.category_id = rs.getInt(3);
                ph.img_path = rs.getString(4);
                ph.cost = rs.getInt(5);
                ph.description = rs.getString(6);
                allPH.put(ph.id,ph);
            }
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }

        return allPH;
    }

}
