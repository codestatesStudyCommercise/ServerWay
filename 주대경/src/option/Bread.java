package option;

public class Bread extends Option {
  public Bread(int id, String name, int extraPrice) {
    super(id, name, extraPrice);
    // TODO Auto-generated constructor stub
  }

  public Bread(Bread bread) {
    super(bread.getId(), bread.getName(), bread.getExtraPrice());
  }

  Boolean isRoasting;

  public Boolean getIsRoasting() {
    return isRoasting;
  }

  public void setIsRoasting(Boolean isRoasting) {
    this.isRoasting = isRoasting;
  }
}
