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
            String query = "UPDATE raw SET raw = ?, price = ?, stock = ?, uom = ?, critical = ? WHERE rawID = ?;";
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
    public boolean restockRaw (RawBean r) {
        
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE raw SET stock = ? WHERE raw = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setFloat(1, r.getStock());
            preparedStatement.setString(2, r.getRaw());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RawDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }
    
    
}
