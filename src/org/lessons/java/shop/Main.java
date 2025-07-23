package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Prodotto prodotto = new Prodotto("Prodotto", "Brand", new BigDecimal("100.00"), new BigDecimal("0.22"));

        System.out.println("----------------------- \n Dati costruttore: \n-----------------------");

        System.out.println("Codice: " + prodotto.getCode());
        System.out.println("Nome: " + prodotto.getName());
        System.out.println("Brand: " + prodotto.getBrand());
        System.out.println("Prezzo: " + prodotto.getPrice());
        System.out.println("Iva: " + prodotto.getVat());

        prodotto.setBrand("Apple");
        prodotto.setName("iPhone");
        prodotto.setPrice(new BigDecimal("1459.00"));
        prodotto.setVat(new BigDecimal("0.20"));

        System.out.println("----------------------- \n Test: \n-----------------------");

        System.out.println("Nome: " + prodotto.getName());
        System.out.println("Brand: " + prodotto.getBrand());
        System.out.println("Prezzo: " + prodotto.getPrice());
        System.out.println("Iva: " + prodotto.getVat());
    }
}
