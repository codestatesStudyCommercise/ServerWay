import java.util.Scanner;

import discount.Discount;

public class Order {
  Cart cart;
  Discount discount;

  public Order(Cart cart, Discount discount) {
    this.cart = cart;
    this.discount = discount;
  }

  public void makeOrder() {
    if (cart.getItems().isEmpty())
      System.out.println("장바구니가 비었습니다.");
    else {
      Scanner s = new Scanner(System.in);
      discount.checkAllDiscountCondition();
      System.out.println();
      cart.printCart();

      int total = cart.getItems().stream().map(p -> p.getPrice()).mapToInt(Integer::new).sum();
      int discountedPrice = discount.discount(total);
      System.out.println("-".repeat(30));
      System.out.printf("-%-,9d원 : %12s\n", discount.getDiscountPrice(total), "할인 금액");
      System.out.printf(" %-,9d원 : %12s\n", discountedPrice, "내실 금액");
      System.out.println("\n주문 하시겠습니까?");
      System.out.print("(1) 예 (2) 장바구니 초기화 (3) 아니오 >>> ");

      String input = s.next();
      if (input.equals("1")) {
        cart.getItems().clear();
        System.out.println("이용해주셔서 감사합니다.감사합니다.");
      } else if (input.equals("2"))
        cart.getItems().clear();
    }
  }
}