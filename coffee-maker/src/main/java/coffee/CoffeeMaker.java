package coffee;

import java.util.List;

import com.google.common.collect.Lists;

public class CoffeeMaker {

  public List<String> makeCoffee(Cooking cook, DealWater dealWater, List<SpecialFlavour> flavours) {
    List<String> coffee = Lists.newArrayList(cook.cooking());
    coffee.add(dealWater.process());
    for (SpecialFlavour flavour : flavours) {
      coffee.add(flavour.process());
    }
    stirring();
    return coffee;
  }

  private void stirring() {
  }
}
