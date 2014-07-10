/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.util.ArrayList;

/**
 *
 * @author earleenjanefuentes
 */
public class CategoryBean {
    
    private int categoryID;
    private String category;
    private ArrayList<RecipeBean> aRecipes;
    
    public CategoryBean(){
        categoryID = -1;
        category = "";
        aRecipes = new ArrayList<RecipeBean>();
        aRecipes = null;
        
    }
    
    public CategoryBean(String ct, ArrayList<RecipeBean> r){
       // categoryID = c;
        category = ct;
        aRecipes = new ArrayList<RecipeBean>(r);
    }
 
    public CategoryBean(int c, String ct){
        categoryID = c;
        category = ct;
        aRecipes = null;
    }

    public String getCategory() {
        return category;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public ArrayList<RecipeBean> getaRecipes() {
        return aRecipes;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setaRecipes(ArrayList<RecipeBean> aRecipes) {
        this.aRecipes = new ArrayList<RecipeBean>(aRecipes);
    }
    
    @Override
    public String toString(){
        return category;
    }
    
}
