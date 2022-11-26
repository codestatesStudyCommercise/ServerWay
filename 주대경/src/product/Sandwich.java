package product;

import option.Bread;
import option.Cheese;
import option.Ingredient;
import option.Sauce;
import option.Vegetable;

public class Sandwich extends Product {
  boolean is30cm;
  Bread bread;
  Cheese cheese;
  Ingredient ingredient;
  Vegetable vegetable;
  Sauce sauce;

  public Sandwich(int id, String name, int price, int kcal) {
    super(id, name, price, kcal);
    // TODO Auto-generated constructor stub
  }

  public Sandwich(Sandwich sandwich, Bread bread, Cheese cheese, Ingredient ingredient, Vegetable vegetable,
      Sauce sauce) {
    super(sandwich.getId(), sandwich.getName(), sandwich.getPrice() + ingredient.getExtraPrice(), sandwich.getKcal());
    this.bread = bread;
    this.cheese = cheese;
    this.ingredient = ingredient;
    this.vegetable = vegetable;
    this.sauce = sauce;
  }

  public boolean isIs30cm() {
    return is30cm;
  }

  public void setIs30cm(boolean is30cm) {
    this.is30cm = is30cm;
    this.price = getPrice() + 4500;
  }

}
