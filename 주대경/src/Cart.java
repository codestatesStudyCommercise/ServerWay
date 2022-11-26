import java.util.ArrayList;
import java.util.Scanner;

import option.Bread;
import option.Cheese;
import option.Ingredient;
import option.Sauce;
import option.Vegetable;
import product.Cookie;
import product.Drink;
import product.Product;
import product.Sandwich;
import product.SandwichSet;
import repository.OptionRepository;
import repository.ProductRepository;

public class Cart {
  private ArrayList<Product> items = new ArrayList<Product>();
  private ProductRepository productRepository;
  private OptionRepository optionRepository;
  private Menu menu;

  public Cart(ProductRepository productRepository, Menu menu, OptionRepository optionRepository) {
    this.productRepository = productRepository;
    this.menu = menu;
    this.optionRepository = optionRepository;
  }

  public ArrayList<Product> getItems() {
    return items;
  }

  public void printCart() {
    System.out.println("-".repeat(30));
    if (items.isEmpty())
      System.out.println("장바구니가 비었습니다.\n");
    else {
      for (Product item : items)
        System.out.printf("%-,7d원 : %12s\n", item.getPrice(), item.getName());
      System.out.println("-".repeat(30));

      int sum = items.stream().map(p -> p.getPrice()).mapToInt(Integer::new).sum();
      System.out.printf("%-,7d원 : %12s\n", sum, "합계");
    }
  }

  public void addToCart(int productId) {
    Scanner s = new Scanner(System.in);
    Product newProduct = null;
    Product product = productRepository.findById(productId);

    // 샌드위치일 경우,
    // 세트인지 세트면 세트 설정으로.
    // 길이 설정, 옵션 설정.
    if (product instanceof Sandwich) {
      System.out.print("\n세트 이신가요? \n (1) 예  (2) 아니오 >>> ");

      String input = s.next();

      if (input.equals("1")) {
        Sandwich sandwich = chooseSandwichOption((Sandwich) product);

        menu.printCookies(false);

        System.out.println("-".repeat(30));
        System.out.print("메뉴를 입력해주세요 >>> ");
        Cookie cookie = new Cookie((Cookie) productRepository.findById(s.nextInt()));

        menu.printDrinks(false);

        System.out.println("-".repeat(30));
        System.out.print("메뉴를 입력해주세요 >>> ");
        Drink drink = new Drink((Drink) productRepository.findById(s.nextInt()));

        newProduct = new SandwichSet(sandwich, cookie, drink);
      } else {
        newProduct = chooseSandwichOption((Sandwich) product);
      }
    }
    // 쿠키일 겨웅, 장바구니 추가
    if (product instanceof Cookie) {
      newProduct = new Cookie((Cookie) product);
    }

    // 음료수 일경우, 장바구니 추가
    if (product instanceof Drink) {
      newProduct = new Drink((Drink) product);
    }

    if (newProduct != null)
      items.add(newProduct);
  }

  Sandwich chooseSandwichOption(Sandwich sandwich) {
    Scanner s = new Scanner(System.in);
    System.out.print("\n15cm인가요? \n (1) 예  (2) 아니오 >>> ");
    if (!s.next().equals("1")) {
      sandwich.setIs30cm(true);
    }

    // 빵 옵션
    printBreads();
    Bread bread = new Bread(optionRepository.findBreadById(s.nextInt()));
    // 치즈 옵션
    printCheeses();
    Cheese cheese = new Cheese(optionRepository.findCheeseById(s.nextInt()));
    // 재료
    printIngredients();
    Ingredient ingredient = new Ingredient(optionRepository.findIngredientById(s.nextInt()));
    // 토스팅

    // 채소
    printVegetables();
    Vegetable vegetable = new Vegetable(optionRepository.findVegetableById(s.nextInt()));
    // 소스
    printSauces();
    Sauce sauce = new Sauce(optionRepository.findSauceById(s.nextInt()));

    return new Sandwich(sandwich, bread, cheese, ingredient, vegetable, sauce);
  }

  void printBreads() {
    Bread[] breads = optionRepository.getBreads();
    System.out.println("\n🥖 빵을 선택해주세요 ");
    System.out.println("-".repeat(30));

    for (Bread bread : breads) {
      printEachOption(bread);
    }
    System.out.println("-".repeat(30));
    System.out.print(">>> ");
  };

  void printCheeses() {
    Cheese[] cheeses = optionRepository.getCheeses();
    System.out.println("\n🧀 치즈를 선택해주세요 ");
    System.out.println("-".repeat(30));

    for (Cheese cheese : cheeses) {
      printEachOption(cheese);
    }
    System.out.println("-".repeat(30));
    System.out.print(">>> ");
  };

  void printIngredients() {
    Ingredient[] ingredients = optionRepository.getIngredients();
    System.out.println("\n🥓 재료를 선택해주세요 ");
    System.out.println("-".repeat(30));

    for (Ingredient ingredient : ingredients) {
      printEachOption(ingredient);
    }
    System.out.println("-".repeat(30));
    System.out.print(">>> ");
  };

  void printVegetables() {
    Vegetable[] vegetables = optionRepository.getVegetables();
    System.out.println("\n🥬 채소를 선택해주세요 ");
    System.out.println("-".repeat(30));

    for (Vegetable vegetable : vegetables) {
      printEachOption(vegetable);
    }
    System.out.println("-".repeat(30));
    System.out.print(">>> ");
  };

  void printSauces() {
    Sauce[] sauces = optionRepository.getSauces();
    System.out.println("\n🧂 소스를 선택해주세요 ");
    System.out.println("-".repeat(30));

    for (Sauce sauce : sauces) {
      printEachOption(sauce);
    }
    System.out.println("-".repeat(30));
    System.out.print(">>> ");
  };

  void printEachOption(option.Option option) {
    System.out.printf("(%02d) +%,4d ₩  %-15s\n", option.getId(), option.getExtraPrice(), option.getName());
  }
}
