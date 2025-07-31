package org.lessons.java.shop;

import java.math.BigDecimal;

public class DiscountUtility<T extends Prodotto> {
  public BigDecimal discount(T prodotto, boolean discountCard){
    if(discountCard){
      BigDecimal price = prodotto.getPrice();
      BigDecimal discountedPrice = price.multiply(BigDecimal.valueOf(0.02));

        if(prodotto instanceof Smartphone smartphone){
          if(smartphone.getMemory() < 256){
            discountedPrice = price.multiply(BigDecimal.valueOf(0.05));
          }
        } else if (prodotto instanceof Televisore televisore) {
          if (televisore.getIsSmart()) {
              discountedPrice = price.multiply(BigDecimal.valueOf(0.10));
          }
        } else if (prodotto instanceof Cuffie cuffie) {
          if (cuffie.getIsWireless()) {
              discountedPrice = price.multiply(BigDecimal.valueOf(0.07));
          }
      }
      return price.subtract(discountedPrice);
    }

  return prodotto.getPrice();
  }
}

