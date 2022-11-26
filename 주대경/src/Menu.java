import product.Cookie;
import product.Drink;
import product.Product;
import product.Sandwich;

public class Menu {
  Product[] products;

  public Menu(Product[] products) {
    this.products = products;
  }

  public void selectMenu() {
    System.out.println("\n원하시는 종류의 메뉴을 선택해주세요.");
    // 샌드위치 출력
    printSandwichs();
    System.out.println();

    // 쿠키 출력
    printCookies(true);
    System.out.println();

    // 음료수 출력
    printDrinks(true);

    System.out.println("-".repeat(30));
    System.out.print("메뉴를 입력해주세요 >>> ");
  }

  public void printSandwichs() {
    System.out.println("🌯 샌드위치");
    System.out.println("-".repeat(30));

    for (Product product : products) {
      if (product instanceof Sandwich)
        printEachProduct(product, true);
    }
  };

  public void printCookies(boolean printPrice) {
    System.out.println("🍪 쿠키");
    System.out.println("-".repeat(30));

    for (Product product : products) {
      if (product instanceof Cookie)
        printEachProduct(product, printPrice);
    }
  };

  public void printDrinks(boolean printPrice) {
    System.out.println("🥤 음료수");
    System.out.println("-".repeat(30));

    for (Product product : products) {
      if (product instanceof Drink)
        printEachProduct(product, printPrice);
    }
  }

  void printEachProduct(Product product, boolean printPrice) {
    if (printPrice)
      System.out.printf("(%d) %,d ₩  %-15s", product.getId(), product.getPrice(), product.getName());
    else
      System.out.printf("(%d) %-15s", product.getId(), product.getName());
    System.out.println();
  }
}
