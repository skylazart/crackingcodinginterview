package problems;

/**
 * Created by fsantos on 11/30/16.
 */
public class Prob19 {
    public static class MinNode<T extends Comparable<T>> {
        private T min;
        private T value;
        private MinNode<T> next;

        public MinNode(T x, T m) {
            value = x;
            min = m;
            next = null;
        }
    }

    public static class StackMin<T extends Comparable<T>> {
        private MinNode<T> head;

        public StackMin() {

        }

        public void push(T value) {
            if (head == null) {
                head = new MinNode<T>(value, value);
                return;
            }

            MinNode<T> v;
            if (value.compareTo(head.min) < 0) {
                // New value is the minimum
                v = new MinNode<T>(value, value);
            } else {
                v = new MinNode<T>(value, head.min);
            }

            v.next = head;
            head = v;
        }

        public T pop() {
            T value = head.value;
            head = head.next;
            return value;
        }

        public T min() {
            return head.min;
        }
    }

    public static void main(String[] args) {
        StackMin<Integer> stackMin = new StackMin<>();
        stackMin.push(10);
        stackMin.push(20);
        stackMin.push(30);

        for (int i = 0; i < 3; i++) {
            System.out.println(stackMin.pop());
        }

        stackMin.push(10);
        stackMin.push(20);
        stackMin.push(30);

        System.out.println(stackMin.min());
        stackMin.push(3);
        System.out.println(stackMin.pop());
        System.out.println("POP");
        System.out.println(stackMin.min());
    }
}
