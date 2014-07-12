/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.RawBean;
import Beans.RecipeBean;
import Beans.SalesBean;
import DAO.Interface.RawDAOInterface;
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
public class RawDAOImplementation implements RawDAOInterface {

    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;

    @Override
    public boolean addRaw(RawBean r) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT into raw(raw, price, stock, critical, uom, rmstatus) values (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, r.getRaw());
            preparedStatement.setFloat(2, r.getPrice());
            preparedStatement.setFloat(3, r.getStock());
            preparedStatement.setFloat(4, r.getCritical());
            preparedStatement.setString(5, r.getUom());
            preparedStatement.setString(6, r.getRmstatus());

            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RawDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteRaw(RawBean r) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE raw SET rmstatus = ? WHERE rawID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "deleted");
            preparedStatement.setInt(2, r.getRawID());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RawDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editRaw(RawBean r) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE raw SET raw = ?, price = ?, stock = ? uom = ?, critical = ? WHERE rawID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getRaw());
            preparedStatement.setFloat(2, r.getPrice());
            preparedStatement.setFloat(3, r.getStock());
            preparedStatement.setString(4, r.getUom());
            preparedStatement.setFloat(5, r.getCritical());
            preparedStatement.setInt(6, r.getRawID());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RawDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public RawBean getRaw(int rm) {
        RawBean r = new RawBean();

        try {
            String query = "select * from raw where rawID = ?";
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rm);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                r.setRawID(rm);
                r.setRaw(resultSet.getString("raw"));
                r.setPrice(resultSet.getFloat("price"));
                r.setCritical(resultSet.getFloat("critical"));
                r.setStock(resultSet.getFloat("stock"));
                r.setRmstatus(resultSet.getString("rmstatus"));
                r.setUom(resultSet.getString("uom"));

            } else {
                r = null;
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public ArrayList<RawBean> getAllRaw() {
       ArrayList<RawBean> aRaw = new ArrayList<RawBean>();
        
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select * from raw";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RawBean r = new RawBean();
                r.setRawID(resultSet.getInt("rawID"));
                r.setRaw(resultSet.getString("raw"));
                r.setPrice(resultSet.getFloat("price"));
                r.setCritical(resultSet.getFloat("critical"));
                r.setStock(resultSet.getFloat("stock"));
                r.setRmstatus(resultSet.getString("rmstatus"));
                r.setUom(resultSet.getString("uom"));
                
                aRaw.add(r);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(RawDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aRaw;
    }

    @Override
    public ArrayList<RawBean> getRawByStatus(String s) {
        ArrayList<RawBean> aRaw = new ArrayList<RawBean>();
        
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select * from raw where rmstatus = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RawBean r = new RawBean();
                r.setRawID(resultSet.getInt("rawID"));
                r.setRaw(resultSet.getString("raw"));
                r.setPrice(resultSet.getFloat("price"));
                r.setCritical(resultSet.getFloat("critical"));
                r.setStock(resultSet.getFloat("stock"));
                r.setRmstatus(resultSet.getString("rmstatus"));
                r.setUom(resultSet.getString("uom"));
                
                aRaw.add(r);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(RawDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aRaw;
       
    }
    
    @Override
    public boolean reduceRaw (RawBean r, SalesBean s) { // DIRECTLY REDUCE RAW MATERIAL ACCDG TO SALES.

        /*
         * 
         *  (1 rawMaterial * amount_Ingredient) * # of dishes sold
         * 
         */
        
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
           
            /*
            *  1. GET ALL SALES - USE FOR LOOP
            */
            String sales = "SELECT salesID FROM sales WHERE sales_type = 'sales'";
            PreparedStatement preparedStatement = connection.prepareStatement(sales);
            preparedStatement.setInt(1, s.getSalesID());
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) { // while there is a sale with ingredients to update (updates per sale/corresponding recipe & ingredients/RM
                
                /*
                 *  2. Computes remaining stock for each ingredient/raw material involved in recipe in sale (from loop)
                 */
                String RawPerRecipe = "SELECT sales.salesID AS 'SalesID', (raw.stock - (sold.quantity * I.amount)) AS 'Remaining', "
                        + "raw.rawID AS 'RawID', raw.critical AS 'CriticalAmt'" 
                        + "FROM sales NATURAL JOIN sold NATURAL JOIN recipe AS R NATURAL JOIN ingredients as I JOIN raw" 
                        + "WHERE sales_type = 'sales' AND raw.rawID = I.rawID AND sales.salesID = '" + resultSet.getInt("salesID") + "'";
                
                PreparedStatement RPP = connection.prepareStatement(RawPerRecipe);
                RPP.setInt(1, s.getSalesID());
                RPP.setInt(3, r.getRawID());
                ResultSet reduce = RPP.executeQuery();
                
                while(reduce.next()) { // while there is an ingredient to update (updates per ingredient)
                
                    int remainingStock = reduce.getInt("Remaining");
                    int crit = reduce.getInt("CriticalAmt");
                    
                    if(remainingStock <= 0) { // STOCK = 0
                        
                        String changeStatus = "UPDATE raw SET rmstatus = 'Out of Stock' WHERE rawID = '" + reduce.getInt("RawID") + "'";
                        PreparedStatement CS = connection.prepareStatement(changeStatus);
                        CS.setString(1, r.getRmstatus());
                        CS.setInt(2, r.getRawID());
                        CS.executeUpdate();
                    }
                    else if (remainingStock < crit) { // remaining is less than critical amount
                        
                        String changeStatus = "UPDATE raw SET rmstatus = 'Low Stock' WHERE rawID = '" + reduce.getInt("RawID") + "'";
                        PreparedStatement CS = connection.prepareStatement(changeStatus);
                        CS.setString(1, r.getRmstatus());
                        CS.setInt(2, r.getRawID());
                        CS.executeUpdate();
                        
                        
                    }
                    
                    // UPDATE TO REFLECT NEW REMAINING AMOUNT OF STOCK
                    String modify = "UPDATE raw SET stock = '" + reduce.getInt("Remaining") + "WHERE rawID = '" + reduce.getInt("RawID") + "'";
                    PreparedStatement m = connection.prepareStatement(modify);
                    m.setInt(2, r.getRawID());
                    RPP.executeUpdate();
                    
                }
                
            }
            
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RawDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

}
