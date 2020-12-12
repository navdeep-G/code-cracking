package code.ngill.recursionanddynamicprogramming;

public class FillAll {

  public static void main(String[] args) {
    Color[][] image = {{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.RED, Color.RED, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.RED, Color.RED, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.RED, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE}};
    fillAll(image, 5, 4, image[5][4], Color.BLACK);

    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[i].length; j++) {
        System.out.print(image[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void fillAll(Color[][] image, int n, int m, Color color, Color newColor) {
    if (n < 0 || m < 0 || n >= image.length || m >= image[n].length) {
      return;
    }

    if (image[n][m] == color) {
      image[n][m] = newColor;
      fillAll(image, n - 1, m, color, newColor);
      fillAll(image, n, m + 1, color, newColor);
      fillAll(image, n + 1, m, color, newColor);
      fillAll(image, n, m - 1, color, newColor);
    }

  }

  private enum Color {
    WHITE, BLACK, RED, GREEN, BLUE;
  }

}
