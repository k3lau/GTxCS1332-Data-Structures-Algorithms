import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class main {

  public static void addBinarySearchTree(TreeNode<Integer> root, Integer data) {
    TreeNode<Integer> current;

    current = root;
    Integer compareResult = current.getData().compareTo(data);
    while (current.getLeft() != null & compareResult > 0) {
      current = current.getLeft();
    }
    compareResult = current.getData().compareTo(data);
    while (current.getRight() != null & compareResult < 0) {
      current = current.getRight();
    }
    compareResult = current.getData().compareTo(data);
    if (compareResult > 0) {
      current.setLeft(new TreeNode<Integer>(data));
    }
    if (compareResult < 0) {
      current.setRight(new TreeNode<Integer>(data));
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello, World.");
    List<Integer> list = new ArrayList<>(7);
    list.add(50);
    list.add(25);
    list.add(100);
    list.add(10);
    list.add(75);
    list.add(125);
    list.add(50);
    list.add(110);

    TreeNode<Integer> root = new TreeNode<>(list.remove(0));
    Traversals<Integer> traversal = new Traversals<>();
    Integer data = list.remove(0);
    while (data != null) {
      addBinarySearchTree(root, data);
      if (list.size() > 0) {
        data = list.remove(0);
      } else {
        data = null;
      }
    }

    System.out.println(traversal.preorder(root).toString());
    System.out.println(traversal.inorder(root).toString());
    System.out.println(traversal.postorder(root).toString());
  }
}
