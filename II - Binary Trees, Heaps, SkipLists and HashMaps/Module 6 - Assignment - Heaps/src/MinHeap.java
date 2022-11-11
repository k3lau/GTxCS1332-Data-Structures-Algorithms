import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

  /**
   * The initial capacity of the MinHeap.
   *
   * DO NOT MODIFY THIS VARIABLE!
   */
  public static final int INITIAL_CAPACITY = 13;

  /*
   * Do not add new instance variables or modify existing ones.
   */
  private T[] backingArray;
  private int size;

  /**
   * This is the constructor that constructs a new MinHeap.
   *
   * Recall that Java does not allow for regular generic array creation,
   * so instead we cast a Comparable[] to a T[] to get the generic typing.
   */
  public MinHeap() {
    // DO NOT MODIFY THIS METHOD!
    backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
  }

  /**
   * Adds an item to the heap. If the backing array is full (except for
   * index 0) and you're trying to add a new item, then double its capacity.
   *
   * Method should run in amortized O(log n) time.
   *
   * @param data The data to add.
   * @throws java.lang.IllegalArgumentException If the data is null.
   */
  public void add(T data) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    if (data == null) {
      throw new IllegalArgumentException("The data is null");
    }
    if (backingArray.length - 1 == size) {
      T[] newArray = (T[]) new Comparable[backingArray.length * 2];

      for (int i = 1; i <= backingArray.length - 1; i++) {
        newArray[i] = backingArray[i];
      }
      backingArray = newArray;
    }
    size += 1;
    backingArray[size] = data;
    upheap(size);
  }

  private void upheap(int index) {
    int parent = index / 2;
    if (parent >= 1) {
      if (backingArray[parent].compareTo(backingArray[index]) > 0) {
        T temp = backingArray[parent];
        backingArray[parent] = backingArray[index];
        backingArray[index] = temp;
        upheap(parent);
      }
    }
  }

  /**
   * Removes and returns the min item of the heap. As usual for array-backed
   * structures, be sure to null out spots as you remove. Do not decrease the
   * capacity of the backing array.
   *
   * Method should run in O(log n) time.
   *
   * @return The data that was removed.
   * @throws java.util.NoSuchElementException If the heap is empty.
   */
  public T remove() {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    if (size == 0) {
      throw new NoSuchElementException("The heap is empty");
    }
    T removedData = backingArray[1];
    backingArray[1] = backingArray[size];
    backingArray[size] = null;
    size -= 1;
    downheap(1);
    return removedData;
  }

  private void downheap(int index) {
    int leftChild = index * 2;
    int rightChild = index * 2 + 1;
    T temp = backingArray[index];
    if (leftChild <= size & rightChild <= size) {
      if (backingArray[index].compareTo(backingArray[leftChild]) > 0
          & backingArray[index].compareTo(backingArray[rightChild]) > 0) {
        if (backingArray[leftChild].compareTo(backingArray[rightChild]) > 0) {
          backingArray[index] = backingArray[rightChild];
          backingArray[rightChild] = temp;
          downheap(rightChild);
        } else {
          backingArray[index] = backingArray[leftChild];
          backingArray[leftChild] = temp;
          downheap(leftChild);
        }
      } else if (backingArray[index].compareTo(backingArray[leftChild]) > 0) {
        backingArray[index] = backingArray[leftChild];
        backingArray[leftChild] = temp;
        downheap(leftChild);
      } else if (backingArray[index].compareTo(backingArray[rightChild]) > 0) {
        backingArray[index] = backingArray[rightChild];
        backingArray[rightChild] = temp;
        downheap(rightChild);
      }
    } else if (leftChild <= size) {
      if (backingArray[index].compareTo(backingArray[leftChild]) > 0) {
        backingArray[index] = backingArray[leftChild];
        backingArray[leftChild] = temp;
        downheap(leftChild);
      }
    } else if (rightChild <= size) {
      if (backingArray[index].compareTo(backingArray[rightChild]) > 0) {
        backingArray[index] = backingArray[rightChild];
        backingArray[rightChild] = temp;
        downheap(rightChild);
      }
    }
  }

  /**
   * Returns the backing array of the heap.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return The backing array of the list
   */
  public T[] getBackingArray() {
    // DO NOT MODIFY THIS METHOD!
    return backingArray;
  }

  /**
   * Returns the size of the heap.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return The size of the list
   */
  public int size() {
    // DO NOT MODIFY THIS METHOD!
    return size;
  }
}