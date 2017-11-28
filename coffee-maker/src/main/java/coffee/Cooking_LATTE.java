package coffee;

public class Cooking_LATTE implements Cooking {
  @Override
  public String cooking() {
    return CoffeeType.LATTE.toString();
  }
}
