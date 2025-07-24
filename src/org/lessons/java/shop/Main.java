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

        Smartphone smartphone = new Smartphone("Iphone", "Apple", new BigDecimal("1229.00"), new BigDecimal("0.22"),
                "I342L122");

        System.out.println("----------------------- \n Smartphone: \n-----------------------");

        System.out.println("Nome: " + smartphone.getName());
        System.out.println("Brand: " + smartphone.getBrand());
        System.out.println("Prezzo: " + smartphone.getPrice());
        System.out.println("Iva: " + smartphone.getVat());
        System.out.println(smartphone.getImei());
        System.out.println(smartphone.getMemory());

        smartphone.setMemory(130);
        System.out.println(smartphone.getMemory());

        Televisore tv = new Televisore("LE32V342", "Samsung", new BigDecimal("899.00"), new BigDecimal("0.22"), 32,
                true);

        System.out.println("----------------------- \n Tv: \n-----------------------");

        System.out.println("Nome: " + tv.getName());
        System.out.println("Brand: " + tv.getBrand());
        System.out.println("Prezzo: " + tv.getPrice());
        System.out.println("Iva: " + tv.getVat());
        System.out.println(tv.getSize() + "\"");
        System.out.println(tv.getIsSmart());

        tv.setIsSmart(false);
        System.out.println(tv.getIsSmart());

        Cuffie cuffie = new Cuffie("WH-1000XM3", "Sony", new BigDecimal("229.00"), new BigDecimal("0.22"), "Black",
                true);

        System.out.println("----------------------- \n Cuffie: \n-----------------------");

        System.out.println("Nome: " + cuffie.getName());
        System.out.println("Brand: " + cuffie.getBrand());
        System.out.println("Prezzo: " + cuffie.getPrice());
        System.out.println("Iva: " + cuffie.getVat());

        cuffie.setColor("White");
        System.out.println(cuffie.getColor());
    }
}
