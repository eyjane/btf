/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.util.Date;

/**
 *
 * @author earleenjanefuentes
 */
public class SalesBean {
    private int salesID;
    private Date date;
    private RecipeBean recipe;
    private String type;
    private int order;
    
    public SalesBean(){
        
    }
    
    public SalesBean(float a, Date d, int o,RecipeBean r, String t){
        date = d;
        recipe = r;
        order = o;
        type = t;
    }

    public SalesBean(int salesID, Date date, RecipeBean recipe, String type, int order) {
        this.salesID = salesID;
        this.date = date;
        this.recipe = recipe;
        this.type = type;
        this.order = order;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Date getDate() {
        return date;
    }

    public RecipeBean getRecipe() {
        return recipe;
    }

    public int getSalesID() {
        return salesID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRecipe(RecipeBean recipeID) {
        this.recipe = recipeID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }
    
}
