/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package btf;

import Beans.IngredientBean;
import Beans.RecipeBean;
import DAO.Implementation.IngredientDAOImplementation;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.IngredientDAOInterface;
import DAO.Interface.RecipeDAOInterface;
import UI.CreatePassword;
import UI.Login;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author earleenjanefuentes
 */
public class Btf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //DONT FORGET TO CHANGE PASSWORD!!
       //instanstiate interface
       RecipeDAOInterface rcImp = new RecipeDAOImplementation();
       
       //variables 
       ArrayList<RecipeBean> allRC = new ArrayList<RecipeBean> ();
       float cost = (float) 125.00;
       int i;
       
       //TEST: ADD RECIPE - CHECK!
       RecipeBean newRC = new RecipeBean("Banana Split", (float) 125.00, (float) 7.5, "available");
       newRC.setRecipeID(20003);
       //rcImp.addRecipe(newRC);
       
       //TEST: GET ALL RECIPE - CHECK!
       //allRC = rcImp.getAllRecipe();
       //for(i=0; i<allRC.size(); i++){
       //    System.out.println("RECIPE: " + allRC.get(i).getRecipe());
       //}
       
       //TEST: DELETE RECIPE - CHECK!
       //rcImp.deleteRecipe(newRC);
       
       //TEST: GET ALL RECIPE BY STATUS - CHECK FOR AVAILABLE & UNAVAILABLE!
       //allRC = rcImp.getRecipeByStatus("available");
               
       //for(i=0; i<allRC.size(); i++){
       //    System.out.println("RECIPE: " + allRC.get(i).getRecipe());
       //}
       
       //TEST: GET RECIPE - CHECK!
       //RecipeBean gRC = rcImp.getRecipeBean(20001);
       //System.out.println("BEFORE EDIT... RECIPE: " + gRC.getRecipe());
       
       //TEST: EDIT RECIPE - CHECK!
       //gRC.setRecipe("Strawberry Shortcake");
       //System.out.println("recipeID: " + gRC.getRecipeID());
        //rcImp.editRecipe(gRC);
       
       //TEST: GET RECIPE - CHECK!
       RecipeBean gRC = rcImp.getRecipeBean(20001);
      // System.out.println("AFTER EDIT... RECIPE: " + gRC.getRecipe());
       
       
       java.util.Date now = new java.util.Date();
       java.sql.Date today = new java.sql.Date(now.getTime());
       
       System.out.println("DATE: " + today);
       
       IngredientDAOInterface inImp = new IngredientDAOImplementation();
       ArrayList<IngredientBean> aIngredients = new ArrayList<IngredientBean>();
       aIngredients = inImp.getAllIngredients(gRC);
       
       System.out.println("RECIPE: " + gRC.getRecipe());
       for(i=0; i< aIngredients.size() ; i++){
           IngredientBean in = aIngredients.get(i);
           System.out.println("INGREDIENT " + (i+1) + ": " + in.getAmount() + " " + in.getRaw().getUom() + " of " + in.getRaw().getRaw());
       }
       gRC.setIngredients(aIngredients);
       System.out.println("ACTUAL PRICE: " + gRC.getActualPrice());
       System.out.println("STOCK: " + gRC.computeStock());
       
       //<--- CLARK'S CODE STARTS HERE --->
       //check if there's already a password
       File f = new File("btf.xml");
       if(f.exists()){
            System.out.println("File existed");
            new Login().setVisible(true);
       } else{
            System.out.println("File not found!");
            new CreatePassword().setVisible(true);
       }
        //<--- CLARK'S CODE ENDS HERE --->
    }
    
}
