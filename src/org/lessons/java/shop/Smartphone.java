package org.lessons.java.shop;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {
    private String imei;
    private int memory;

    public Smartphone(String name, String brand, BigDecimal price, BigDecimal vat, String imei, int memory) {
        super(name, brand, price, vat);
        this.imei = imei;
        setMemory(memory);
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        if (imei != null) {
            this.imei = imei;
        }
    }

    @Override
    public int getMemory() {
        return this.memory;
    }

    /* public BigDecimal discount(boolean discountCard){
        if(discountCard){
            if(this.memory < 256){
                return this.getPrice().subtract(this.getPrice().multiply(new BigDecimal(0.05)));
            }
            return this.getPrice().subtract(this.getPrice().multiply(new BigDecimal(0.02)));
        }
        return this.getPrice();
    } */

    public void setMemory(int memory) {
        // controllo se i tagli sono validi attraverso bitwise AND
        // (se sono potenze di 2)
        if ((memory & (memory - 1)) == 0 && memory > 128) {
            this.memory = memory;
        }
    }

    @Override
    public String toString() {
        return String.format("Smartphone: %s", super.toString());
    }
}