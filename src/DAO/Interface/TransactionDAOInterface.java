/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.RawBean;
import Beans.TransactionBean;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author earleenjanefuentes
 */
public interface TransactionDAOInterface {

    public boolean addTransaction(TransactionBean t, RawBean r, float a);

    public float sumQuantityByDay(String d, String s); //gets sum of quantities by type
    
    public float getQuantityByDayByRaw(String d, String s, RawBean r); //gets quantity only
    
    public boolean actualInput(TransactionBean t, RawBean r, float a); // type = actual
    
    public boolean usedTransfer(TransactionBean t, RawBean r, float a);
    
    public boolean wastages(TransactionBean t, RawBean r, float a);
    
}
