/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Beans.IngredientBean;
import Beans.RawBean;
import Beans.RecipeBean;
import java.util.ArrayList;

/**
 *
 * @author earleenjanefuentes
 */
public interface IngredientDAOInterface {
    
    public boolean addIngredient(RecipeBean r, IngredientBean i);
    public boolean deleteIngredient(RecipeBean r, IngredientBean i);
    public boolean editIngredient(RecipeBean r, IngredientBean i);
    public ArrayList<IngredientBean> getAllIngredients(RecipeBean r); 
    public ArrayList<IngredientBean> getIngredientsBydate(RecipeBean r, String d);
    public boolean isIngredient(RawBean r);
   public String getNearestDate(String d);
}
