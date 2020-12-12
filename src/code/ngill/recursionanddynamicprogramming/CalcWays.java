package code.ngill.recursionanddynamicprogramming;

public class CalcWays {

  public static void main(String[] args) {
    System.out.println(calculateWays(50, 3));
  }

  // 1*25+ways(n-25, onlysmaller)
  // 2*25+ways(n-50, onlysmaller)
  // ... until n >= 25
  // n*25+ways(n-n*25, onlysmaller)
  // repeat for 10, 5 and 1

  private static int[] denoms = {1, 5, 10, 25};

  private static int calculateWays(int sum, int n) {
    if(n == 0) {
      return 1;
    }

    int result = 0;

    for(int i = 0; i * denoms[n] <= sum; i++) {
      result += calculateWays(sum - i*denoms[n], n-1);
    }

    return result;
  }

}
