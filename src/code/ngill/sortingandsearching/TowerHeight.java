package code.ngill.sortingandsearching;

import java.util.Arrays;
import java.util.Comparator;

public class TowerHeight {

  public static void main(String[] args) {
    Measurement[] guys = {new Measurement(65, 100), new Measurement(70, 150), new Measurement(56, 90),
        new Measurement(75, 190), new Measurement(60, 95), new Measurement(68, 110)};

    System.out.println(findTowerHeight(guys));

  }

  private static int findTowerHeight(Measurement[] guys) {
    if (guys == null || guys.length == 0) {
      return 0;
    }

    if (guys.length == 1) {
      return 1;
    }

    MeasurementComp measureComparator = new MeasurementComp();
    Arrays.sort(guys, measureComparator);

    int maxSeq = 1;
    int currentSeq = 1;
    for (int i = 1; i < guys.length; i++) {
      if (guys[i - 1].x >= guys[i].x || guys[i - 1].y >= guys[i].y) {
        if (maxSeq < currentSeq) {
          maxSeq = currentSeq;
        }
        currentSeq = 0;
      }
      currentSeq++;
    }

    if (maxSeq < currentSeq) {
      maxSeq = currentSeq;
    }

    return maxSeq;
  }

  private static class MeasurementComp implements Comparator<Measurement> {
    @Override
    public int compare(Measurement measurement, Measurement measurement2) {
      if (measurement.x < measurement2.x) {
        return -1;
      } else if (measurement.x > measurement2.x) {
        return 1;
      } else {
        if (measurement.y < measurement2.y) {
          return -1;
        } else if (measurement.y > measurement2.y) {
          return 1;
        }
      }
      return 0;
    }
  }

  private static class Measurement {
    public int x;
    public int y;

    public Measurement(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

}
