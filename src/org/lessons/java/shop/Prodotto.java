package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {
    private int code;
    private String name;
    private String brand;
    private BigDecimal price;
    private BigDecimal vat;

    public Prodotto(String name, String brand, BigDecimal price, BigDecimal vat) {
        this.code = randomCode();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.vat = vat;
    }

    private int randomCode() {
        Random rn = new Random();
        return this.code = rn.nextInt(9999);
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        if (brand != null) {
            this.brand = brand;
        }
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            this.price = price;
        }
    }

    public BigDecimal getVat() {
        return this.vat;
    }

    public void setVat(BigDecimal vat) {
        if (vat.compareTo(BigDecimal.ZERO) > 0 && vat.compareTo(BigDecimal.ONE) <= 0) {
            this.vat = vat;
        }
    }

    // metodi che sono overraidati nelle classi che sono estese da Prodotto
    public int getMemory(){
        return 128;
    }

    public boolean getIsSmart(){
        return false;
    }

    public boolean getIsWireless(){
        return false;
    }


    public BigDecimal discount(Prodotto prodotto, boolean discountCard){
        BigDecimal discountedPrice = new BigDecimal(0);
        if(discountCard){
            if(prodotto instanceof Smartphone){
                if(prodotto.getMemory() < 256){
                    discountedPrice = prodotto.getPrice().subtract(prodotto.getPrice().multiply(new BigDecimal(0.05)));
                }
            } else if(prodotto instanceof Televisore){
                if(prodotto.getIsSmart()){
                    discountedPrice = prodotto.getPrice().subtract(prodotto.getPrice().multiply(new BigDecimal(0.10)));
                }
            } else if(prodotto instanceof Cuffie){
                if(prodotto.getIsWireless()){
                    discountedPrice = prodotto.getPrice().subtract(prodotto.getPrice().multiply(new BigDecimal(0.07)));
                }
            }
            return discountedPrice;
        }
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s euro", this.name, this.brand,
                this.price.setScale(2, RoundingMode.HALF_EVEN).toString());
    }
}
