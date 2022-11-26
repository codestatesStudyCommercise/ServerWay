package discount.policy;

public class AmountDiscountPolicy implements DiscountPolicy {
  int fixAmount;

  public AmountDiscountPolicy(int fixAmount) {
    this.fixAmount = fixAmount;
  }

  @Override
  public int calculatePrice(int price) {
    // TODO Auto-generated method stub
    return price - fixAmount;
  }

  @Override
  public int discountPrice(int price) {
    // TODO Auto-generated method stub
    return fixAmount;
  }
}
