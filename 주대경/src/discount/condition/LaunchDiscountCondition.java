package discount.condition;

import java.util.Scanner;

import discount.policy.DiscountPolicy;

public class LaunchDiscountCondition implements DiscountCondition {
  DiscountPolicy dp;
  boolean satisfied;

  public LaunchDiscountCondition(DiscountPolicy dp) {
    this.dp = dp;
  }

  @Override
  public void checkDiscountCondition() {
    // TODO Auto-generated method stub
    Scanner s = new Scanner(System.in);
    System.out.print("\n현재 시간이 몇 시인가요?  \n24시간제로 입력해주세요 >>> ");
    int input = Integer.parseInt(s.next());
    if (10 <= input && input < 13) {
      this.satisfied = isSatisfied();
    }
  }

  @Override
  public int getDiscountPrice(int price) {
    // TODO Auto-generated method stub
    return dp.discountPrice(price);
  }

  @Override
  public int applyDiscount(int price) {
    // TODO Auto-generated method stub
    return dp.calculatePrice(price);
  }

  @Override
  public boolean isSatisfied() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public void setSatisfied() {
    // TODO Auto-generated method stub
    this.satisfied = false;
  }
}
