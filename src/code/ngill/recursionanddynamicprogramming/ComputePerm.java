package code.ngill.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class ComputePerm {

  public static void main(String[] args) {
    for(String perm : computePermutations("abc")) {
      System.out.println(perm);
    }
  }

  public static List<String> computePermutations(String word) {
    List<String> result = new ArrayList<String>();
    if(word.length() == 0) {
      result.add("");
      return result;
    }

    char first = word.charAt(0);
    List<String> perms = computePermutations(word.substring(1));

    for(String perm : perms) {
      for(int i = 0; i <= perm.length(); i++) {
        result.add(insertAtI(perm, first, i));
      }
    }
    return result;
  }

  private static String insertAtI(String word, char ch, int i) {
    return word.substring(0, i) + ch + word.substring(i);
  }

}
