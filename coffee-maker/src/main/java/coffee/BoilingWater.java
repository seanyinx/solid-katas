package coffee;

import java.util.concurrent.CountDownLatch;

public class BoilingWater implements DealWater {
  static final int MAX_WATER_MACHINE_COUNT = 10;

  @Override
  public String process() {
    final boolean[] hasBoilingWater = {false};
    final CountDownLatch count = new CountDownLatch(1);
    Thread boilingWater = new Thread(() -> {
      hasBoilingWater[0] = boilingWalter();
      count.countDown();
    });
    boilingWater.start();
    try {
      count.await();
    } catch (InterruptedException e) {
    }

    if (hasBoilingWater[0]) {
      return "Water";
    } else {
      return "";
    }
  }

  private boolean boilingWalter() {
    int leftCount = MAX_WATER_MACHINE_COUNT;
    while (leftCount > 0) {
      if (isBoiling(MAX_WATER_MACHINE_COUNT - leftCount)) {
        break;
      } else {
        leftCount--;
      }

      dawdling();
    }
    return leftCount > 0;
  }

  private boolean isBoiling(int indexOfBoiler) {
    return true;
  }

  private void dawdling() {
  }
}
