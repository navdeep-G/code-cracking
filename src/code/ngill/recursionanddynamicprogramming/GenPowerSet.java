package code.ngill.recursionanddynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class GenPowerSet {

  public static void main(String[] args) {
    Set set = new HashSet<Integer>();
    set.add(1);
    set.add(2);
    set.add(3);
    Set<Set<Integer>> result =generatePowerSet(set);
    for(Set<Integer> res : result) {
      System.out.println(res);
    }
  }

  public static <T> Set<Set<T>> generatePowerSet(Set<T> set) {
    if(set.isEmpty()) {
      Set<Set<T>> baseCase = new HashSet<Set<T>>();
      baseCase.add(new HashSet<T>());
      return baseCase;
    }

    Set<Set<T>> result = new HashSet<Set<T>>();

    for(T element : set) {
      Set<T> smaller = new HashSet<T>(set);
      smaller.remove(element);
      for(Set<T> res : generatePowerSet(smaller)) {
        result.add(res);
      }
    }
    result.add(set);
    return result;
  }

}
