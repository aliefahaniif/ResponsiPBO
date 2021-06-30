/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;

/**
 *
 * @author user
 */
public class Connectordatabase {
    static Connection koneksi;
    
    public static Connection connection(){
        if(koneksi==null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("barang");            
            data.setUser("root");            
            data.setPassword("");           
            
            try {
                koneksi = data.getConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Connectordatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return koneksi;
    }
    
}
/*public class Connectordatabase {
    String DBurl = "jdbc:mysql://localhost/barang";
    String DBusername = "root";
    String DBpassword;
    Connection koneksi;
    Statement statement;

    public Connectordatabase() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
    }
    }
        
}
*/
