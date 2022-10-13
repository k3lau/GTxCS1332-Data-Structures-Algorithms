import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

  /*
   * Do not add new instance variables or modify existing ones.
   */
  private SinglyLinkedListNode<T> head;
  private SinglyLinkedListNode<T> tail;
  private int size;

  /*
   * Do not add a constructor.
   */

  /**
   * Adds the element to the front of the list.
   *
   * Method should run in O(1) time.
   *
   * @param data the data to add to the front of the list
   * @throws java.lang.IllegalArgumentException if data is null
   */
  public void addToFront(T data) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    if (data == null) {
      throw new IllegalArgumentException("Data must not be null");
    }
    if (size == 0) {
      // Add to empty list by pointing to head and tail
      SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
      this.head = newNode;
      this.tail = newNode;
    } else {
      // Add to front: Create new node with data
      // and the next pointer to the current head
      // Then set the head to the new node
      SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data, this.head);
      this.head = newNode;
    }
    size += 1;
  }

  /**
   * Adds the element to the back of the list.
   *
   * Method should run in O(1) time.
   *
   * @param data the data to add to the back of the list
   * @throws java.lang.IllegalArgumentException if data is null
   */
  public void addToBack(T data) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    if (data == null) {
      throw new IllegalArgumentException("Data must not be null");
    }
    if (size == 0) {
      // Add to empty list by pointing to head and tail
      SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
      this.head = newNode;
      this.tail = newNode;
    } else {
      // Add to back: Create new node with data
      // and the next pointer to null
      // Change the tail node's next pointer to the new node
      // Then set the tail to the new node
      SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
      this.tail.setNext(newNode);
      this.tail = newNode;
    }
    size += 1;
  }

  /**
   * Removes and returns the first data of the list.
   *
   * Method should run in O(1) time.
   *
   * @return the data formerly located at the front of the list
   * @throws java.util.NoSuchElementException if the list is empty
   */
  public T removeFromFront() {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    if (size == 0) {
      throw new NoSuchElementException("List is empty");
    } else {
      T result = this.head.getData();
      if (size == 1) {
        // Set both head and tail to null

        this.head = null;
        this.tail = null;
      } else {
        // Set head to next node
        this.head = this.head.getNext();
      }
      size -= 1;
      return result;
    }
  }

  /**
   * Removes and returns the last data of the list.
   *
   * Method should run in O(n) time.
   *
   * @return the data formerly located at the back of the list
   * @throws java.util.NoSuchElementException if the list is empty
   */
  public T removeFromBack() {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    if (size == 0) {
      throw new NoSuchElementException("List is empty");
    } else {
      T result = this.tail.getData();
      if (size == 1) {
        // Set both head and tail to null
        this.head = null;
        this.tail = null;
      } else {
        // Traverse to the second last node and set its next to null
        // Change tail to the second last node
        SinglyLinkedListNode<T> prevTail = this.head;
        while (prevTail.getNext() != null && prevTail.getNext() != this.tail) {
          prevTail = prevTail.getNext();
        }
        prevTail.setNext(null);
        this.tail = prevTail;
      }
      size -= 1;
      return result;
    }
  }

  /**
   * Returns the head node of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the node at the head of the list
   */
  public SinglyLinkedListNode<T> getHead() {
    // DO NOT MODIFY THIS METHOD!
    return head;
  }

  /**
   * Returns the tail node of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the node at the tail of the list
   */
  public SinglyLinkedListNode<T> getTail() {
    // DO NOT MODIFY THIS METHOD!
    return tail;
  }

  /**
   * Returns the size of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the size of the list
   */
  public int size() {
    // DO NOT MODIFY THIS METHOD!
    return size;
  }

  public void printString() {
    SinglyLinkedListNode<T> curr = head;
    String result = "";
    if (size == 0) {
      System.out.println("");
    }

    while (curr != null) {
      if (result.length() != 0) {
        result += " ";
      }
      ;
      result += curr.getData().toString();
      curr = curr.getNext();
    }
    System.out.println(result);
    if (this.size != 0) {
      System.out.println("Head: " + this.head.getData());
      System.out.println("Tail: " + this.tail.getData());
      System.out.println("Size: " + this.size);
    } else {
      System.out.println("Size: " + this.size);
    }
  }
}
