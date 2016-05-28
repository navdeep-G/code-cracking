package code.ngill.sortingandsearching;

public class FindWord {

  public static void main(String[] args) {
    String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "enough"};
    System.out.println(findWord(words, "at"));
  }

  public static int findWord(String[] values, String value) {
    int lower = 0;
    int upper = values.length - 1;

    while (lower <= upper) {
      while (lower <= upper && values[upper].isEmpty()) {
        upper--;
      }

      int middle = (upper + lower) / 2;

      if (values[middle].equals(value)) {
        return middle;
      }

      int firstNonEmpty = searchNonEmpty(values, middle, upper);

      if (firstNonEmpty == -1) {
        upper = middle - 1;
      } else {
        if (values[firstNonEmpty].equals(value)) {
          return firstNonEmpty;
        }

        if (values[firstNonEmpty].compareTo(value) < 0) {
          lower = firstNonEmpty + 1;
        } else {
          upper = firstNonEmpty - 1;
        }
      }
    }
    return -1;
  }

  private static int searchNonEmpty(String[] values, int start, int end) {
    for (int i = start; i <= end; i++) {
      if (!values[i].isEmpty()) {
        return i;
      }
    }
    return -1;
  }
}
