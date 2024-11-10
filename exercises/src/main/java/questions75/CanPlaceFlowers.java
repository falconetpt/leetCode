package questions75;

public class CanPlaceFlowers {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    var count = 0;

    for (int i = 0; i < flowerbed.length; i++) {
      if (getValue(flowerbed, i -1) == 0
          && getValue(flowerbed, i + 1) == 0
          && getValue(flowerbed, i) == 0) {
        count++;
        flowerbed[i] = 1;
      }

      if (count >= n) return true;
    }

    return false;
  }

  private int getValue(int[] flowerbed, int i) {
    try {
      return flowerbed[i];
    } catch (ArrayIndexOutOfBoundsException e) {
      return 0;
    }
  }
}
