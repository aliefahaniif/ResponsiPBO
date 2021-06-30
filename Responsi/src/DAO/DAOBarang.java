/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connector.Connectordatabase;
import Model.Modelbarang;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DAOBarang implements Impbarang{
//    String DBurl = "jdbc:mysql://localhost/mahasiswa";
//    String DBusername = "root";
//    String DBpassword;
//    Connectordatabase connectordatabase = new Connectordatabase();
//    Connector connector = new Connector();
    
    Connection koneksi;

    public DAOBarang() {
        koneksi = Connectordatabase.connection();
    }
    
    //String query = "INSERT INTO `barang`(`nama`,`massa`,`harga`) VALUES ('"+getNo()+"','"+getNama()+"','"+getNIP()+"','"+getKelas()+"')";
    final String insert = "INSERT INTO barang (`nama`,`massa`,`harga`) VALUES (?, ?, ?)";
    final String delete = "DELETE FROM barang WHERE Id=?";
    final String update = "UPDATE barang set nama=?, massa=?,harga=? WHERE id=?";    
    final String select = "SELECT * FROM barang";

//    public DAOBarang(Connection koneksi) {
//        koneksi = Connectordatabase.koneksi();
//    }

    @Override
    public void insert(Modelbarang mb) {
        PreparedStatement statement = null;
        try {
            statement = koneksi.prepareStatement(insert);
            statement.setString(1, mb.getNama());
            statement.setDouble(1, mb.getMassa());
            statement.setDouble(1, mb.getMassa());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()){
                mb.setId(rs.getInt(1));
            }
                    
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(DAOBarang.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println(e.getMessage());
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
          }
        }
       

    @Override
    public void delete(int Id) {
        PreparedStatement statement = null;
        try {
            statement = koneksi.prepareStatement(delete);
            
            statement.setInt(1, Id);
            statement.executeUpdate();
                    
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(DAOBarang.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
          }
        
    }
    
    @Override
    public void update(Modelbarang mb) {
        PreparedStatement statement = null;
        try {
            statement = koneksi.prepareStatement(update);
            statement.setString(1, mb.getNama());
            statement.setDouble(1, mb.getMassa());
            statement.setDouble(1, mb.getMassa());
            statement.setInt(1, mb.getId());
            statement.executeUpdate();
                    
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(DAOBarang.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println(e.getMessage());
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
          }
    }

    @Override
    public List<Modelbarang> getAll() {
        List<Modelbarang> lmb = null;
        
        try {
            lmb = new ArrayList<Modelbarang>();
            Statement st = koneksi.createStatement();
            //Statement statement = connectDB.createStatement();
           // connectordatabase.statement = connectordatabase.koneksi.createStatement();
            
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                Modelbarang mb = new Modelbarang();
                mb.setId(rs.getInt("id"));
                mb.setNama(rs.getString("nama"));
                mb.setMassa(rs.getDouble("massa"));
                mb.setHarga(rs.getDouble("harga"));
                lmb.add(mb);
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            Logger.getLogger(DAOBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lmb;
    }
    
}
