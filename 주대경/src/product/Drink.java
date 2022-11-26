package product;

public class Drink extends Product {
  boolean hasStraw;

  public Drink(int id, String name, int price, int kcal) {
    super(id, name, price, kcal);
    // TODO Auto-generated constructor stub
  }

  public Drink(Drink drink) {
    super(drink.getId(), drink.getName(), drink.getPrice(), drink.getKcal());
  }

  public boolean isHasStraw() {
    return hasStraw;
  }

  public void setHasStraw(boolean hasStraw) {
    this.hasStraw = hasStraw;
  }

}
