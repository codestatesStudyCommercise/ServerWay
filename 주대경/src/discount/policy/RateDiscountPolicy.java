package discount.policy;

public class RateDiscountPolicy implements DiscountPolicy {
  int discountRate;

  public RateDiscountPolicy(int discountRate) {
    this.discountRate = discountRate;
  }

  @Override
  public int calculatePrice(int price) {
    // TODO Auto-generated method stub
    return price - (price * discountRate / 100);
  }

  @Override
  public int discountPrice(int price) {
    // TODO Auto-generated method stub
    return (price * discountRate / 100);
  }
}
