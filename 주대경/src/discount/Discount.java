package discount;

import discount.condition.DiscountCondition;

public class Discount {
  DiscountCondition[] DCs;
  DiscountCondition maxDC;

  public Discount(DiscountCondition[] dCs) {
    DCs = dCs;
  }

  public void checkAllDiscountCondition() {
    // 할인 조건들 출력하여 받기
    for (DiscountCondition dc : DCs) {
      dc.checkDiscountCondition();
      System.out.println();
    }
  }

  public int getDiscountPrice(int price) {
    return this.maxDC.getDiscountPrice(price);
  }

  public int discount(int price) {
    // 실제 할인된 계산 반환
    int minPrice = Integer.MAX_VALUE;
    for (DiscountCondition dc : DCs) {
      if (dc.isSatisfied() != true)
        continue;
      if (dc.applyDiscount(price) < minPrice) {
        minPrice = dc.applyDiscount(price);
        this.maxDC = dc;
      }
      dc.setSatisfied();
    }
    return minPrice;
  }
}
