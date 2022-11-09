import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BSTTest {
  @Test
  public void testAddToNullBST() {
    BST<Integer> test = new BST<>();
    BSTNode<Integer> expected = new BSTNode<>(4);
    test.add(4);
    assertEquals(test.getRoot().getData(), expected.getData());
  }

  @Test
  public void testAddToExistingBST() {
    Traversals<Integer> traversal = new Traversals<>();
    String expectedList = "[50, 15, 5, 10, 25, 75, 100]";
    BST<Integer> test = new BST<>();
    test.add(50);
    test.add(75);
    test.add(15);
    test.add(5);
    test.add(10);
    test.add(100);
    test.add(25);
    String testList = traversal.preorder(test.getRoot()).toString();
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }

  @Test
  public void testAddToRight() {
    ;
    BST<Integer> test = new BST<>();
    test.add(50);
    test.add(75);
    Integer x = test.getRoot().getRight().getData();
    Integer expected = 75;
    assertEquals(expected, x);
  }

  @Test
  public void testAddToLeft() {
    ;
    BST<Integer> test = new BST<>();
    test.add(50);
    test.add(15);
    Integer expected = 15;
    assertEquals(expected, test.getRoot().getLeft().getData());
  }

  @Test
  public void testSizeWhenAdd() {
    BST<Integer> test = new BST<>();
    test.add(50);
    test.add(75);
    test.add(15);
    test.add(5);
    test.add(10);
    assertEquals(5, test.size());
  }

  @Test
  public void testRemoveLeafNode() {
    Traversals<Integer> traversal = new Traversals<>();
    BST<Integer> test = new BST<>();
    test.add(50);
    test.add(75);
    test.add(15);
    test.add(5);
    test.add(10);
    test.remove(10);
    String testList = traversal.preorder(test.getRoot()).toString();
    String expectedList = "[50, 15, 5, 75]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }

  @Test
  public void testRemoveNodeOneChild() {
    Traversals<Integer> traversal = new Traversals<>();
    BST<Integer> test = new BST<>();
    test.add(50);
    test.add(75);
    test.add(15);
    test.add(5);
    test.add(10);
    Integer returnVariable = test.remove(5);
    Integer expectedReturn = 5;
    String testList = traversal.preorder(test.getRoot()).toString();
    String expectedList = "[50, 15, 10, 75]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
    assertEquals(expectedReturn, returnVariable);
  }

  @Test
  public void testRemoveNodeTwoChild() {
    Traversals<Integer> traversal = new Traversals<>();
    BST<Integer> test = new BST<>();
    test.add(50);
    test.add(75);
    test.add(15);
    test.add(5);
    test.add(25);
    test.add(100);
    test.add(20);
    test.remove(15);
    String testList = traversal.preorder(test.getRoot()).toString();
    String expectedList = "[50, 20, 5, 25, 75, 100]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }

  @Test
  public void testRemoveRootNodeTwoChild() {
    Traversals<Integer> traversal = new Traversals<>();
    BST<Integer> test = new BST<>();
    test.add(1);
    test.add(0);
    test.add(2);
    test.add(3);
    test.remove(1);
    String testList = traversal.preorder(test.getRoot()).toString();
    String expectedList = "[2, 0, 3]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }

  @Test
  public void testRemoveNodeTwoChildSuccessorWithOneChild() {
    Traversals<Integer> traversal = new Traversals<>();
    BST<Integer> test = new BST<>();
    test.add(1);
    test.add(0);
    test.add(5);
    test.add(4);
    test.add(2);
    test.add(3);
    test.remove(1);
    String testList = traversal.preorder(test.getRoot()).toString();
    String expectedList = "[2, 0, 5, 4, 3]";
    System.out.println(expectedList);
    System.out.println(testList);
    assertEquals(expectedList, testList);
  }
}
