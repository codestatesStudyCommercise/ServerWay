package product;

public class SandwichSet extends Product {
  Sandwich sandwich;
  Cookie cookie;
  Drink drink;

  public SandwichSet(Sandwich sandwich, Cookie cookie, Drink drink) {
    super(sandwich.getName() + " 세트", sandwich.getPrice() + 2600);
    this.sandwich = sandwich;
    this.cookie = cookie;
    this.drink = drink;
  }

  public SandwichSet(SandwichSet sandwichSet) {
    super(sandwichSet.getName(), sandwichSet.getPrice());
  }
}
