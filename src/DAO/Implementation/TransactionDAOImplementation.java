/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Implementation;

import Beans.RawBean;
import Beans.TransactionBean;
import DAO.Interface.TransactionDAOInterface;
import DBConnection.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author earleenjanefuentes
 */
public class TransactionDAOImplementation implements TransactionDAOInterface{

    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;
    
    /*checked!*/
    @Override
    public boolean addTransaction(TransactionBean t, RawBean r, float a) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT into transactions(transaction_date, transaction_type) values (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            /* create date*/
            java.util.Date now = new java.util.Date();
            java.sql.Date today = new java.sql.Date(now.getTime());

            preparedStatement.setDate(1, today);
            preparedStatement.setString(2, t.getType());
            
            preparedStatement.executeUpdate();
            
            
            /* add to transact table */
            query = "SELECT max(transactionID) from transactions;";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int transactionID = resultSet.getInt("max(transactionID)");
                String tquery = "INSERT into transact(transactionID, rawID, quantity) values (?, ?, ?);";
                PreparedStatement tpreparedStatement = connection.prepareStatement(tquery);
                tpreparedStatement.setInt(1, transactionID);
                tpreparedStatement.setInt(2, r.getRawID());
                tpreparedStatement.setFloat(3, a);
                
                tpreparedStatement.executeUpdate();
                connection.close();
                return true;
            }
            
            connection.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /* checked - GETS SUM OF ALL QUANTITY SORTED BY TYPE */
    @Override
    public float sumAllTransactionByDay(Date d, String s) {
        try {
            String query = "select t.transaction_date, transaction_type, sum(quantity) " +
                            "from transactions t, raw r, transact tc " +
                            "where t.transactionID = tc.transactionID AND r.rawID = tc.rawID and transaction_date = ? and transaction_type = ?;";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, (java.sql.Date) d);
            preparedStatement.setString(2, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                float x = resultSet.getFloat("sum(quantity)");
                connection.close();
                return x;

            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /* checked! - GETS QUANTITY ONLY
    @Override
    public float getQuantityByDayByRaw(String d, String s, RawBean r) {
        try {
            String query = "select tc.transactionID, transaction_type, quantity, transaction_date " +
                            "from transactions t, transact tc " +
                            "where rawID = ? and t.transactionID = tc.transactionID and transaction_date = ? and transaction_type = ?;";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getRawID());
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
*/
    // Input Actual Values from manual count
    @Override
    public boolean actualInput(TransactionBean t, RawBean r, float a) {
         try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT into transactions(transaction_date, transaction_type) values (?, 'Actual');";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            /* create date*/
            java.util.Date now = new java.util.Date();
            java.sql.Date today = new java.sql.Date(now.getTime());

            preparedStatement.setDate(1, today);
            preparedStatement.setString(2, t.getType());
            
            preparedStatement.executeUpdate();
            
            
            /* add to transact table */
            query = "SELECT max(transactionID) from transactions;";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int transactionID = resultSet.getInt("max(transactionID)");
                String tquery = "INSERT into transact(transactionID, rawID, quantity) values (?, ?, ?);";
                PreparedStatement tpreparedStatement = connection.prepareStatement(tquery);
                tpreparedStatement.setInt(1, transactionID);
                tpreparedStatement.setInt(2, r.getRawID());
                tpreparedStatement.setFloat(3, a);
                
                tpreparedStatement.executeUpdate();
                connection.close();
                return true;
            }
            
            connection.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
   
}
