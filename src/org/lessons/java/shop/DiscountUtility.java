package org.lessons.java.shop;

import java.math.BigDecimal;

public class DiscountUtility<T extends Prodotto> {
  public BigDecimal discount(T prodotto, boolean discountCard){
    if(!discountCard){
      return prodotto.getPrice();
    }

    BigDecimal discountedPrice = new BigDecimal(0);
    BigDecimal price = prodotto.getPrice();

    if(prodotto instanceof Smartphone){
      if(prodotto.getMemory() < 256){
        discountedPrice = price.multiply(BigDecimal.valueOf(0.05));
      }
    } else if (prodotto instanceof Televisore) {
      if (prodotto.getIsSmart()) {
          discountedPrice = price.multiply(BigDecimal.valueOf(0.10));
      }
    } else if (prodotto instanceof Cuffie) {
      if (prodotto.getIsWireless()) {
          discountedPrice = price.multiply(BigDecimal.valueOf(0.07));
      }
  }
  return price.subtract(discountedPrice);
  }
}

