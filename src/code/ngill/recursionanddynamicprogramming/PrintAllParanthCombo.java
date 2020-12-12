package code.ngill.recursionanddynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class PrintAllParanthCombo {

  public static void main(String[] args) {
    for(String word : printAllParenthesisCombinations(1)) {
      System.out.println(word);
    }
  }

  private static Set<String> printAllParenthesisCombinations(int n) {
    if(0 == n) {
      throw new IllegalArgumentException();
    }

    Set<String> result = new HashSet<String>();
    if(1 == n) {
      result.add("()");
      return result;
    }


    Set<String> subproblems = printAllParenthesisCombinations(n-1);
    for(String res : subproblems) {
      result.add("()"+res);
      result.add(insertInsideFirst(res));
    }

    return result;
  }

  private static String insertInsideFirst(String word) {
    int i = 0;
    while(word.toCharArray()[i] != ')') {
      i++;
    }
    return word.substring(0,i)+"()"+word.substring(i);
  }

  private static void printAll(int n) {
    char[] str = new char[2*n];
    printAll(n,n,str,0);
  }

  // from the book - less space complex than mine ;(
  private static void printAll(int l, int r, char[] str, int count) {
    if(l < 0 || r < l) {
      throw new IllegalStateException();
    }

    if(l == 0 && r == 0) {
      System.out.println(str);
    } else {
      if(l > 0) {
        str[count] = '(';
        printAll(l-1, r, str, count + 1);
      }

      if(r > l) {
        str[count] = ')';
        printAll(l, r-1, str, count + 1);
      }
    }

  }
}
