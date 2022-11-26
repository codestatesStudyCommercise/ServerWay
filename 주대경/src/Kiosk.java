import java.util.Scanner;

import discount.Discount;
import repository.ProductRepository;

public class Kiosk {
  ProductRepository productRepository;
  Menu menu;
  Cart cart;
  Discount discount;
  Order order;

  public Kiosk(ProductRepository productRepository, Menu menu, Cart cart, Discount discount, Order order) {
    this.productRepository = productRepository;
    this.menu = menu;
    this.cart = cart;
    this.discount = discount;
    this.order = order;
  }

  public void start() {
    Scanner s = new Scanner(System.in);
    System.out.println("🌯 반갑습니다!\n서버웨이입니다.");
    for (;;) {
      System.out.println("\n" + "-".repeat(30));
      System.out.println("(1) 🌯 메뉴 보기");
      System.out.println("(2) 🧺 장바구니 보기");
      System.out.println("(3) 🧾 주문하기");
      System.out.println("-".repeat(30));
      System.out.print("입력해주세요 >>> ");

      String input = s.next();

      if (input.charAt(0) == 'x') {
        try {
          Thread.currentThread();
          Thread.sleep(1500);
        } catch (InterruptedException e) {
          System.out.println("시스템을 종료하던 도중 예기치 못한 문제가 발생했습니다. \n강제로 종료해주세요");
        }
        System.out.println("시스템을 종료합니다.");
        break;
      }

      switch (input.charAt(0)) {
        case '1':
          // 메뉴보기
          menu.selectMenu();
          cart.addToCart(s.nextInt());
          break;
        case '2':
          // 장바구니 보기
          cart.printCart();
          break;
        case '3':
          // 주문하기
          order.makeOrder();
          break;
        default:
          System.out.println("잘못 입력하셨습니다.");
          continue;
      }
    }
  }
}
