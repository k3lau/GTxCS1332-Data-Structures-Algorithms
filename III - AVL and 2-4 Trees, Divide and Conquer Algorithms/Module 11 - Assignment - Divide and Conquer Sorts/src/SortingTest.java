import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import java.util.Comparator;

import org.junit.Test;

public class SortingTest {
  @Test
  public void testMergeSort() {
    Integer[] test = { 3, 4, 7, 5, 2, 6, 1 };
    Comparator<Integer> comparator = Integer::compare;
    Sorting.mergeSort(test, comparator);
    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testMergeSortEven() {
    Integer[] test = { 3, 4, 7, 5, 2, 6, 1, 0 };
    Comparator<Integer> comparator = Integer::compare;
    Sorting.mergeSort(test, comparator);
    Integer[] expected = { 0, 1, 2, 3, 4, 5, 6, 7 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testMergeSortLarge() {
    Integer[] test = { 3, 4, 7, 5, 2, 6, 1, 0 };
    Comparator<Integer> comparator = Integer::compare;
    Sorting.mergeSort(test, comparator);
    Integer[] expected = { 0, 1, 2, 3, 4, 5, 6, 7 };

    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testLSDRadixSortSingle() {
    int[] test = { 355 };
    Sorting.lsdRadixSort(test);
    int[] expected = { 355 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testLSDRadixSort() {
    int[] test = { 355, 444, 766, 55, 24, 68, 1 };
    Sorting.lsdRadixSort(test);
    int[] expected = { 1, 24, 55, 68, 355, 444, 766 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testLSDRadixSortMaxNegative() {
    int[] test = { 355, 444, 766, 55, 24, 68, Integer.MIN_VALUE };
    Sorting.lsdRadixSort(test);
    int[] expected = { Integer.MIN_VALUE, 24, 55, 68, 355, 444, 766 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }
}
