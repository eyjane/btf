/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Implementation;

import Beans.CategoryBean;
import Beans.RawBean;
import Beans.RecipeBean;
import DAO.Interface.RecipeDAOInterface;
import DBConnection.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author earleenjanefuentes
 */
public class RecipeDAOImplementation implements RecipeDAOInterface{
    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;

    @Override
    public boolean addRecipe(RecipeBean r) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT into recipe(recipe, cost, stock, rcstatus, category) values (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getRecipe());
            preparedStatement.setFloat(2, r.getCost());
            preparedStatement.setFloat(3, r.getStock());
            preparedStatement.setString(4, r.getRcstatus());
            preparedStatement.setInt(5, r.getCategory());
            
            
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteRecipe(RecipeBean r) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE recipe SET rcstatus = ? WHERE recipeID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "deleted");
            preparedStatement.setInt(2, r.getRecipeID());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editRecipe(RecipeBean r) {
         try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE recipe SET recipe = ?, cost = ?, stock = ?, category = ? WHERE recipeID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getRecipe());
            preparedStatement.setFloat(2, r.getCost());
            preparedStatement.setFloat(3, r.getStock());
            preparedStatement.setInt(4, r.getCategory());
            preparedStatement.setFloat(5, r.getRecipeID());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public RecipeBean getRecipeBean(int rID) {
         RecipeBean r = new RecipeBean();
        
        try {
            String query = "select * from recipe where recipeID = ?";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                r.setCategory(resultSet.getInt("category"));
                r.setRecipe(resultSet.getString("recipe"));
                r.setRcstatus(resultSet.getString("rcstatus"));
                r.setRecipeID(rID);
                r.setCost(resultSet.getFloat("cost"));
                r.setStock(resultSet.getFloat("stock"));
                
            }
            else{
                r = null;
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public ArrayList<RecipeBean> getAllRecipe() {
        ArrayList<RecipeBean> aRecipes = new ArrayList<RecipeBean>();
        
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select * from recipe";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RecipeBean r = new RecipeBean();
                r.setRecipeID(resultSet.getInt("recipeID"));
                r.setRecipe(resultSet.getString("recipe"));
                r.setCost(resultSet.getFloat("cost"));
                r.setCategory(resultSet.getInt("category"));
                r.setStock(resultSet.getFloat("stock"));
                r.setRcstatus(resultSet.getString("rcstatus"));
                aRecipes.add(r);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aRecipes;
    }

    @Override
    public ArrayList<RecipeBean> getRecipeByCategory(CategoryBean c) {
        ArrayList<RecipeBean> aRecipes = new ArrayList<RecipeBean>();
        
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select * from recipe where category = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, c.getCategoryID());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RecipeBean r = new RecipeBean();
                r.setRecipeID(resultSet.getInt("recipeID"));
                r.setRecipe(resultSet.getString("recipe"));
                r.setCost(resultSet.getFloat("cost"));
                r.setCategory(c.getCategoryID());
                r.setStock(resultSet.getFloat("stock"));
                r.setRcstatus(resultSet.getString("rcstatus"));
                aRecipes.add(r);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aRecipes;
        
    }

    @Override
    public ArrayList<RecipeBean> getRecipeByRawMaterial(RawBean rm) {
        ArrayList<RecipeBean> aRecipes = new ArrayList<RecipeBean>();
        
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select * from ingredients where rawID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rm.getRawID());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RecipeBean r = new RecipeBean();
                r.setRecipeID(resultSet.getInt("recipeID"));
                r.setRecipe(resultSet.getString("recipe"));
                r.setCost(resultSet.getFloat("cost"));
                r.setCategory(resultSet.getInt("category"));
                r.setStock(resultSet.getFloat("stock"));
                r.setRcstatus(resultSet.getString("rcstatus"));
                aRecipes.add(r);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aRecipes;
    }

    @Override
    public ArrayList<RecipeBean> getRecipeByStatus(String s) {
        ArrayList<RecipeBean> aRecipes = new ArrayList<RecipeBean>();
        
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select * from recipe where rcstatus = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RecipeBean r = new RecipeBean();
                r.setRecipeID(resultSet.getInt("recipeID"));
                r.setRecipe(resultSet.getString("recipe"));
                r.setCost(resultSet.getFloat("cost"));
                r.setCategory(resultSet.getInt("category"));
                r.setStock(resultSet.getFloat("stock"));
                r.setRcstatus(s);
                aRecipes.add(r);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aRecipes;
    }
    
}
