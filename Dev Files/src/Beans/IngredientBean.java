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
public class IngredientBean {
    private RawBean raw;
    private float amount;

    public IngredientBean() {
        raw = null;
        amount = 0;
    }

    public IngredientBean(RawBean raw, float amount) {
        this.raw = raw;
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public RawBean getRaw() {
        return raw;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setRaw(RawBean raw) {
        this.raw = raw;
    }
    
    
    
}
