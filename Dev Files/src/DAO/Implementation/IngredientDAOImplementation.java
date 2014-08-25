/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.CategoryBean;
import Beans.IngredientBean;
import Beans.RawBean;
import Beans.RecipeBean;
import DAO.Interface.IngredientDAOInterface;
import DAO.Interface.RawDAOInterface;
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
public class IngredientDAOImplementation implements IngredientDAOInterface {

    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;

    @Override
    public boolean addIngredient(RecipeBean r, IngredientBean i) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT into ingredients(recipeID, rawID, amount, date_ingredient) values (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setInt(2, i.getRaw().getRawID());
            preparedStatement.setFloat(3, i.getAmount());

            /* create date*/
            java.util.Date now = new java.util.Date();
            java.sql.Date today = new java.sql.Date(now.getTime());

            preparedStatement.setDate(4, today);
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteIngredient(RecipeBean r, IngredientBean i) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "DELETE from ingredients where recipeID = ? and rawID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setInt(2, i.getRaw().getRawID());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean deleteIngredient(RecipeBean r, IngredientBean i, String d) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "DELETE from ingredients where recipeID = ? and rawID = ? and date_ingredient = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setInt(2, i.getRaw().getRawID());
            preparedStatement.setString(3, d);
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    @Override
    public boolean editIngredient(RecipeBean r, IngredientBean i) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE ingredients SET amount = ? WHERE recipeID = ? AND rawID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setFloat(1, i.getAmount());
            preparedStatement.setInt(2, r.getRecipeID());
            preparedStatement.setInt(3, i.getRaw().getRawID());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<IngredientBean> getAllIngredients(RecipeBean r) {
        ArrayList<IngredientBean> aIngredient = new ArrayList<IngredientBean>();
        RawDAOInterface rawImp = new RawDAOImplementation();

        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();

            String query = "select * from ingredients where recipeID = ? and date_ingredient in (select max(date_ingredient) from ingredients where recipeID = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setInt(2, r.getRecipeID());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                IngredientBean i = new IngredientBean();
                RawBean rm = new RawBean();
                rm = rawImp.getRaw(resultSet.getInt("rawID"));
                i.setAmount(resultSet.getFloat("amount"));
                i.setRaw(rm);

                aIngredient.add(i);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aIngredient;
    }

    @Override
    public ArrayList<IngredientBean> getIngredientsBydate(RecipeBean r, String d) {
        ArrayList<IngredientBean> aIngredient = new ArrayList<IngredientBean>();
        RawDAOInterface rawImp = new RawDAOImplementation();

        try {
            String date = getNearestDate(d);
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            
            String query = "select * from ingredients where recipeID = ? and date_ingredient = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setString(2, date);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                IngredientBean i = new IngredientBean();
                RawBean rm = new RawBean();
                rm = rawImp.getRaw(resultSet.getInt("rawID"));
                i.setAmount(resultSet.getFloat("amount"));
                i.setRaw(rm);

                aIngredient.add(i);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aIngredient;
    }
    
    @Override
    public String getNearestDate(String d){
        String n = "none";
        
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();

            String query = "select date_ingredient from ingredients where date_ingredient <= ? order by 1 desc;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
           
            preparedStatement.setString(1, d);

            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 1;
            while (resultSet.next()) {
                if(count == 1){
                    n = resultSet.getString("date_ingredient");
                    break;
                }
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    @Override
    public boolean isIngredient(RawBean r) {
       
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();

            String query = "select distinct(rawID) "
                    + "from ingredients "
                    + "where date_ingredient in (select distinct(max(date_ingredient)) "
                    + "from ingredients "
                    + "group by recipeID);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if(resultSet.getInt("rawID") == r.getRawID()){
                    return true;
                }
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public String getLastUpdate(RecipeBean r){
        String l = "today";
        
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();

            String query = "select max(date_ingredient) from ingredients where recipeID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                l = resultSet.getString("max(date_ingredient)");
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    

}
