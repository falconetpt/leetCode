package exercises.two.pointer;

public class FlipAndInvert {
  public int[][] flipAndInvertImage(int[][] image) {
    final var result = new int[image.length][image.length];

    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[i].length; j++) {
        result[i][j] = image[i][image.length - 1 - j] ^ 1;
      }
    }

    return result;
  }
}
