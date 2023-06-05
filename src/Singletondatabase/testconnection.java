/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singletondatabase;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Rahimsyah
 */
public class testconnection {
   public static Connection con;
    public static void main(String[] args) {
        try {
         
        con = DatabaseConnection.getConnection();
        if (con != null){
            System.out.println("Koneksi Berhasil");
        }
        else {
            System.out.println("Koneksi Gagal");
        }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
