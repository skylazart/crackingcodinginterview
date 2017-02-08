package problems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by fsantos on 1/13/17.
 */
public class Prob81 {
    /*
    stack  = 6 4 7 1 4 3 9
    output = 1 3 4 4 6 7 9

    temp   = 9 7 6 4 4 3 1

     running

     stack 4 7 1 4 3 9
     temp  6

     stack 7 1 4 3 9
     temp  6

     stack 6 7 1 4 3 9
     temp  4

     stack 1 4 3 9
     temp  7 6 4

     stack 4 6 7 4 3 9
     temp  1

     stack 4 3 9
     temp  7 6 4 1

     stack 6 7 3 9
     temp  4 4 1

     stack 3 9
     temp  7 6 4 4 1

     stack 4 4 6 7 9
     temp  3 1

     stack
     temp  9 7 6 4 4 3 1
     */
    public static void customSort(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) return;

        Stack<Integer> temp = new Stack<>();
        temp.push(stack.pop());

        while (!stack.isEmpty()) {
            Integer x = stack.pop();
            while (!temp.isEmpty() && x > temp.peek()) {
                stack.push(temp.pop());
            }
            temp.push(x);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (Integer x: Arrays.asList(6, 4, 7, 1, 4, 3, 9)) {
            stack.push(x);
        }

        printStack(stack);
        customSort(stack);
        printStack(stack);
    }

    private static void printStack(Stack<Integer> stack) {
        int i = 0;
        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            if (i++ > 0) System.out.print(", ");
            System.out.print(it.next());
        }
        System.out.println();
    }
}
