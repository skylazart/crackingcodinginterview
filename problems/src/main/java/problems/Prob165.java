package problems;

/**
 * Created by fsantos on 2/16/17.
 */
public class Prob165 {
    public static class DLL <T extends Comparable<T>> {
        private T value;
        private DLL<T> next;
        private DLL<T> prev;

        public DLL(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public static class Res <T extends Comparable<T>> {
        private DLL<T> head;
        private DLL<T> tail;

        public Res() {
            head = tail = null;
        }

        public void concat(T value) {
            if (head == null) {
                head = new DLL<T>(value);
                tail = head;
            } else {
                DLL<T> t = new DLL<T>(value);
                t.next = head;
                t.prev = tail;
                tail.next = t;
                tail = t;
            }
        }

        public DLL<T> getHead() {
            return head;
        }
    }

    public static class BSTNode <T extends Comparable<T>> {
        private T value;
        private BSTNode<T> right;
        private BSTNode<T> left;

        public BSTNode(T value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    public static <T extends Comparable<T>> void dfs(BSTNode<T> node, Res<T> res) {
        if (node == null) return;
        res.concat(node.value);
        dfs(node.left, res);
        dfs(node.right, res);
    }

    public static void main(String[] args) {
        BSTNode<Integer> root = new BSTNode<>(10);
        root.right = new BSTNode<>(20);
        root.left = new BSTNode<>(5);

        Res<Integer> res = new Res<>();
        dfs(root, res);
        System.out.println();
    }
}
