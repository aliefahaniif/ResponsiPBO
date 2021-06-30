/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOBarang;
import DAO.Impbarang;
import Model.Modelbarang;
import Model.Modeltabel;
import View.Barang;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Controllerbarang {
    Barang frame;
    Impbarang impbarang;
    List <Modelbarang> lmb;

    public Controllerbarang(Barang frame){ //, Impbarang impbarang, List<Modelbarang> lmb) {
        this.frame = frame;
        impbarang = new DAOBarang();
        lmb = impbarang.getAll();
        //this.lmb = lmb;
    }
    
    public void reset(){
        frame.getTeks_Id().setText("");
        frame.getTeks_Nama().setText("");
        frame.getTeks_Massa().setText("");
        frame.getTeks_harga().setText("");
        
    }
    
    public void isiTable(){
        lmb = impbarang.getAll();
        Modeltabel mtb = new Modeltabel(lmb);
        frame.getTbl_barang().setModel(mtb);
    }
    
    public void isiField(int row){
        frame.getTeks_Id().setText(String.valueOf(lmb.get(row).getId()));
        frame.getTeks_Nama().setText(lmb.get(row).getNama());
        frame.getTeks_Massa().setText(String.valueOf(lmb.get(row).getMassa()));
        frame.getTeks_harga().setText(String.valueOf(lmb.get(row).getHarga()));
    }
    
    public void insert(){
        if(!frame.getTeks_Nama().getText().trim().isEmpty() & !frame.getTeks_Nama().getText().trim().isEmpty()){
            Modelbarang mb = new Modelbarang();
            
            mb.setNama(frame.getTeks_Nama().getText());
            mb.setMassa(Double.valueOf(frame.getTeks_Massa().getText()));
            mb.setHarga(Double.valueOf(frame.getTeks_harga().getText()));
            //mb.setMassa(Double.valueOf(frame.getTeks_Nama().getText()));
            //mb.setHarga(Double.valueOf(frame.getTeks_Nama().getText()));
            
            impbarang.insert(mb);
            JOptionPane.showMessageDialog(null, "Data Tersimpan!");
        } else{
            JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan!");
        }
    }
    
    public void delete(){
        if(!frame.getTeks_Id().getText().trim().isEmpty()){
            int id = Integer.parseInt(frame.getTeks_Id().getText());
            
            impbarang.delete(id);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
        } else{
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!");
        }
    }
    
    public void update(){
        if(!frame.getTeks_Id().getText().trim().isEmpty()){
            Modelbarang mb = new Modelbarang();
            
            mb.setNama(frame.getTeks_Nama().getText());
            mb.setMassa(Double.valueOf(frame.getTeks_Massa().getText()));
            mb.setHarga(Double.valueOf(frame.getTeks_harga().getText()));
            mb.setId(Integer.valueOf(frame.getTeks_Id().getText()));
            
            impbarang.update(mb);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui!");
        } else{
            JOptionPane.showMessageDialog(null, "Data Gagal Diperbarui!");
        }
    }
}
