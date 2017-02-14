package problems;

import java.util.*;

/**
 * Created by fsantos on 2/8/17.
 */
public class Prob146 {
    public static class MinMax implements Comparable<MinMax> {
        private final int min;
        private final int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public int compareTo(MinMax minMax) {
            int cmp = min - minMax.min;
            if (cmp != 0) return cmp;
            return max - minMax.max;
        }

        @Override
        public String toString() {
            return "MinMax{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

    public interface Op {
        boolean match(int x);
    }

    public static class BiggerThan implements Op {
        private final int V;

        public BiggerThan(int V) {
            this.V = V;
        }


        @Override
        public boolean match(int x) {
            return x > V;
        }
    }

    public static class LessThan implements Op {
        private final int V;

        public LessThan(int V) {
            this.V = V;
        }

        @Override
        public boolean match(int x) {
            return x < V;
        }
    }

    public static boolean checkIdentitalBst(int[] a, int[] b, int begin, int min, int max) {

        return true;
    }

    private static boolean compare(Set<Integer> a, Set<Integer> b) {
        if (a.size() != b.size()) return false;
        for (Integer x: a) {
            if (!b.contains(x)) return false;
        }
        return true;
    }

    private static Set<Integer> getElements(int[] arr, int begin, Op match) {
        Set<Integer> set = new HashSet<>();
        for (int i = begin; i < arr.length; i++) {
            if (match.match(arr[i]))
                set.add(arr[i]);

        }
        return set;
    }

    public static void main(String[] args) {
        /*
        System.out.println(checkIdentitalBst(new int[]{2, 4, 1, 3}, new int[]{2, 1, 4, 3}));
        System.out.println(checkIdentitalBst(new int[]{8, 3, 6, 1, 4, 7, 10, 14, 13},
                new int[]{8, 10, 14, 3, 6, 4, 1, 7, 13}));
        */
    }
}