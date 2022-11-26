package repository;

import product.Cookie;
import product.Drink;
import product.Product;
import product.Sandwich;

public class ProductRepository {
    private Product[] products = {
            new Sandwich(1, "에그마요", 4900, 416),
            new Sandwich(2, "이탈리안 BMT", 6100, 388),
            new Sandwich(3, "BLT", 6000, 300),
            new Sandwich(4, "햄", 5200, 262),
            new Sandwich(5, "참치", 5200, 316),
            new Cookie(101, "초코칩", 1300, 228),
            new Cookie(102, "더블초코칩", 1300, 212),
            new Cookie(103, "오트밀 레이즌", 1300, 200),
            new Cookie(104, "라즈베리 치즈케익", 1300, 204),
            new Cookie(105, "화이트 초코 마카다미아", 1300, 245),
            new Drink(201, "코카콜라(355ml)", 2000, 0),
            new Drink(202, "스프라이트(355ml)", 2000, 0),
            new Drink(203, "닥터페퍼(355ml)", 2000, 0),
            new Drink(204, "코카콜라 제로(355ml)", 2000, 0),
            new Drink(205, "씨그램 레몬(350ml)", 2000, 0),
            new Drink(206, "미닛메이드 오렌지(350ml)", 2800, 0),
            new Drink(207, "토레타(500ml)", 2200, 0),
            new Drink(208, "물(100ml)", 1000, 0),
    };

    public ProductRepository() {
        for (Product product : products) {
            if (product instanceof Sandwich)
                sandwichsLengh++;
            if (product instanceof Cookie)
                cookiesLengh++;
            if (product instanceof Drink)
                drinksLengh++;
        }
    }

    private int sandwichsLengh = 0;
    private int cookiesLengh = 0;
    private int drinksLengh = 0;

    public Product[] getProducts() {
        return products;
    }

    public int getSandwichsLengh() {
        return sandwichsLengh;
    }

    public int getCookiesLengh() {
        return cookiesLengh;
    }

    public int getDrinksLengh() {
        return drinksLengh;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id)
                return product;
        }
        return null;
    }
}