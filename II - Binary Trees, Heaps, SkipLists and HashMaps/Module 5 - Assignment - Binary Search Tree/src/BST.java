import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("The data is null");
        }
        root = recursiveAdd(root, data);
    }

    private BSTNode<T> recursiveAdd(BSTNode<T> node, T data) {
        if (node == null) {
            node = new BSTNode<T>(data);
            size += 1;
        } else if (node.getData().compareTo(data) > 0) {
            node.setLeft(recursiveAdd(node.getLeft(), data));
        } else if (node.getData().compareTo(data) < 0) {
            node.setRight(recursiveAdd(node.getRight(), data));
        }
        return node;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("The data is null");
        }
        BSTNode<T> dummy = new BSTNode<>(null);
        root = recursiveRemove(root, data, dummy);
        size -= 1;
        return dummy.getData();
    }

    private BSTNode<T> recursiveRemove(BSTNode<T> node, T data, BSTNode<T> removedNode) {
        if (node == null) {
            throw new NoSuchElementException("The data is not in the tree");
        } else if (node.getData().compareTo(data) > 0) {
            node.setLeft(recursiveRemove(node.getLeft(), data, removedNode));
        } else if (node.getData().compareTo(data) < 0) {
            node.setRight(recursiveRemove(node.getRight(), data, removedNode));
        } else {
            removedNode.setData(node.getData());
            if (node.getLeft() == null & node.getRight() == null) {
                node = null;
            } else if (node.getLeft() != null & node.getRight() == null) {
                node = node.getLeft();
            } else if (node.getRight() != null & node.getLeft() == null) {
                node = node.getRight();
            } else {
                // Remove successor
                BSTNode<T> successorNode = new BSTNode<>(null);
                node.setRight(recursiveRemoveSuccessor(node.getRight(), successorNode));
                node.setData(successorNode.getData());
            }
        }
        return node;
    }

    private BSTNode<T> recursiveRemoveSuccessor(BSTNode<T> node, BSTNode<T> successorNode) {
        if (node.getLeft() == null) {
            successorNode.setData(node.getData());
            BSTNode<T> dummy = new BSTNode<>(null);
            node = recursiveRemove(node, node.getData(), dummy);
        } else {
            node.setLeft(recursiveRemoveSuccessor(node.getLeft(), successorNode));
        }
        return node;
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
