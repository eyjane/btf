/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.CategoryBean;
import Beans.RawBean;
import Beans.RecipeBean;
import java.util.ArrayList;

/**
 *
 * @author earleenjanefuentes
 */
public interface RecipeDAOInterface {

    public boolean addRecipe(RecipeBean r);

    public boolean deleteRecipe(RecipeBean r);

    public boolean editRecipe(RecipeBean r);
    
    public int getLatestAddedID();

    public RecipeBean getRecipeBean(int rID);

    public ArrayList<RecipeBean> getAllRecipe();

    public ArrayList<RecipeBean> getRecipeByCategory(CategoryBean c);

    public ArrayList<RecipeBean> getRecipeByRawMaterial(RawBean r);

    public ArrayList<RecipeBean> getRecipeByStatus(String s);

}
