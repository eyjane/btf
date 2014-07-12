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

    public boolean addSales(SalesBean s, RecipeBean r, float a);
    
    public ArrayList<RecipeBean> getAllSales(String d);
    //gets the recipeBean in order

    public float sumSalesByRecipeByDay(RecipeBean r, String d);
    //gets quantity of sales * cost (for one recipe only)

    public float sumComplimentarySalesByRecipeByDay(RecipeBean r, String d);
    //gets quantity of complimentary * actual price (for one recipe only) - only added to expenses

    public float sumExpensesByRecipeByDay(RecipeBean r, String d);
    //gets quantity of sales * actual price (for one recipe only) - only added to expenses
    
    public float sumQuantityByRecipeByDay(String d, String s, RecipeBean r);
    //gets quantity (for one recipe only) - for variance report
}
