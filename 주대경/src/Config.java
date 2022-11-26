import discount.Discount;
import discount.condition.DiscountCondition;
import discount.condition.KidDiscountCondition;
import discount.condition.LaunchDiscountCondition;
import discount.policy.AmountDiscountPolicy;
import discount.policy.RateDiscountPolicy;
import repository.OptionRepository;
import repository.ProductRepository;

public class Config {
  private ProductRepository productRepository = new ProductRepository();
  private OptionRepository optionRepository = new OptionRepository();
  private Menu menu = new Menu(productRepository.getProducts());
  private Cart cart = new Cart(productRepository, menu, optionRepository);
  private Discount discount = new Discount(new DiscountCondition[] {
      new LaunchDiscountCondition(new RateDiscountPolicy(20)),
      new KidDiscountCondition(new AmountDiscountPolicy(1500))
  });
  private Order order = new Order(cart, discount);

  ProductRepository getProductRepository() {
    return this.productRepository;
  }

  Menu getMenu() {
    return this.menu;
  }

  Cart getCart() {
    return this.cart;
  }

  Discount getDiscount() {
    return this.discount;
  }

  Order getOrder() {
    return this.order;
  }
}
