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
public class RecipeBean {

    private int recipeID;
    private String recipe;
    private float cost;
    private float stock;
    private String rcstatus;
    private int category;
    private ArrayList<IngredientBean> ingredients;

    public RecipeBean(){
        
    }
    public RecipeBean(String rc, float c, float s, String rs, int ct) {
        //recipeID = r;
        recipe = rc;
        cost = c;
        stock = s;
        rcstatus = rs;
        category = ct;
        //ingredients = new ArrayList<IngredientBean>(rb);
    }
    
    public RecipeBean(String rc, float c, float s, String rs) {
        //recipeID = r;
        recipe = rc;
        cost = c;
        stock = s;
        rcstatus = rs;
        category = 1; //no category
        //ingredients = new ArrayList<IngredientBean>(rb);
    }
    
    public RecipeBean(String rc, float c, float s, String rs, int ct, ArrayList<IngredientBean> rb) {
        //recipeID = r;
        recipe = rc;
        cost = c;
        stock = s;
        rcstatus = rs;
        category = ct;
        ingredients = new ArrayList<IngredientBean>(rb);
    }

    public float computeStock(){
        int i;
        float s = 0;
        float lowest = ingredients.get(0).getRaw().getStock()/ingredients.get(0).getAmount();
        
        for(IngredientBean in: ingredients){
            RawBean r = in.getRaw();
            s = r.getStock()/in.getAmount();
            //System.out.println("S = " + s + " Lowest = " + lowest);
            if(lowest > s){
                lowest = s;
                
            }
        }
        
        if(lowest < 1){
            return 0;
        }
        return lowest;
    }
    
    public int getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public ArrayList<IngredientBean> getIngredients() {
        return ingredients;
    }

    public String getRcstatus() {
        return rcstatus;
    }

    public String getRecipe() {
        return recipe;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public float getStock() {
        return stock;
    }

    public float getActualPrice() {
        int i;
        float price = 0;
        float amount = 0;
        float total = 0;
        float actual = 0;

        for (i = 0; i < ingredients.size(); i++) {
            price = ingredients.get(i).getRaw().getPrice();
            amount = ingredients.get(i).getAmount();
            total = price * amount;
            actual += total;
        }

        return actual;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setIngredients(ArrayList<IngredientBean> ingredients) {
        this.ingredients = new ArrayList<IngredientBean>(ingredients);
    }

    public void setRcstatus(String rcstatus) {
        this.rcstatus = rcstatus;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

}
