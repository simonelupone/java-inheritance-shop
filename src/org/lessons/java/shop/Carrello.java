package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);

        System.out.println("Quanti articoli vuoi acquistare?");

        String stringaNumeroArticoli = sc.nextLine();
        int numeroArticoli = Integer.parseInt(stringaNumeroArticoli);

        Smartphone iphone = new Smartphone("iPhone 16 pro", "Apple", new BigDecimal(1299.00), new BigDecimal(0.22),
                "IT8675", 128);
        Smartphone galaxy = new Smartphone("Galaxy S25 Ultra", "Samsung", new BigDecimal(1300.00), new BigDecimal(0.22),
                "IL8767", 256);
        Smartphone nothing = new Smartphone("Phone(3)", "Nothing", new BigDecimal(1099.00), new BigDecimal(0.22),
                "IM8797", 128);

        Televisore theFrame = new Televisore("The Frame", "Samsung", new BigDecimal(399.00), new BigDecimal(0.22), 42,
                true);
        Televisore lgUltraGear = new Televisore("Ultra Gear", "LG", new BigDecimal(199.00), new BigDecimal(0.22), 27,
                false);
        Televisore philipsAmbilight = new Televisore("Ambilight", "Philips", new BigDecimal(599.00),
                new BigDecimal(0.22),
                52, true);

        Cuffie wh_1000xm3 = new Cuffie("WH-1000XM3", "Sony", new BigDecimal(229.00), new BigDecimal(0.22), "Black",
                true);
        Cuffie airpods = new Cuffie("Airpods", "Apple", new BigDecimal(199.00), new BigDecimal(0.22), "White", true);
        Cuffie jblTune510 = new Cuffie("Tune 510", "JBL", new BigDecimal(39.00), new BigDecimal(0.22), "Black", true);

        Smartphone[] availableSmartphone = { iphone, galaxy, nothing };
        Televisore[] availableTv = { theFrame, lgUltraGear, philipsAmbilight };
        Cuffie[] availableCuffie = { wh_1000xm3, airpods, jblTune510 };

        String[] carrello = new String[numeroArticoli];

        Prodotto[] oggettiCarrello = new Prodotto[numeroArticoli];

        for (int i = 0; i < numeroArticoli; i++) {
            System.out
                    .println("Scegli un articolo tra:\n\n1) Smarphone\n2) Televisore\n3) Cuffie\n\nArticolo" + " "
                            + (i + 1) + ":");

            String selectedDevice = sc.nextLine();

            if (selectedDevice.equals("1")) {
                carrello[i] = "smartphone";
            } else if (selectedDevice.equals("2")) {
                carrello[i] = "televisore";
            } else if (selectedDevice.equals("3")) {
                carrello[i] = "cuffie";
            }

            System.out.println("\nHai scelto: " + carrello[i]);

            if (carrello[i].toLowerCase().equals("smartphone")) {
                System.out.println(
                        "\nScegli uno tra i dispositivi disponibili:\n(Scrivi il numero del dispositivo che vuoi acquistare)\n");
                for (int j = 0; j < availableSmartphone.length; j++) {
                    System.out.println((j + 1) + ") " + availableSmartphone[j].getName());
                }

                String selectedSmartphone = sc.nextLine();

                if (selectedSmartphone.equals("1")) {
                    oggettiCarrello[i] = iphone;
                    System.out.println("Hai scelto " + iphone.getName());
                } else if (selectedSmartphone.equals("2")) {
                    oggettiCarrello[i] = galaxy;
                    System.out.println("Hai scelto " + galaxy.getName());
                } else if (selectedSmartphone.equals("3")) {
                    oggettiCarrello[i] = nothing;
                    System.out.println("Hai scelto " + nothing.getName());
                }

            } else if (carrello[i].toLowerCase().equals("televisore")) {
                System.out.println(
                        "\nScegli uno tra i dispositivi disponibili:\n(Scrivi il numero del dispositivo che vuoi acquistare)\n");
                for (int j = 0; j < availableTv.length; j++) {
                    System.out.println((j + 1) + ") " + availableTv[j].getName());
                }

                String selectedTv = sc.nextLine();

                if (selectedTv.equals("1")) {
                    oggettiCarrello[i] = theFrame;
                    System.out.println("Hai scelto " + theFrame.getName());
                } else if (selectedTv.equals("2")) {
                    oggettiCarrello[i] = lgUltraGear;
                    System.out.println("Hai scelto " + lgUltraGear.getName());
                } else if (selectedTv.equals("3")) {
                    oggettiCarrello[i] = philipsAmbilight;
                    System.out.println("Hai scelto " + philipsAmbilight.getName());
                }

            } else if (carrello[i].toLowerCase().equals("cuffie")) {
                System.out.println(
                        "\nScegli uno tra i dispositivi disponibili:\n(Scrivi il numero del dispositivo che vuoi acquistare)\n");
                for (int j = 0; j < availableCuffie.length; j++) {
                    System.out.println((j + 1) + ") " + availableCuffie[j].getName());
                }

                String selectedCuffie = sc.nextLine();

                if (selectedCuffie.equals("1")) {
                    oggettiCarrello[i] = wh_1000xm3;
                    System.out.println("Hai scelto " + wh_1000xm3.getName());
                } else if (selectedCuffie.equals("2")) {
                    oggettiCarrello[i] = airpods;
                    System.out.println("Hai scelto " + airpods.getName());
                } else if (selectedCuffie.equals("3")) {
                    oggettiCarrello[i] = jblTune510;
                    System.out.println("Hai scelto " + jblTune510.getName());
                }
            } else {
                System.out.println("Inserisci un prodotto tra Smarphone, Televisore, Cuffie!");
            }
        }

        System.out.println("Hai una carta fedeltà?\n (S/N)");
        String response = sc.nextLine();
        boolean fidelityCard = response.equalsIgnoreCase("S") ? true : false;

        System.out.println("--------------------------------------------\nIl tuo carrello:\n");
        for (int i = 0; i < oggettiCarrello.length; i++) {
            System.out.println(oggettiCarrello[i]);
        }

        DiscountUtility<Prodotto> utility = new DiscountUtility<Prodotto>();
        BigDecimal total = new BigDecimal(0);
        for(int i = 0; i < oggettiCarrello.length; i++){
            BigDecimal prezzoFinale = utility.discount(oggettiCarrello[i], fidelityCard);
            total = total.add(prezzoFinale).setScale(2, RoundingMode.HALF_EVEN);
        }

        System.out.println("\n---- TOTALE: " + total + " euro ----\n");

        System.out.println("--------------------------------------------");
        sc.close();
    }
}
