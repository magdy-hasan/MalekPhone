/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class manageIMG {
    public static void deleteIMG(String fileName){
        File file  = new File("D:\\magdy\\Projects\\mobProject\\MalekPhone\\web\\images\\" + fileName);
        file.delete();
    }
    public static void addIMG(String fileName, InputStream fileContent){
        File uploads = new File("D:\\magdy\\Projects\\mobProject\\MalekPhone\\web\\images\\");
        File file = new File(uploads, fileName);
        try {
            Files.copy(fileContent, file.toPath());
        } catch (IOException ex) {
            Logger.getLogger(manageIMG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
