/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.RawBean;
import Beans.RecipeBean;
import Beans.SalesBean;
import java.util.ArrayList;

/**
 *
 * @author earleenjanefuentes
 */
public interface RawDAOInterface {

    public boolean addRaw(RawBean r);

    public boolean deleteRaw(RawBean r);

    public boolean editRaw(RawBean r);

    public RawBean getRaw(int r);
    
    public int getLatestAddedID();
    
    public float getStock(String s);
    
    public ArrayList<RawBean> getAllRaw();

    public ArrayList<RawBean> getRawByStatus(String s);
    
    public boolean restockRaw(RawBean r);
    
    public boolean updateStock (int ID, float a);
    
    public int getIDbyRaw (String s);

}
