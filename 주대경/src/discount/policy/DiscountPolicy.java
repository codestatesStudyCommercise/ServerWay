package discount.policy;

public interface DiscountPolicy {
  int calculatePrice(int price);

  int discountPrice(int price);
}
