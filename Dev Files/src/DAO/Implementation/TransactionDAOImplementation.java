/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.RawBean;
import Beans.TransactionBean;
import DAO.Interface.RawDAOInterface;
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
public class TransactionDAOImplementation implements TransactionDAOInterface {

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
            if (resultSet.next()) {
                int transactionID = resultSet.getInt("max(transactionID)");
                String tquery = "INSERT into transact(transactionID, rawID, quantity, price) values (?, ?, ?, ?);";
                PreparedStatement tpreparedStatement = connection.prepareStatement(tquery);
                tpreparedStatement.setInt(1, transactionID);
                tpreparedStatement.setInt(2, r.getRawID());
                tpreparedStatement.setFloat(3, a);
                tpreparedStatement.setFloat(4, r.getPrice());

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
    
    @Override
    public boolean addTransaction(TransactionBean t, RawBean r, float a, String d) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT into transactions(transaction_date, transaction_type) values (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, d);
            preparedStatement.setString(2, t.getType());

            preparedStatement.executeUpdate();

            /* add to transact table */
            query = "SELECT max(transactionID) from transactions;";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int transactionID = resultSet.getInt("max(transactionID)");
                String tquery = "INSERT into transact(transactionID, rawID, quantity, price) values (?, ?, ?, ?);";
                PreparedStatement tpreparedStatement = connection.prepareStatement(tquery);
                tpreparedStatement.setInt(1, transactionID);
                tpreparedStatement.setInt(2, r.getRawID());
                tpreparedStatement.setFloat(3, a);
                tpreparedStatement.setFloat(4, r.getPrice());

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

    @Override
    public ArrayList<String> getAllDates() {
        ArrayList<String> aDates = new ArrayList<String>();
        try {
            float x = 0;
            String query = "select distinct(transaction_date) "
                    + "from transactions "
                    + "order by 1 asc;";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                aDates.add(resultSet.getString("transaction_date"));
            }
            connection.close();
            return aDates;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aDates;
    }

    /* checked - GETS SUM OF ALL QUANTITY SORTED BY TYPE */
    @Override

    public float sumQuantityByDay(String d, String s) {

        try {
            String query = "select t.transaction_date, transaction_type, sum(quantity) "
                    + "from transactions t, raw r, transact tc "
                    + "where t.transactionID = tc.transactionID AND r.rawID = tc.rawID and transaction_date = ? and transaction_type = ?;";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, d);
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

    @Override
    public float getQuantityByDayByRaw(String d, String s, RawBean r) {
        try {
            String query = "select tc.transactionID, transaction_type, quantity, transaction_date "
                    + "from transactions t, transact tc "
                    + "where rawID = ? and t.transactionID = tc.transactionID and transaction_date = ? and transaction_type = ?;";
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

    // Input Actual Values from manual count
    @Override
    public boolean actualInput(TransactionBean t, RawBean r, float a) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT into transactions(transaction_date, transaction_type) values (?, 'actual');";
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
            if (resultSet.next()) {
                int transactionID = resultSet.getInt("max(transactionID)");
                String tquery = "INSERT into transact(transactionID, rawID, quantity, price) values (?, ?, ?, ?);";
                PreparedStatement tpreparedStatement = connection.prepareStatement(tquery);
                tpreparedStatement.setInt(1, transactionID);
                tpreparedStatement.setInt(2, r.getRawID());
                tpreparedStatement.setFloat(3, a);
                tpreparedStatement.setFloat(4, r.getPrice());

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

    // Input values of Used/Transfer
    @Override
    public boolean usedTransfer(TransactionBean t, RawBean r, float a, String type) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();

            String query = "INSERT into transactions(transaction_date, transaction_type) values (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            /* create date*/
            java.util.Date now = new java.util.Date();
            java.sql.Date today = new java.sql.Date(now.getTime());

            preparedStatement.setDate(1, today);
            preparedStatement.setString(2, type);

            preparedStatement.executeUpdate();

            /* add to transact table */
            query = "SELECT max(transactionID) from transactions;";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int transactionID = resultSet.getInt("max(transactionID)");
                String tquery = "INSERT into transact(transactionID, rawID, quantity, price) values (?, ?, ?, ?);";
                PreparedStatement tpreparedStatement = connection.prepareStatement(tquery);
                tpreparedStatement.setInt(1, transactionID);
                tpreparedStatement.setInt(2, r.getRawID());
                tpreparedStatement.setFloat(3, a);
                tpreparedStatement.setFloat(4, r.getPrice());

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

    @Override
    public ArrayList<String> getRangeDates(String f, String t) {
        ArrayList<String> aDates = new ArrayList<String>();
        try {
            float x = 0;
            String query = "select distinct(transaction_date) "
                    + "from transactions "
                    + "where transaction_date >= '" + f + "' and transaction_date <= '" + t + "' "
                    + "order by 1 desc;";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                aDates.add(resultSet.getString("transaction_date"));
            }
            connection.close();
            return aDates;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aDates;
    }

    @Override
    public String getDayBefore(String d) {
        String date = "";
        try {
            int c = 0;
            String query = "select distinct(transaction_date) "
                    + "from transactions "
                    + "where transaction_date <= '" + d + "' "
                    + "order by 1 desc;";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (c == 1) {
                    date = resultSet.getString("transaction_date");
                    break;
                }
                c++;
            }
            connection.close();
            return date;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return date;
    }

    @Override
    public ArrayList<RawBean> getAllTRaw(String d) {
        RawDAOInterface rmImp = new RawDAOImplementation();
        ArrayList<RawBean> aRaw = new ArrayList<RawBean>();
        try {
            int c = 0;
            String query = "select distinct(r.rawID), raw "
                    + "from transactions ts, transact tc, raw r "
                    + "where transaction_date = '"+ d + "' and tc.rawID = r.rawID "
                    + "order by 2 asc";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RawBean rm = rmImp.getRaw(resultSet.getInt("rawID"));
                //set the stock to beginning
                float s = this.getQuantityByDayByRaw(this.getDayBefore(d), "actual", rm);
                rm.setStock(s);
                aRaw.add(rm);
            }
            connection.close();
            return aRaw;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aRaw;

    }

}
