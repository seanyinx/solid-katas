package coffee;

import static coffee.CoffeeType.BLACK;
import static coffee.CoffeeType.CAPPUCCINO;
import static coffee.CoffeeType.ESPRESSO;
import static coffee.CoffeeType.LATTE;
import static coffee.CoffeeType.MOCHA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class CoffeeMakerTest {

  static final int MAX_WATER_MACHINE_COUNT = 10;

  private final CoffeeMaker coffeeMaker = new CoffeeMaker();

  @Test
  public void makesCappuccino() {
    List<String> contents = coffeeMaker.makeCoffee(new Cooking_CAPPUCCINO(), new BoilingWater(), new ArrayList<>());
    assertThat(contents, contains(CAPPUCCINO.name(), "Water"));
  }

  @Test
  public void makesBlack() {
    List<String> contents = coffeeMaker.makeCoffee(new Cooking_BLACK(), new BoilingWater(), new ArrayList<>());
    assertThat(contents, contains(BLACK.name(), "Water"));
  }

  @Test
  public void makesMocha() {
    List<String> contents = coffeeMaker.makeCoffee(new Cooking_MOCHA(), new BoilingWater(), new ArrayList<>());
    assertThat(contents, contains(MOCHA.name(), "Water"));
  }

  @Test
  public void makesLatte() {
    List<String> contents = coffeeMaker.makeCoffee(new Cooking_LATTE(), new BoilingWater(), new ArrayList<>());
    assertThat(contents, contains(LATTE.name(), "Water"));
  }

  @Test
  public void makesEspresso() {
    List<String> contents = coffeeMaker.makeCoffee(new Cooking_ESPRESSO(), new BoilingWater(), new ArrayList<>());
    assertThat(contents, contains(ESPRESSO.name(), "Water"));
  }

  @Test
  public void makesCappuccinoWithMilk() {
    List<String> contents = coffeeMaker
        .makeCoffee(new Cooking_CAPPUCCINO(), new BoilingWater(), Lists.newArrayList(new AddMilk()));
    assertThat(contents, contains(CAPPUCCINO.name(), "Water", "Milk"));
  }

  @Test
  public void makesCappuccinoWithSugar() {
    List<String> contents = coffeeMaker
        .makeCoffee(new Cooking_CAPPUCCINO(), new BoilingWater(), Lists.newArrayList(new AddSugar()));
    assertThat(contents, contains(CAPPUCCINO.name(), "Water", "Sugar"));
  }

  @Test
  public void addsWaterEventually() {
    List<String> contents = new ArrayList<>();
    for (int i = 0; i < MAX_WATER_MACHINE_COUNT; i++) {
      contents.addAll(coffeeMaker.makeCoffee(new Cooking_CAPPUCCINO(), new BoilingWater(), new ArrayList<>()));
    }
    contents.clear();
    contents.addAll(coffeeMaker.makeCoffee(new Cooking_CAPPUCCINO(), new BoilingWater(), new ArrayList<>()));
    assertThat(contents, contains(CAPPUCCINO.name(), "Water"));
  }
}
