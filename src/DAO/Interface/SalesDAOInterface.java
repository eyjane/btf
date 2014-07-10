/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.RecipeBean;
import Beans.SalesBean;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author earleenjanefuentes
 */
public interface SalesDAOInterface {

    public boolean addSales(SalesBean s);

    public ArrayList<SalesBean> getAllSales();

    public ArrayList<SalesBean> getTotalSalesByDay(Date d); //total per day

    //public ArrayList<SalesBean> getTotalSalesByWeek(int w);
    //public ArrayList<SalesBean> getTotalSalesByMonth(int m);
    //public ArrayList<SalesBean> getTotalSalesByYear(int y);
    public ArrayList<SalesBean> getSalesByRecipe(RecipeBean r); //sorted into recipes
}
