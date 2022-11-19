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

  @Test
  public void testRemoveLeftRight() {
    Traversals<Integer> traversal = new Traversals<>();
    AVL<Integer> test = new AVL<>();
    test.add(2);
    test.add(0);
    test.add(3);
    test.add(1);
    test.remove(2);
    String testList = traversal.preorder(test.getRoot()).toString();
    // String expectedList = "[2, 0, 1, 4, 3, 6, 5]";
    String expectedList = "[1, 0, 3]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }

  @Test
  public void testRemoveLeftRightHeightFour() {
    Traversals<Integer> traversal = new Traversals<>();
    AVL<Integer> test = new AVL<>();
    test.add(7);
    test.add(4);
    test.add(10);
    test.add(2);
    test.add(6);
    test.add(8);
    test.add(11);
    test.add(0);
    test.add(3);
    test.add(5);
    test.add(9);
    test.add(1);
    test.remove(4);
    String testList = traversal.preorder(test.getRoot()).toString();
    // String expectedList = "[2, 0, 1, 4, 3, 6, 5]";
    String expectedList = "[7, 2, 0, 1, 5, 3, 6, 10, 8, 9, 11]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }

  @Test
  public void testRemoveLeftRightHeightFive() {
    Traversals<Integer> traversal = new Traversals<>();
    AVL<Integer> test = new AVL<>();
    test.add(7);
    test.add(4);
    test.add(15);
    test.add(1);
    test.add(6);
    test.add(10);
    test.add(18);
    test.add(0);
    test.add(3);
    test.add(5);
    test.add(8);
    test.add(13);
    test.add(16);
    test.add(19);
    test.add(2);
    test.add(9);
    test.add(11);
    test.add(14);
    test.add(17);
    test.add(12);
    test.remove(7);
    String testList = traversal.preorder(test.getRoot()).toString();
    // String expectedList = "[2, 0, 1, 4, 3, 6, 5]";
    String expectedList = "[8, 4, 1, 0, 3, 2, 6, 5, 15, 11, 10, 9, 13, 12, 14, 18, 16, 17, 19]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }
}
