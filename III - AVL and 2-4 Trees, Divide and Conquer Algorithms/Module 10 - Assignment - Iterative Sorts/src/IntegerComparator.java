import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

  public int compare(Integer a, Integer b) {
    return a.intValue() - b.intValue();
  }

  public boolean equals(Object obj) {
    return this.equals(obj);
  }

}
