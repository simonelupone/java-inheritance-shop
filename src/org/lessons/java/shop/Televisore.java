package org.lessons.java.shop;

import java.math.BigDecimal;

public class Televisore extends Prodotto {

    private int size;
    private boolean isSmart;

    public Televisore(String nome, String brand, BigDecimal price, BigDecimal vat, int size, boolean isSmart) {
        super(nome, brand, price, vat);
        this.size = size;
        this.isSmart = isSmart;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        if (size > 0) {
            this.size = size;
        }
    }

    @Override
    public boolean getIsSmart() {
        return this.isSmart;
    }

    public void setIsSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return String.format("Televisore: %s", super.toString());
    }
}
