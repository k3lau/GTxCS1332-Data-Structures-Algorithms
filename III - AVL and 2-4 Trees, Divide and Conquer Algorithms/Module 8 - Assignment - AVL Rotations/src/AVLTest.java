import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AVLTest {
  @Test
  public void testRotateLeft() {
    AVLNode<Integer> test = new AVLNode<>(3);
    test.setLeft(new AVLNode<Integer>(1));
    test.getLeft().setRight(new AVLNode<Integer>(2));
    AVL<Integer> AVL = new AVL<>();
    AVL.updateHeightAndBF(test.getLeft().getRight());
    AVL.updateHeightAndBF(test.getLeft());
    AVL.updateHeightAndBF(test);
    test = AVL.balance(test);
    assertEquals(1, test.getHeight());
    assertEquals(0, test.getBalanceFactor());
    assertEquals(0, test.getLeft().getHeight());
    assertEquals(0, test.getLeft().getBalanceFactor());
    assertEquals(0, test.getRight().getHeight());
    assertEquals(0, test.getRight().getBalanceFactor());
  }

  @Test
  public void testRotateRight() {

  }

  @Test
  public void testUpdateHeightAndBF() {
    AVLNode<Integer> test = new AVLNode<>(3);
    test.setLeft(new AVLNode<Integer>(1));
    test.getLeft().setRight(new AVLNode<Integer>(2));
    AVL<Integer> AVL = new AVL<>();
    AVL.updateHeightAndBF(test.getLeft().getRight());
    AVL.updateHeightAndBF(test.getLeft());
    AVL.updateHeightAndBF(test);
    assertEquals(2, test.getHeight());
    assertEquals(2, test.getBalanceFactor());
    assertEquals(1, test.getLeft().getHeight());
    assertEquals(-1, test.getLeft().getBalanceFactor());
    assertEquals(0, test.getLeft().getRight().getHeight());
    assertEquals(0, test.getLeft().getRight().getBalanceFactor());
  }

  @Test
  public void testRemoveNodeTwoChildSuccessorWithOneChild() {
    Traversals<Integer> traversal = new Traversals<>();
    AVL<Integer> test = new AVL<>();
    test.add(1);
    test.add(0);
    test.add(5);
    test.add(4);
    test.add(2);
    test.add(3);
    test.remove(1);
    String testList = traversal.preorder(test.getRoot()).toString();
    String expectedList = "[0, 5, 4, 2, 3]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }

  @Test
  public void testAddNode() {
    Traversals<Integer> traversal = new Traversals<>();
    AVL<Integer> test = new AVL<>();
    test.add(2);
    test.add(0);
    test.add(7);
    test.add(1);
    test.add(4);
    test.add(8);
    test.add(3);
    test.add(6);
    test.add(5);
    String testList = traversal.preorder(test.getRoot()).toString();
    // String expectedList = "[2, 0, 1, 7, 4, 3, 6, 8]";
    String expectedList = "[2, 0, 1, 6, 4, 3, 5, 7, 8]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }

  @Test
  public void testRemoveNode() {
    Traversals<Integer> traversal = new Traversals<>();
    AVL<Integer> test = new AVL<>();
    test.add(2);
    test.add(0);
    test.add(4);
    test.add(1);
    test.add(3);
    test.add(6);
    test.add(5);
    test.remove(3);
    String testList = traversal.preorder(test.getRoot()).toString();
    // String expectedList = "[2, 0, 1, 4, 3, 6, 5]";
    String expectedList = "[2, 0, 1, 5, 4, 6]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }
}
