package org.lessons.java.shop;

import java.math.BigDecimal;

public class Cuffie extends Prodotto {

    private String color;
    private boolean isWireless;

    public Cuffie(String name, String brand, BigDecimal price, BigDecimal vat, String color, boolean isWireless) {
        this.color = color;
        this.isWireless = isWireless;
        super(name, brand, price, vat);
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        if (color != null) {
            this.color = color;
        }
    }

    public boolean getIsWireless() {
        return this.isWireless;
    }

    public void setIsWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }
}
