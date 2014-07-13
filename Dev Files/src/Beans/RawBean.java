/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author earleenjanefuentes
 */
public class RawBean {

    private int rawID;
    private String raw;
    private float price;
    private float stock;
    private float critical;
    private String rmstatus;
    private String uom;

    public RawBean(){}
    
    public RawBean(String rw, float p, float s, float c, String rs, String u) {
        //rawID = r;
        raw = rw;
        price = p;
        stock = s;
        critical = c;
        rmstatus = rs;
        uom = u;
    }
    
    public boolean isCritical(){
        if(stock <= critical){
            return true;
        }
        
        return false;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getUom() {
        return uom;
    }

    public int getRawID() {
        return rawID;
    }

    public String getRaw() {
        return raw;
    }

    public float getPrice() {
        return price;
    }

    public float getStock() {
        return stock;
    }
    
    public float getCritical() {
        return critical;
    }

    public String getRmstatus() {
        return rmstatus;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public void setRawID(int rawID) {
        this.rawID = rawID;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCritical(float critical) {
        this.critical = critical;
    }

    public void setRmstatus(String rmstatus) {
        this.rmstatus = rmstatus;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

}
