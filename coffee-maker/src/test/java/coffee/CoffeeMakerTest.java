package coffee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static coffee.CoffeeMaker.MAX_WATER_MACHINE_COUNT;
import static coffee.CoffeeMaker.MILK;
import static coffee.CoffeeMaker.SUGAR;
import static coffee.CoffeeType.BLACK;
import static coffee.CoffeeType.CAPPUCCINO;
import static coffee.CoffeeType.ESPRESSO;
import static coffee.CoffeeType.LATTE;
import static coffee.CoffeeType.MOCHA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class CoffeeMakerTest {

    private final List<String> contents = new ArrayList<String>();

    private final Pourable pourable = new Pourable() {
        public void pour(String stuff) {
            contents.add(stuff);
        }
    };

    private final CoffeeMaker coffeeMaker = new CoffeeMaker();

    @Test
    public void makesCappuccino() {
        coffeeMaker.makeCoffee(pourable, false, false, CAPPUCCINO);

        assertThat(contents, contains(CAPPUCCINO.name(), CoffeeMaker.WATER));
    }

    @Test
    public void makesBlack() {
        coffeeMaker.makeCoffee(pourable, false, false, BLACK);

        assertThat(contents, contains(BLACK.name(), CoffeeMaker.WATER));
    }

    @Test
    public void makesMocha() {
        coffeeMaker.makeCoffee(pourable, false, false, MOCHA);

        assertThat(contents, contains(MOCHA.name(), CoffeeMaker.WATER));
    }

    @Test
    public void makesLatte() {
        coffeeMaker.makeCoffee(pourable, false, false, LATTE);

        assertThat(contents, contains(LATTE.name(), CoffeeMaker.WATER));
    }

    @Test
    public void makesEspresso() {
        coffeeMaker.makeCoffee(pourable, false, false, ESPRESSO);

        assertThat(contents, contains(ESPRESSO.name(), CoffeeMaker.WATER));
    }

    @Test
    public void addsMilk() {
        coffeeMaker.makeCoffee(pourable, true, false, CAPPUCCINO);

        assertThat(contents, contains(CAPPUCCINO.name(), CoffeeMaker.WATER, MILK));
    }

    @Test
    public void addsSugar() {
        coffeeMaker.makeCoffee(pourable, false, true, CAPPUCCINO);

        assertThat(contents, contains(CAPPUCCINO.name(), CoffeeMaker.WATER, SUGAR));
    }

    @Test
    public void addsWaterEventually() {
        for (int i = 0; i < MAX_WATER_MACHINE_COUNT; i++) {
            coffeeMaker.makeCoffee(pourable, false, false, CAPPUCCINO);
        }
        contents.clear();

        coffeeMaker.makeCoffee(pourable, false, false, CAPPUCCINO);

        assertThat(contents, contains(CAPPUCCINO.name(), CoffeeMaker.WATER));
    }
}
