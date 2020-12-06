package code.ngill.recursionanddynamicprogramming;

public class TraverseGrid {

  public static void main(String[] args) {
    boolean[][] offLimits = {{false, false, false}, {false, true,false}, {false, false,false}};
    System.out.print(traverseGrid(3,3, offLimits));
  }

  public static int traverseGrid(int n, int m, boolean[][] offLimits) {
    if(n == 1 && m == 1) {
      return 1;
    }

    if(offLimits[n-1][m-1]) {
      return 0;
    }

    int down = 0;
    int right = 0;
    if(m > 1) {
      right += traverseGrid(n, m-1, offLimits);
    }
    if(n > 1) {
      down += traverseGrid(n-1, m, offLimits);
    }

    return down+right;
  }

}
