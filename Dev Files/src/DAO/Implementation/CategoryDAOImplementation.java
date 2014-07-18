/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.CategoryBean;
import DAO.Interface.CategoryDAOInterface;
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
public class CategoryDAOImplementation implements CategoryDAOInterface {

    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;

    @Override
    public boolean addCategory(CategoryBean c) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT into category(category) values (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, c.getCategory());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteCategory(CategoryBean c) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "DELETE FROM category WHERE categoryID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, c.getCategoryID());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editCategory(CategoryBean c) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE category SET category = ? WHERE categoryID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, c.getCategory());
            preparedStatement.setInt(2, c.getCategoryID());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public CategoryBean getCategory(int c) {
        CategoryBean ct = new CategoryBean();

        try {

            String query = "select * from category where categoryID = ?";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, c);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ct.setCategory(resultSet.getString("category"));
                ct.setCategoryID(c);
            } else {
                ct = null;
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ct;
    }

    @Override
    public ArrayList<CategoryBean> getAllCategory() {
        ArrayList<CategoryBean> aCategory = new ArrayList<CategoryBean>();

        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select * from category";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CategoryBean c = new CategoryBean();
                c.setCategory(resultSet.getString("category"));
                c.setCategoryID(resultSet.getInt("categoryID"));
                aCategory.add(c);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aCategory;
    }

}
