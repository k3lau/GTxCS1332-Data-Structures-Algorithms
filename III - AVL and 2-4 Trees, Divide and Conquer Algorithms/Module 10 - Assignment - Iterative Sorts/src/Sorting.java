import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

  /**
   * Implement bubble sort.
   *
   * It should be:
   * in-place
   * stable
   * adaptive
   *
   * Have a worst case running time of: O(n^2)
   * And a best case running time of: O(n)
   *
   * NOTE: You should implement bubble sort with the last swap optimization.
   *
   * You may assume that the passed in array and comparator
   * are both valid and will never be null.
   *
   * @param <T>        Data type to sort.
   * @param arr        The array that must be sorted after the method runs.
   * @param comparator The Comparator used to compare the data in arr.
   */
  public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    int stopIndex = arr.length - 1;
    int loopIndex;
    int lastSwapIndex;
    while (stopIndex != 0) {
      loopIndex = 0;
      lastSwapIndex = 0;
      while (loopIndex < stopIndex) {
        int compare = comparator.compare(arr[loopIndex], arr[loopIndex + 1]);
        if (compare > 0) {
          T temp = arr[loopIndex];
          arr[loopIndex] = arr[loopIndex + 1];
          arr[loopIndex + 1] = temp;
          lastSwapIndex = loopIndex;
        }
        loopIndex++;
      }
      stopIndex = lastSwapIndex;
    }
  }

  /**
   * Implement selection sort.
   *
   * It should be:
   * in-place
   * unstable
   * not adaptive
   *
   * Have a worst case running time of: O(n^2)
   * And a best case running time of: O(n^2)
   *
   * You may assume that the passed in array and comparator
   * are both valid and will never be null.
   *
   * @param <T>        Data type to sort.
   * @param arr        The array that must be sorted after the method runs.
   * @param comparator The Comparator used to compare the data in arr.
   */
  public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    int maxIndex = 0;
    for (int outsideLoop = arr.length - 1; outsideLoop >= 0; outsideLoop--) {
      maxIndex = 0;
      for (int insideLoop = 0; insideLoop <= outsideLoop; insideLoop++) {
        if (maxIndex != insideLoop) {
          int compare = comparator.compare(arr[maxIndex], arr[insideLoop]);
          if (compare < 0) {
            maxIndex = insideLoop;
          }
        }
      }
      T temp = arr[outsideLoop];
      arr[outsideLoop] = arr[maxIndex];
      arr[maxIndex] = temp;
    }
  }

  /**
   * Implement insertion sort.
   *
   * It should be:
   * in-place
   * stable
   * adaptive
   *
   * Have a worst case running time of: O(n^2)
   * And a best case running time of: O(n)
   *
   * You may assume that the passed in array and comparator
   * are both valid and will never be null.
   *
   * @param <T>        Data type to sort.
   * @param arr        The array that must be sorted after the method runs.
   * @param comparator The Comparator used to compare the data in arr.
   */
  public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    int mainIndex = 1;
    int insideLoop = 0;

    while (mainIndex <= arr.length - 1) {
      insideLoop = mainIndex;
      while (insideLoop >= 1 && comparator.compare(arr[insideLoop], arr[insideLoop - 1]) < 0) {
        T temp = arr[insideLoop];
        arr[insideLoop] = arr[insideLoop - 1];
        arr[insideLoop - 1] = temp;
        insideLoop--;
      }
      mainIndex++;
    }
  }
}