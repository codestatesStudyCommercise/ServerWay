package option;

public class Vegetable extends Option {

  public Vegetable(int id, String name, int extraPrice) {
    super(id, name, extraPrice);
    // TODO Auto-generated constructor stub
  }

  public Vegetable(Vegetable vegetable) {
    super(vegetable.getId(), vegetable.getName(), vegetable.getExtraPrice());
  }

}
