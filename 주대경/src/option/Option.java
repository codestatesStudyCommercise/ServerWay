package option;

public class Option {
  int id;
  String name;
  int extraPrice;

  public Option(int id, String name, int extraPrice) {
    this.id = id;
    this.name = name;
    this.extraPrice = extraPrice;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getExtraPrice() {
    return extraPrice;
  }

}
