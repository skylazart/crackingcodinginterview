package problems;

import problems.auxiliar.LinkedListNode;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.copyOf;

/**
 * Created by fsantos on 11/30/16.
 */
public class Prob20 {
    public class MyStack<T extends Comparable<T>> {
        private LinkedListNode<T> head;
        private int N;

        public MyStack() {
            head = null;
            N = 0;
        }

        public void push(T v) {
            N++;

            if (head == null) {
                head = new LinkedListNode<T>(v);
            } else {
                LinkedListNode<T> t = new LinkedListNode<>(v);
                t.next = head;
                head = t;
            }
        }

        public T pop() throws IllegalStateException {
            if (head == null)
                throw new IllegalStateException("Stack is empty");

            T v = head.value;
            head = head.next;
            N--;
            return v;
        }

        public int size() {
            return N;
        }
    }

    public class StackOfPlates<T extends Comparable<T>> {
        private static final int INITIAL_SIZE = 3;
        private int maxElements;
        private int totalElements;
        private List<MyStack<T>> stacks = new ArrayList<>();

        public StackOfPlates(int n) {
            maxElements = n;
            totalElements = 0;
        }

        public void push(T value) {
            int idx = (++totalElements / maxElements);
            fitStacks(idx);

            MyStack<T> s = stacks.get(idx);
            s.push(value);
        }

        private void fitStacks(int idx) {
            while ((idx + 1) > stacks.size()) {
                stacks.add(new MyStack<T>());
            }
        }

        public T pop() throws IllegalStateException {
            int idx = stacks.size() - 1;
            if (idx < 0)
                throw new IllegalStateException("Empty");

            MyStack<T> s = stacks.get(idx);
            T e = s.pop();
            totalElements--;

            if (s.size() == 0) {
                stacks.remove(idx);
            }
            return e;
        }
    }

    public static void main(String[] args) {
        new Prob20().run();
    }

    private void run() {
        StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>(3);
        stackOfPlates.push(10);
        stackOfPlates.push(20);
        stackOfPlates.push(30);
        stackOfPlates.push(40);

        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
    }
}
