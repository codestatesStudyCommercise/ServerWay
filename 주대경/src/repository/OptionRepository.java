package repository;

import option.Bread;
import option.Cheese;
import option.Ingredient;
import option.Sauce;
import option.Vegetable;

public class OptionRepository {
  private Bread[] breads = {
      new Bread(1, "화이트", 0),
      new Bread(2, "파마산 오레가노", 0),
      new Bread(3, "위트", 0),
      new Bread(4, "하티", 0),
      new Bread(5, "플랫브래드", 0),
  };

  private Cheese[] cheeses = {
      new Cheese(1, "아메리카치즈", 0),
      new Cheese(2, "슈레드치즈", 0),
      new Cheese(3, "모짜렐라치즈", 0),
      new Cheese(4, "치즈 제외", 0),
  };

  private Ingredient[] ingredients = {
      new Ingredient(1, "재료 추가 없음", 0),
      new Ingredient(2, "미트 추가(동일메뉴)", 2400),
      new Ingredient(3, "에그마요 추가", 1900),
      new Ingredient(4, "페퍼로닌 추가", 1100),
      new Ingredient(5, "베이컨 추가", 1200),
      new Ingredient(6, "아보카도 추가", 1500),
      new Ingredient(7, "오블렛 추가", 1500),
      new Ingredient(8, "치즈 추가(동일치즈)", 1100),
  };

  private Vegetable[] vegetables = {
      new Vegetable(1, "양상추 제외", 0),
      new Vegetable(2, "토마토 제외", 0),
      new Vegetable(3, "오이 제외", 0),
      new Vegetable(4, "피망 제외", 0),
      new Vegetable(5, "양파 제외", 0),
      new Vegetable(6, "피클 제외", 0),
      new Vegetable(7, "올리브 제외", 0),
      new Vegetable(8, "할라피뇨 제외", 0),
  };

  private Sauce[] sauces = {
      new Sauce(1, "추천 소스", 0),
      new Sauce(2, "소스 넣지 않음", 0),
      new Sauce(3, "머스타드", 0),
      new Sauce(4, "레드와인식초", 0),
      new Sauce(5, "스윗 어니언", 0),
      new Sauce(6, "허니머스타드", 0),
      new Sauce(7, "스윗 칠리", 0),
      new Sauce(8, "스모크 바베큐", 0),
      new Sauce(9, "랜치 드레싱", 0),
      new Sauce(10, "마요네즈", 0),
      new Sauce(11, "핫칠리", 0),
      new Sauce(12, "사우스웨스트치폴레", 0),
      new Sauce(13, "홀스레디쉬", 0),
      new Sauce(14, "올리브오일", 0),
      new Sauce(15, "소금", 0),
      new Sauce(16, "후추", 0),
  };

  public Bread[] getBreads() {
    return breads;
  }

  public Cheese[] getCheeses() {
    return cheeses;
  }

  public Ingredient[] getIngredients() {
    return ingredients;
  }

  public Vegetable[] getVegetables() {
    return vegetables;
  }

  public Sauce[] getSauces() {
    return sauces;
  }

  public Bread findBreadById(int id) {
    for (Bread bread : breads) {
      if (bread.getId() == id)
        return bread;
    }
    return null;
  }

  public Cheese findCheeseById(int id) {
    for (Cheese cheese : cheeses) {
      if (cheese.getId() == id)
        return cheese;
    }
    return null;
  }

  public Ingredient findIngredientById(int id) {
    for (Ingredient ingredient : ingredients) {
      if (ingredient.getId() == id)
        return ingredient;
    }
    return null;
  }

  public Vegetable findVegetableById(int id) {
    for (Vegetable vegetable : vegetables) {
      if (vegetable.getId() == id)
        return vegetable;
    }
    return null;
  }

  public Sauce findSauceById(int id) {
    for (Sauce sauce : sauces) {
      if (sauce.getId() == id)
        return sauce;
    }
    return null;
  }
}
