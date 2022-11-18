import java.util.NoSuchElementException;

/**
 * Your implementation of the AVL tree rotations.
 */
public class AVL<T extends Comparable<? super T>> {
  /*
   * Do not add new instance variables or modify existing ones.
   */
  private AVLNode<T> root;
  private int size;

  /*
   * Do not add a constructor.
   */

  /**
   * Adds the element to the tree.
   *
   * Start by adding it as a leaf like in a regular BST and then rotate the
   * tree as necessary.
   *
   * If the data is already in the tree, then nothing should be done (the
   * duplicate shouldn't get added, and size should not be incremented).
   *
   * Remember to recalculate heights and balance factors while going back
   * up the tree after adding the element, making sure to rebalance if
   * necessary. This is as simple as calling the balance() method on the
   * current node, before returning it (assuming that your balance method
   * is written correctly from part 1 of this assignment).
   *
   * @param data The data to add.
   * @throws java.lang.IllegalArgumentException If data is null.
   */
  public void add(T data) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    if (data == null) {
      throw new IllegalArgumentException("The data is null");
    }
    root = recursiveAdd(root, data);
  }

  private AVLNode<T> recursiveAdd(AVLNode<T> node, T data) {
    if (node == null) {
      node = new AVLNode<T>(data);
      size += 1;
    } else if (node.getData().compareTo(data) > 0) {
      node.setLeft(recursiveAdd(node.getLeft(), data));
    } else if (node.getData().compareTo(data) < 0) {
      node.setRight(recursiveAdd(node.getRight(), data));
    }
    updateHeightAndBF(node);
    if (node.getBalanceFactor() > 1 || node.getBalanceFactor() < -1) {
      node = balance(node);
    }
    return node;
  }

  /**
   * Removes and returns the element from the tree matching the given
   * parameter.
   *
   * There are 3 cases to consider:
   * 1: The node containing the data is a leaf (no children). In this case,
   * simply remove it.
   * 2: The node containing the data has one child. In this case, simply
   * replace it with its child.
   * 3: The node containing the data has 2 children. Use the successor to
   * replace the data, NOT predecessor. As a reminder, rotations can occur
   * after removing the successor node.
   *
   * Remember to recalculate heights and balance factors while going back
   * up the tree after removing the element, making sure to rebalance if
   * necessary. This is as simple as calling the balance() method on the
   * current node, before returning it (assuming that your balance method
   * is written correctly from part 1 of this assignment).
   *
   * Do NOT return the same data that was passed in. Return the data that
   * was stored in the tree.
   *
   * Hint: Should you use value equality or reference equality?
   *
   * @param data The data to remove.
   * @return The data that was removed.
   * @throws java.lang.IllegalArgumentException If the data is null.
   * @throws java.util.NoSuchElementException   If the data is not found.
   */
  public T remove(T data) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    if (data == null) {
      throw new IllegalArgumentException("The data is null");
    }
    AVLNode<T> dummy = new AVLNode<>(null);
    root = recursiveRemove(root, data, dummy);
    size -= 1;
    return dummy.getData();
  }

  private AVLNode<T> recursiveRemove(AVLNode<T> node, T data, AVLNode<T> removedNode) {
    if (node == null) {
      throw new NoSuchElementException("The data is not in the tree");
    } else if (node.getData().compareTo(data) > 0) {
      node.setLeft(recursiveRemove(node.getLeft(), data, removedNode));
    } else if (node.getData().compareTo(data) < 0) {
      node.setRight(recursiveRemove(node.getRight(), data, removedNode));
    } else {
      removedNode.setData(node.getData());
      if (node.getLeft() == null & node.getRight() == null) {
        return null;
      } else if (node.getLeft() != null & node.getRight() == null) {
        node = node.getLeft();
      } else if (node.getRight() != null & node.getLeft() == null) {
        node = node.getRight();
      } else {
        // Remove successor
        AVLNode<T> predecessorNode = new AVLNode<>(null);
        node.setLeft(recursiveRemoveSuccessor(node.getLeft(), predecessorNode));
        node.setData(predecessorNode.getData());
      }
    }
    updateHeightAndBF(node);
    if (node.getBalanceFactor() > 1 || node.getBalanceFactor() < -1) {
      node = balance(node);
    }
    return node;
  }

  private AVLNode<T> recursiveRemoveSuccessor(AVLNode<T> node, AVLNode<T> successorNode) {
    if (node.getLeft() == null) {
      successorNode.setData(node.getData());
      AVLNode<T> dummy = new AVLNode<>(null);
      node = recursiveRemove(node, node.getData(), dummy);
    } else {
      node.setLeft(recursiveRemoveSuccessor(node.getLeft(), successorNode));
    }
    updateHeightAndBF(node);
    return node;
  }

  /**
   * Updates the height and balance factor of a node using its
   * setter methods.
   *
   * Recall that a null node has a height of -1. If a node is not
   * null, then the height of that node will be its height instance
   * data. The height of a node is the max of its left child's height
   * and right child's height, plus one.
   *
   * The balance factor of a node is the height of its left child
   * minus the height of its right child.
   *
   * This method should run in O(1).
   * You may assume that the passed in node is not null.
   *
   * This method should only be called in rotateLeft(), rotateRight(),
   * and balance().
   *
   * @param currentNode The node to update the height and balance factor of.
   */
  private void updateHeightAndBF(AVLNode<T> currentNode) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    int leftHeight = (currentNode.getLeft() == null) ? -1 : currentNode.getLeft().getHeight();
    int rightHeight = (currentNode.getRight() == null) ? -1 : currentNode.getRight().getHeight();

    currentNode.setHeight(Math.max(leftHeight, rightHeight) + 1);
    currentNode.setBalanceFactor(leftHeight - rightHeight);
  }

  /**
   * Method that rotates a current node to the left. After saving the
   * current's right node to a variable, the right node's left subtree will
   * become the current node's right subtree. The current node will become
   * the right node's left subtree.
   *
   * Don't forget to recalculate the height and balance factor of all
   * affected nodes, using updateHeightAndBF().
   *
   * This method should run in O(1).
   *
   * You may assume that the passed in node is not null and that the subtree
   * starting at that node is right heavy. Therefore, you do not need to
   * perform any preliminary checks, rather, you can immediately perform a
   * left rotation on the passed in node and return the new root of the subtree.
   *
   * This method should only be called in balance().
   *
   * @param currentNode The current node under inspection that will rotate.
   * @return The parent of the node passed in (after the rotation).
   */
  private AVLNode<T> rotateLeft(AVLNode<T> currentNode) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    AVLNode<T> temp = currentNode.getRight();
    currentNode.setRight(temp.getLeft());
    temp.setLeft(currentNode);
    updateHeightAndBF(temp.getLeft());
    updateHeightAndBF(temp);
    return temp;
  }

  /**
   * Method that rotates a current node to the right. After saving the
   * current's left node to a variable, the left node's right subtree will
   * become the current node's left subtree. The current node will become
   * the left node's right subtree.
   *
   * Don't forget to recalculate the height and balance factor of all
   * affected nodes, using updateHeightAndBF().
   *
   * This method should run in O(1).
   *
   * You may assume that the passed in node is not null and that the subtree
   * starting at that node is left heavy. Therefore, you do not need to perform
   * any preliminary checks, rather, you can immediately perform a right
   * rotation on the passed in node and return the new root of the subtree.
   *
   * This method should only be called in balance().
   *
   * @param currentNode The current node under inspection that will rotate.
   * @return The parent of the node passed in (after the rotation).
   */
  private AVLNode<T> rotateRight(AVLNode<T> currentNode) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    AVLNode<T> temp = currentNode.getLeft();
    currentNode.setLeft(temp.getRight());
    temp.setRight(currentNode);
    updateHeightAndBF(temp.getRight());
    updateHeightAndBF(temp);
    return temp;
  }

  /**
   * This is the overarching method that is used to balance a subtree
   * starting at the passed in node. This method will utilize
   * updateHeightAndBF(), rotateLeft(), and rotateRight() to balance
   * the subtree. In part 2 of this assignment, this balance() method
   * will be used in your add() and remove() methods.
   *
   * The height and balance factor of the current node is first recalculated.
   * Based on the balance factor, a no rotation, a single rotation, or a
   * double rotation takes place. The current node is returned.
   *
   * You may assume that the passed in node is not null. Therefore, you do
   * not need to perform any preliminary checks, rather, you can immediately
   * check to see if any rotations need to be performed.
   *
   * This method should run in O(1).
   *
   * @param cur The current node under inspection.
   * @return The AVLNode that the caller should return.
   */
  private AVLNode<T> balance(AVLNode<T> currentNode) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

    /* First, we update the height and balance factor of the current node. */
    updateHeightAndBF(currentNode);

    /* Condition for a right heavy tree. */
    if (currentNode.getBalanceFactor() == -2) {
      /* Condition for a right-left rotation. */
      if (currentNode.getRight().getBalanceFactor() == 1) {
        currentNode.setRight(rotateRight(currentNode.getRight()));
      }
      currentNode = rotateLeft(currentNode);
    } /* Condition for a left heavy tree. */
    else if (currentNode.getBalanceFactor() == 2) {
      /* Condition for a left-right rotation. */
      if (currentNode.getLeft().getBalanceFactor() == -1) {
        currentNode.setLeft(rotateLeft(currentNode.getLeft()));
      }
      currentNode = rotateRight(currentNode);
    }

    return currentNode;
  }

  public AVLNode<T> getRoot() {
    // DO NOT MODIFY THIS METHOD!
    return root;
  }

  /**
   * Returns the size of the tree.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return The size of the tree.
   */
  public int size() {
    // DO NOT MODIFY THIS METHOD!
    return size;
  }
}