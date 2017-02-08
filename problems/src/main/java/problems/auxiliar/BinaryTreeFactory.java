package problems.auxiliar;

/**
 * Created by fsantos on 1/11/17.
 */
public class BinaryTreeFactory {
    /*
                           1
                        2      3
                      4   5
                            6

     */
    public static BinaryTreeNode<Integer> makeBinaryTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(3);
        root.left = new BinaryTreeNode<>(2);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.left.right.right = new BinaryTreeNode<>(6);
        return root;

    }

    public static BinaryTreeNode<Integer> makeBinaryTreeFromList(Integer[] arr) {
        BinaryTreeNode<Integer> root = null;
        for (Integer x: arr) {
            root = insert(root, x);
        }
        return root;
    }

    private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, Integer x) {
        if (node == null) return new BinaryTreeNode<>(x);
        if (x.compareTo(node.value) > 0) node.right = insert(node.right, x);
        else node.left = insert(node.left, x);
        return node;
    }

    public static BinaryTreeNode<Integer> makeBalancedBinaryTree() {
        return null;
    }

    /*
                  10
           7              19
         6   9         13     22
                    12
     */

    public static BinaryTreeNode<Integer> makeBST() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(7);
        root.left.left = new BinaryTreeNode<>(6);
        root.left.right = new BinaryTreeNode<>(9);
        root.right = new BinaryTreeNode<>(19);
        root.right.left = new BinaryTreeNode<>(13);
        root.right.left.left = new BinaryTreeNode<>(12);
        root.right.right = new BinaryTreeNode<>(22);
        return root;
    }
}
