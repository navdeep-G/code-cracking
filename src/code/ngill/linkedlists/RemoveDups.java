package code.ngill.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

  public static void main(String... args) {
    Node<Integer> list = new Node<Integer>(1);
    list.appendToTail(1);
    list.appendToTail(3);
    list.appendToTail(2);
    list.appendToTail(1);
    list.appendToTail(2);
    removeDuplicatesWithoutBuffer(list);
    list.printList();
  }

  private static <T> void removeDuplicatesBuffer(Node<T> list) {
    if (list == null) {
      throw new IllegalArgumentException();
    }

    Set<T> unique = new HashSet<T>();
    unique.add(list.getData());

    while (list.getNext() != null) {
      Node<T> current = list;
      while (unique.contains(current.getNext().getData())) {
        current = current.getNext();
      }
      unique.add(current.getNext().getData());
      list.setNext(current.getNext());
      list = list.getNext();
    }
  }

  private static <T> void removeDuplicatesWithoutBuffer(Node<T> list) {
    Node<T> runner = list.getNext();

    while (runner != null) {
      Node<T> checker = list;

      if (checker.getData().equals(runner.getData())) {
        list.setData(checker.getNext().getData());
        list.setNext(checker.getNext().getNext());
      } else {
        while (checker.getNext() != runner) {
          if (checker.getNext().getData().equals(runner.getData())) {
            checker.setNext(checker.getNext().getNext());
            break;
          }
          checker = checker.getNext();
        }
      }

      runner = runner.getNext();
    }

  }

}