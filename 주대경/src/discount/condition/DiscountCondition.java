package discount.condition;

public interface DiscountCondition {
  void checkDiscountCondition();

  int applyDiscount(int price);

  int getDiscountPrice(int price);

  boolean isSatisfied();

  void setSatisfied();
}
