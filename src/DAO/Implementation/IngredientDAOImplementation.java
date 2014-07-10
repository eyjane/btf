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
            String query = "INSERT into ingredients(recipeID, rawID, amount) values (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setInt(2, i.getRaw().getRawID());
            preparedStatement.setFloat(3, i.getAmount());
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
    public boolean editIngredient(RecipeBean r, IngredientBean i) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE ingredients SET amount = ? WHERE recipeID = ? AND rawID = ?;";
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
    public ArrayList<IngredientBean> getAllIngredients(RecipeBean r) {
       ArrayList<IngredientBean> aIngredient = new ArrayList<IngredientBean>();
       RawDAOInterface rawImp = new RawDAOImplementation();
 
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select * from ingredients where recipeID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
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
            Logger.getLogger(RawDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aIngredient;
    }

       
}
