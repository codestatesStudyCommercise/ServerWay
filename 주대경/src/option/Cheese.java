package option;

public class Cheese extends Option {

  public Cheese(int id, String name, int extraPrice) {
    super(id, name, extraPrice);
    // TODO Auto-generated constructor stub
  }

  public Cheese(Cheese cheese) {
    super(cheese.getId(), cheese.getName(), cheese.getExtraPrice());
  }

}
