/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.util.Date;

/**
 *
 * @author earleenjanefuentes
 */
public class TransactionBean {
    private int transactionID;
    private Date date;
    private RawBean raw;
    private String type;
    
    public TransactionBean(){
        
    }
    
    public TransactionBean(float a, Date d, RawBean r, String t){
        
        date = d;
        raw = r;
        type = t;
    }

    public Date getDate() {
        return date;
    }

    public RawBean getRaw() {
        return raw;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public String getType() {
        return type;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public void setRaw(RawBean raw) {
        this.raw = raw;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
