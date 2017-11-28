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
    return hasBoilingWater;
  }

  private boolean isBoiling(int indexOfBoiler) {
    return true;
  }

  private void dawdling() {
  }
}
