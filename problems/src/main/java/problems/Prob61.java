package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fsantos on 1/4/17.
 */
public class Prob61 {
    public static class Pair<T1, T2> {
        private final T1 a;
        private final T2 b;

        public Pair(T1 a, T2 b) {
            this.a = a;
            this.b = b;
        }

        public T1 getA() {
            return a;
        }

        public T2 getB() {
            return b;
        }

        @Override
        public String toString() {
            return "[a: " + a + " b: " + b + "]";
        }
    }

    public static class Triple<T1, T2, T3> {
        private final T1 a;
        private final T2 b;
        private final T3 c;

        public Triple(T1 a, T2 b, T3 c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public Triple(Pair<T1, T2> pair, T3 c) {
            this.a = pair.a;
            this.b = pair.b;
            this.c = c;
        }

        public T1 getA() {
            return a;
        }

        public T2 getB() {
            return b;
        }

        public T3 getC() {
            return c;
        }

        @Override
        public String toString() {
            return "[a: " + a + " b: " + b + " c: " + c + "]";
        }
    }

    public static Pair<Integer, Integer> findSumOfTwo(int[] arr, int k) throws ValuesNotFoundException {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int x = k - arr[i];
            if (set.contains(x)) return new Pair<>(x, arr[i]);
            else set.add(arr[i]);
        }
        throw new ValuesNotFoundException();
    }

    public static Triple<Integer, Integer, Integer> findSumOfThree(int[] arr, int k) throws ValuesNotFoundException {
        for (int i = 0; i < arr.length; i++) {
            int needed = k - arr[i];

            try {
                Pair<Integer, Integer> pair = findSumOfTwo(arr, needed);
                return new Triple<>(pair, arr[i]);
            } catch (ValuesNotFoundException e) {

            }
        }

        throw new ValuesNotFoundException();
    }

    public static void main(String[] args) {
        try {
            System.out.println(findSumOfTwo(new int[]{1, 3, 6, 7}, 10));
        } catch (ValuesNotFoundException e) {
            System.out.println("Values not found");
        }

        try {
            System.out.println(findSumOfThree(new int[]{1, 3, 6, 7}, 10));
        } catch (ValuesNotFoundException e) {
            System.out.println("Values not found");
        }
    }

    private static class ValuesNotFoundException extends Exception {
    }
}
