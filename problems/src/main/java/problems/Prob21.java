package problems;

import problems.auxiliar.Node;

/**
 * Created by fsantos on 12/1/16.
 */
public class Prob21 {
    public interface MyStackI<T extends Comparable<T>> {
        void push(T v);
        T pop();
        T peek();
        boolean isEmpty();
    }

    public class MyStack<T extends Comparable<T>> implements MyStackI<T> {
        private Node<T> head = null;

        @Override
        public void push(T v) {
            if (head == null) {
                head = new Node<T>(v);
            } else {
                Node<T> t = new Node<T>(v);
                t.next = head;
                head = t;
            }
        }

        @Override
        public T pop() {
            T v = head.value;
            head = head.next;
            return v;
        }

        @Override
        public T peek() {
            if (head == null)
                return null;

            return head.value;
        }

        @Override
        public boolean isEmpty() {
            return head == null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            Node<T> current = head;
            while (current != null) {
                if (current != head) sb.append(" -> ");
                sb.append(current.value);
                current = current.next;
            }

            if (sb.length() == 0)
                sb.append("empty");

            return sb.toString();
        }
    }

    public <T extends Comparable<T>> void sortStack(MyStackI<T> stack) {
        MyStackI<T> temp = new MyStack<>();

        while (!stack.isEmpty()) {
            System.out.println("stack: " + stack.toString());
            System.out.println("temp: " + temp.toString());

            T x = stack.pop();

            if (temp.isEmpty()) {
                temp.push(x);
                continue;
            }

            while (!temp.isEmpty() && x.compareTo(temp.peek()) < 0) {
                stack.push(temp.pop());
            }

            temp.push(x);
        }

        System.out.println("stack: " + stack.toString());
        System.out.println("temp: " + temp.toString());

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        System.out.println("stack: " + stack.toString());
        System.out.println("temp: " + temp.toString());
    }

    private void run() {
        MyStackI<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        sortStack(stack);
    }

    public static void main(String[] args) {
        new Prob21().run();
    }
}
