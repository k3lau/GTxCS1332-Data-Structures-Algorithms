import java.util.List;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

  /**
   * DO NOT ADD ANY GLOBAL VARIABLES!
   */

  /**
   * Given the root of a binary search tree, generate a
   * pre-order traversal of the tree. The original tree
   * should not be modified in any way.
   *
   * This must be done recursively.
   *
   * Must be O(n).
   *
   * @param <T>  Generic type.
   * @param root The root of a BST.
   * @return List containing the pre-order traversal of the tree.
   */
  public List<T> preorder(AVLNode<T> root) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    List<T> result = new LinkedList<>();
    preorderHelper(result, root);
    return result;
  }

  private void preorderHelper(List<T> list, AVLNode<T> currentNode) {
    if (currentNode != null) {
      list.add(currentNode.getData());
      preorderHelper(list, currentNode.getLeft());
      preorderHelper(list, currentNode.getRight());
    }
  }

  /**
   * Given the root of a binary search tree, generate an
   * in-order traversal of the tree. The original tree
   * should not be modified in any way.
   *
   * This must be done recursively.
   *
   * Must be O(n).
   *
   * @param <T>  Generic type.
   * @param root The root of a BST.
   * @return List containing the in-order traversal of the tree.
   */
  public List<T> inorder(AVLNode<T> root) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    List<T> result = new LinkedList<>();
    inorderHelper(result, root);
    return result;
  }

  private void inorderHelper(List<T> list, AVLNode<T> currentNode) {
    if (currentNode != null) {
      inorderHelper(list, currentNode.getLeft());
      list.add(currentNode.getData());
      inorderHelper(list, currentNode.getRight());
    }
  }

  /**
   * Given the root of a binary search tree, generate a
   * post-order traversal of the tree. The original tree
   * should not be modified in any way.
   *
   * This must be done recursively.
   *
   * Must be O(n).
   *
   * @param <T>  Generic type.
   * @param root The root of a BST.
   * @return List containing the post-order traversal of the tree.
   */
  public List<T> postorder(AVLNode<T> root) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    List<T> result = new LinkedList<>();
    postorderHelper(result, root);
    return result;
  }

  private void postorderHelper(List<T> list, AVLNode<T> currentNode) {
    if (currentNode != null) {
      postorderHelper(list, currentNode.getLeft());
      postorderHelper(list, currentNode.getRight());
      list.add(currentNode.getData());
    }
  }
}