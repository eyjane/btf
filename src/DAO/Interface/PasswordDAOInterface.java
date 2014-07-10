/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Beans.PasswordBean;
import java.util.ArrayList;

/**
 *
 * @author earleenjanefuentes
 */
public interface PasswordDAOInterface {
    
    public boolean addPassword(PasswordBean p);
    public boolean editPassword(PasswordBean p);
    public PasswordBean getPassword(String l);
    public ArrayList<PasswordBean> getAllPassword();
    
}
