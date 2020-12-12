package code.ngill.recursionanddynamicprogramming;

public class RowIsEligible {

  public static void main(String[] args) {
    System.out.println(placeQueens(0));
  }

  private static int[] columns = new int[8];

  private static int placeQueens(int row) {
    if(8 == row) {
      return 1;
    }

    int result = 0;

    for(int i = 0; i < 8; i++) {
      columns[row] = i;
      if(rowIsEligible(row)) {
        result += placeQueens(row+1);
      }
    }

    return result;
  }

  private static boolean rowIsEligible(int row) {
    for(int i = 0; i < row; i++) {
      int diff = Math.abs(columns[i] - columns[row]);
      if(diff == 0 || diff == row - i) return false;
    }

    return true;
  }

}
