import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

  /**
   * Implement merge sort.
   *
   * It should be:
   * out-of-place
   * stable
   * not adaptive
   *
   * Have a worst case running time of: O(n log n)
   * And a best case running time of: O(n log n)
   *
   * You can create more arrays to run merge sort, but at the end, everything
   * should be merged back into the original T[] which was passed in.
   *
   * When splitting the array, if there is an odd number of elements, put the
   * extra data on the right side.
   *
   * Hint: You may need to create a helper method that merges two arrays
   * back into the original T[] array. If two data are equal when merging,
   * think about which subarray you should pull from first.
   *
   * You may assume that the passed in array and comparator are both valid
   * and will not be null.
   *
   * @param <T>        Data type to sort.
   * @param arr        The array to be sorted.
   * @param comparator The Comparator used to compare the data in arr.
   */
  public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    recursiveMergeSort(arr, 0, arr.length - 1, comparator);
  }

  private static <T> void recursiveMergeSort(T[] arr, int leftIndex, int rightIndex, Comparator<T> comparator) {
    if (rightIndex - leftIndex + 1 == 1) {
      return;
    }
    int splitIndex = (rightIndex - leftIndex - 1) / 2 + leftIndex;
    recursiveMergeSort(arr, leftIndex, splitIndex, comparator);
    recursiveMergeSort(arr, splitIndex + 1, rightIndex, comparator);
    merge(arr, leftIndex, splitIndex, rightIndex, comparator);
  }

  @SuppressWarnings("unchecked")
  private static <T> void merge(T[] arr, int leftIndex, int splitIndex, int rightIndex, Comparator<T> comparator) {
    Object[] newArr = new Object[rightIndex - leftIndex + 1];
    int i = leftIndex;
    int j = splitIndex + 1;
    int mainIndex = 0;
    while (i <= splitIndex && j <= rightIndex) {
      if (comparator.compare(arr[i], arr[j]) > 0) {
        newArr[mainIndex] = arr[j];
        j++;
      } else {
        newArr[mainIndex] = arr[i];
        i++;
      }
      mainIndex++;
    }
    while (i <= splitIndex) {
      newArr[mainIndex] = arr[i];
      mainIndex++;
      i++;
    }
    while (j <= rightIndex) {
      newArr[mainIndex] = arr[j];
      mainIndex++;
      j++;
    }
    mainIndex = leftIndex;
    for (int x = 0; x < newArr.length; x++) {
      arr[mainIndex] = (T) newArr[x];
      mainIndex++;
    }
  }

  /**
   * Implement LSD (least significant digit) radix sort.
   *
   * It should be:
   * out-of-place
   * stable
   * not adaptive
   *
   * Have a worst case running time of: O(kn)
   * And a best case running time of: O(kn)
   *
   * Feel free to make an initial O(n) passthrough of the array to
   * determine k, the number of iterations you need.
   *
   * At no point should you find yourself needing a way to exponentiate a
   * number; any such method would be non-O(1). Think about how how you can
   * get each power of BASE naturally and efficiently as the algorithm
   * progresses through each digit.
   *
   * You may use an ArrayList or LinkedList if you wish, but it should only
   * be used inside radix sort and any radix sort helpers. Do NOT use these
   * classes with merge sort. However, be sure the List implementation you
   * choose allows for stability while being as efficient as possible.
   *
   * Do NOT use anything from the Math class except Math.abs().
   *
   * You may assume that the passed in array is valid and will not be null.
   *
   * @param arr The array to be sorted.
   */
  @SuppressWarnings("unchecked")
  public static void lsdRadixSort(int[] arr) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    int iteration = 1;
    int x;
    for (int i = 0; i < arr.length; i++) {
      x = findDigit(arr[i]);
      if (x > iteration) {
        iteration = x;
      }
    }
    Queue<Integer>[] bucket = (Queue<Integer>[]) new Queue[19];
    for (int k = 0; k < bucket.length; k++) {
      bucket[k] = new LinkedList<Integer>();
    }
    int[] POWERS_OF_10 = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
    for (int i = 1; i <= iteration; i++) {
      int rightBase = POWERS_OF_10[i - 1];
      for (int j = 0; j < arr.length; j++) {
        int bucketIndex = (arr[j] / rightBase) % 10 + 9;
        bucket[bucketIndex].add(arr[j]);
      }
      int index = 0;
      for (int k = 0; k < bucket.length; k++) {
        while (bucket[k].peek() != null) {
          arr[index] = bucket[k].remove();
          index++;
        }
      }
    }
  }

  private static int findDigit(int num) {
    int digit = 1;
    // Use negative to cover the edge case of abs(max negative integer)
    // is greater than max positive integer
    num = -(Math.abs(num));
    num = num / 10;

    while (num < 0) {
      digit++;
      num = num / 10;
    }
    return digit;
  }
}
