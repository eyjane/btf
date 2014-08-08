/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.RecipeBean;
import java.util.ArrayList;

/**
 *
 * @author Kim
 */
public interface PseudoDAOInterface {
    
    public ArrayList<RecipeBean> getAllSales(String d);
    //gets the recipeBean in order

    public float getSalesByRecipeByDay(RecipeBean r, String d);
    //gets quantity of sales * cost (for one recipe only)

    
}
