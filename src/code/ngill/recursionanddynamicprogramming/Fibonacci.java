package code.ngill.recursionanddynamicprogramming;

public class Fibonacci {

  public static void main(String[] args) {
    System.out.println(computeNthFibonacci(5));
    System.out.println(computeNthFibonacci(9));
    // 1 1 2 3 5 8 13 21 34 55 ...
  }

  private static int computeNthFibonacci(int n) {
    if(n == 1 || n == 2) {
      return 1;
    }

    return computeNthFibonacci(n - 1) + computeNthFibonacci(n - 2);
  }

}
