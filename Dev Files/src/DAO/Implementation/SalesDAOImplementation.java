/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.IngredientBean;
import Beans.RecipeBean;
import Beans.SalesBean;
import DAO.Interface.IngredientDAOInterface;
import DAO.Interface.SalesDAOInterface;
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
public class SalesDAOImplementation implements SalesDAOInterface {

    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;

    /*checked!*/
    @Override
    public boolean addSales(SalesBean s, RecipeBean r, float a) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT into sales(sales_date, sales_type, ordernum) values (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            /* create date*/
            java.util.Date now = new java.util.Date();
            java.sql.Date today = new java.sql.Date(now.getTime());

            preparedStatement.setDate(1, today);
            preparedStatement.setString(2, s.getType());
            preparedStatement.setInt(3, s.getOrder());

            preparedStatement.executeUpdate();

            /* add to sold table */
            query = "SELECT max(salesID) from sales;";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int salesID = resultSet.getInt("max(salesID)");
                String squery = "INSERT into sold(salesID, recipeID, quantity) values (?, ?, ?);";
                PreparedStatement spreparedStatement = connection.prepareStatement(squery);
                spreparedStatement.setInt(1, salesID);
                spreparedStatement.setInt(2, r.getRecipeID());
                spreparedStatement.setFloat(3, a);

                spreparedStatement.executeUpdate();
                connection.close();
                return true;
            }

            connection.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*checked*/
    @Override
    public ArrayList<RecipeBean> getAllSales(String d) {
        IngredientDAOInterface inImp = new IngredientDAOImplementation();
        ArrayList<RecipeBean> aRecipe = new ArrayList<RecipeBean>();

        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select distinct r.recipeID, recipe, cost, stock, rcstatus, categoryID, ordernum "
                    + "from sales s, sold sd, recipe r "
                    + "where r.recipeID = sd.recipeID and s.salesID = sd.salesID and sales_date = ?;"
                    + "order by 7";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, d);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RecipeBean r = new RecipeBean();
                ArrayList<IngredientBean> ingredients = new ArrayList<IngredientBean>();
                r.setRecipeID(resultSet.getInt("recipeID"));
                r.setRecipe(resultSet.getString("recipe"));
                r.setCost(resultSet.getFloat("cost"));
                r.setStock(resultSet.getFloat("stock"));
                r.setRcstatus(resultSet.getString("rcstatus"));
                r.setCategory(resultSet.getInt("categoryID"));
                ingredients = inImp.getAllIngredients(r);
                r.setIngredients(ingredients);

                aRecipe.add(r);
            }

            connection.close();
            return aRecipe;
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aRecipe;

    }

    @Override
    public float sumSalesByRecipeByDay(RecipeBean r, String d) {
        try {
            String query = "select recipeID, quantity "
                    + "from sales s, sold sd "
                    + "where recipeID = ? and s.salesID = sd.salesID and sales_date = ? and sales_type= 'sales';";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setString(2, d);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                float x = resultSet.getFloat("quantity");
                float s = x * r.getCost();
                connection.close();
                return s;

            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public float sumComplimentarySalesByRecipeByDay(RecipeBean r, String d) {
        try {
            String query = "select recipeID, quantity "
                    + "from sales s, sold sd "
                    + "where recipeID = ? and s.salesID = sd.salesID and sales_date = ? and sales_type= 'complimentary';";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setString(2, d);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                float x = resultSet.getFloat("quantity");
                float s = x * r.getActualPrice();
                connection.close();
                return s;

            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public float sumExpensesByRecipeByDay(RecipeBean r, String d) {
        try {
            String query = "select recipeID, quantity "
                    + "from sales s, sold sd "
                    + "where recipeID = ? and s.salesID = sd.salesID and sales_date = ? and sales_type= 'sales';";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setString(2, d);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                float x = resultSet.getFloat("quantity");
                float s = x * r.getActualPrice();
                connection.close();
                return s;

            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public float sumQuantityByRecipeByDay(String d, String s, RecipeBean r) {
        try {
            String query = "select recipeID, quantity "
                    + "from sales s, sold sd "
                    + "where recipeID = ? and s.salesID = sd.salesID and sales_date = ? and sales_type= ?;";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setString(2, d);
            preparedStatement.setString(3, s);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                float x = resultSet.getFloat("quantity");
                connection.close();
                return x;

            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
