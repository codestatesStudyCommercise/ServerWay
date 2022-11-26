package product;

public class Cookie extends Product {

  public Cookie(int id, String name, int price, int kcal) {
    super(id, name, price, kcal);
    // TODO Auto-generated constructor stub
  }

  public Cookie(Cookie cookie) {
    super(cookie.getId(), cookie.getName(), cookie.getPrice(), cookie.getKcal());
  }

}
