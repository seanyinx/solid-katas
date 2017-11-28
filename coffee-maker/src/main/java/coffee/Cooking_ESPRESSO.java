package coffee;

public class Cooking_ESPRESSO implements Cooking {
  @Override
  public String cooking() {
    return CoffeeType.ESPRESSO.toString();
  }
}
