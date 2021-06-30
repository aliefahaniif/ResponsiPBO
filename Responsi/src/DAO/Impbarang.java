/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Modelbarang;
import java.util.List;

/**
 *
 * @author user
 */
public interface Impbarang {
    public void insert(Modelbarang mb);
    public void delete(int Id);
    public void update(Modelbarang mb);
    public List<Modelbarang> getAll();
    
    
}
