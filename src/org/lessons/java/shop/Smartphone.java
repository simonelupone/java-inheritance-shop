package org.lessons.java.shop;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {
    private String imei;
    private int memory;

    public Smartphone(String name, String brand, BigDecimal price, BigDecimal vat, String imei) {
        this.imei = imei;
        this.memory = 128;
        super(name, brand, price, vat);
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        if (imei != null) {
            this.imei = imei;
        }
    }

    public int getMemory() {
        return this.memory;
    }

    public void setMemory(int memory) {
        // controllo se i tagli sono validi attraverso bitwise AND
        // (se sono potenze di 2)
        if ((memory & (memory - 1)) == 0 && memory > 128) {
            this.memory = memory;
        }
    }
}
