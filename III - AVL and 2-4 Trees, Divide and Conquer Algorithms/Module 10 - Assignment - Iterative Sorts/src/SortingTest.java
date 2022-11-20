import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import java.util.Comparator;

import org.junit.Test;

public class SortingTest {
  @Test
  public void testBubbleSort() {
    Integer[] test = { 3, 4, 1, 5, 2, 6, 7 };
    Comparator<Integer> comparator = Integer::compare;
    Sorting.bubbleSort(test, comparator);
    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testBubbleSortTwoElements() {
    Integer[] test = { 3, 4 };
    Comparator<Integer> comparator = Integer::compare;
    Sorting.bubbleSort(test, comparator);
    Integer[] expected = { 3, 4 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testBubbleSortAlmostSorted() {
    Integer[] test = { 5, 1, 2, 3, 4 };
    Comparator<Integer> comparator = Integer::compare;
    Sorting.bubbleSort(test, comparator);
    Integer[] expected = { 1, 2, 3, 4, 5 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testSelectionSort() {
    Integer[] test = { 3, 4, 1, 5, 2, 6, 7 };
    Comparator<Integer> comparator = Integer::compare;
    Sorting.selectionSort(test, comparator);
    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testSelectionSortTwoElement() {
    Integer[] test = { 3, 4 };
    Comparator<Integer> comparator = Integer::compare;
    Sorting.selectionSort(test, comparator);
    Integer[] expected = { 3, 4 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testInsertionSort() {
    Integer[] test = { 3, 4, 1, 5, 2, 6, 7 };
    Comparator<Integer> comparator = Integer::compare;
    Sorting.insertionSort(test, comparator);
    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }

  @Test
  public void testInsertionSortMinAtEnd() {
    Integer[] test = { 3, 4, 7, 5, 2, 6, 1 };
    Comparator<Integer> comparator = Integer::compare;
    Sorting.insertionSort(test, comparator);
    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7 };
    assertEquals(Arrays.toString(expected), Arrays.toString(test));
  }
}
