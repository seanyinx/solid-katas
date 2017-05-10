package coffee;

import static coffee.CoffeeType.BLACK;
import static coffee.CoffeeType.CAPPUCCINO;
import static coffee.CoffeeType.ESPRESSO;
import static coffee.CoffeeType.LATTE;
import static coffee.CoffeeType.MOCHA;

public class CoffeeMaker {
    static final int MAX_WATER_MACHINE_COUNT = 10;
    static final String WATER = "Water";
    static final String MILK = "Milk";
    static final String SUGAR = "Sugar";

    public void makeCoffee(
        Pourable pourable,
        boolean isMilkCoffee,
        boolean isSweetTooth,
        CoffeeType type
    ) {
        if (type == CAPPUCCINO) {
            pouringCappuccinoPowder(pourable);
        } else if (type == BLACK) {
            pouringBlackPowder(pourable);
        } else if (type == MOCHA) {
            pouringMochaPowder(pourable);
        } else if (type == LATTE) {
            pouringLattePowder(pourable);
        } else if (type == ESPRESSO) {
            pouringEspressoPowder(pourable);
        }

        boolean hasBoilingWater = false;
        while (!hasBoilingWater) {
            for (int i = 0; i < MAX_WATER_MACHINE_COUNT; i++) {
                if (isBoiling(i)) {
                    hasBoilingWater = true;
                    break;
                }
            }
            dawdling();
        }

        pouringBoilingWater(pourable);
        if (isMilkCoffee) {
            pouringMilk(pourable);
        }
        if (isSweetTooth) {
            addSugar(pourable);
        }
        stirring();
    }

    private void dawdling() {

    }

    private boolean isBoiling(int indexOfBoiler) {
        return true;
    }

    private void stirring() {

    }

    private void addSugar(Pourable pourable) {
        pourable.pour(SUGAR);
    }

    private void pouringMilk(Pourable pourable) {
        pourable.pour(MILK);
    }

    private void pouringBoilingWater(Pourable pourable) {
        pourable.pour(WATER);
    }

    private void pouringBlackPowder(Pourable pourable) {
        pourable.pour(BLACK.name());
    }

    private void pouringMochaPowder(Pourable pourable) {
        pourable.pour(MOCHA.name());
    }

    private void pouringLattePowder(Pourable pourable) {
        pourable.pour(LATTE.name());
    }

    private void pouringEspressoPowder(Pourable pourable) {
        pourable.pour(ESPRESSO.name());
    }

    private void pouringCappuccinoPowder(Pourable pourable) {
        pourable.pour(CAPPUCCINO.name());
    }
}
