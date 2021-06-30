/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class Modeltabel extends AbstractTableModel{
    List<Modelbarang> lmb;

    public Modeltabel(List<Modelbarang> lmb) {
        this.lmb = lmb;
    }
    

    @Override
    public int getRowCount() {
        return lmb.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return lmb.get(row).getId();
            case 1:
                return lmb.get(row).getNama();
            case 2:
                return lmb.get(row).getMassa();
            case 3:
                return lmb.get(row).getHarga();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Id";
            case 1:
                return "Nama";
            case 2:
                return "Massa";
            case 3:
                return "Harga";
            default:
                return null;
        }
    }
    
    
    
}
