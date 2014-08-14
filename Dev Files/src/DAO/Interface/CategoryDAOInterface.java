/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.CategoryBean;
import java.util.ArrayList;

/**
 *
 * @author earleenjanefuentes
 */
public interface CategoryDAOInterface {

    public boolean addCategory(CategoryBean c);

    public boolean deleteCategory(CategoryBean c);

    public boolean editCategory(CategoryBean c);

    public CategoryBean getCategory(int c);
    
    public int getLatestAddedID();
    
    public ArrayList<CategoryBean> getAllCategory();

}
