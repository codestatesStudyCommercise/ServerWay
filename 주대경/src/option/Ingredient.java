package option;

public class Ingredient extends Option {

  public Ingredient(int id, String name, int extraPrice) {
    super(id, name, extraPrice);
    // TODO Auto-generated constructor stub
  }

  public Ingredient(Ingredient ingredient) {
    super(ingredient.getId(), ingredient.getName(), ingredient.getExtraPrice());
  }

}
