package option;

public class Sauce extends Option {

  public Sauce(int id, String name, int extraPrice) {
    super(id, name, extraPrice);
    // TODO Auto-generated constructor stub
  }

  public Sauce(Sauce sauce) {
    super(sauce.getId(), sauce.getName(), sauce.getExtraPrice());
  }

}
