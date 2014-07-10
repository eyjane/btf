/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.TransactionBean;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author earleenjanefuentes
 */
public interface TransactionDAOInterface {

    public boolean addTransaction(TransactionBean t);

    public ArrayList<TransactionBean> getAllTransaction();

    public ArrayList<TransactionBean> getAllTransactionByType(String s); //sorted by recipe

    public ArrayList<TransactionBean> getAllTransactionByDay(Date d); //sorted by recipe
    
    public ArrayList<TransactionBean> getAllTransactionByDayByType(Date d, String s);
    
    public ArrayList<TransactionBean> sumAllTransactionByType(String s); //sorted by recipe

    public ArrayList<TransactionBean> sumAllTransactionByDay(Date d); //sorted by recipe
    
    public ArrayList<TransactionBean> sumAllTransactionByDayByType(Date d, String s);
    
    //public ArrayList<TransactionBean> getAllTransactionByTypeWeek(String s, int w);
    //public ArrayList<TransactionBean> getAllTransactionByTypeMonth(String s, int m);
    //public ArrayList<TransactionBean> getAllTransactionByTypeYear(String s, int y);
}
