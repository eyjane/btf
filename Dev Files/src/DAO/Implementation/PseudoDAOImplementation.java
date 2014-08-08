/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import DAO.Interface.PseudoDAOInterface;
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
 * @author Kim
 */
public class PseudoDAOImplementation implements PseudoDAOInterface {
    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;

    @Override
    public ArrayList<RecipeBean> getAllSales(String d) {
        IngredientDAOInterface inImp = new IngredientDAOImplementation();
        ArrayList<RecipeBean> aRecipe = new ArrayList<RecipeBean>();

        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select distinct r.recipeID, recipe, price, stock, rcstatus, categoryID, ordernum "
                    + "from sales s, sold sd, recipe r "
                    + "where r.recipeID = sd.recipeID and s.salesID = sd.salesID and sales_date = ? "
                    + "order by 7;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, d);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RecipeBean r = new RecipeBean();
                ArrayList<IngredientBean> ingredients = new ArrayList<IngredientBean>();
                r.setRecipeID(resultSet.getInt("r.recipeID"));
                r.setRecipe(resultSet.getString("recipe"));
                r.setCost(resultSet.getFloat("price"));
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
    public float getSalesByRecipeByDay(RecipeBean r, String d) {
        try {
            float s =0;
            String query = "select recipeID, quantity, price "

                    + "from sales s, sold sd "
                    + "where sd.recipeID = ? and s.salesID = sd.salesID and sales_date = ? and sales_type= 'sales';";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRecipeID());
            preparedStatement.setString(2, d);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                float x = resultSet.getFloat("quantity");
                float y = resultSet.getFloat("price");
                s = x * y;
            }
            connection.close();
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
