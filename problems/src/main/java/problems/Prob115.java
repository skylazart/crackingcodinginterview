package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fsantos on 1/31/17.
 */
public class Prob115 {
    public static class Positions implements Comparable<Positions> {
        private int a = -1, b = -1, c = -1;

        public Positions() {

        }

        public void set(int idx) {
            if (a == -1) a = idx;
            else if (b == -1) b = idx;
            else c = idx;
        }

        public boolean found() {
            return a != -1 && b != -1 && c != -1;
        }

        public int getDistance() {
            return c - a;
        }

        @Override
        public int compareTo(Positions p) {
            return getDistance() - p.getDistance();
        }

        @Override
        public String toString() {
            return "Positions{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }

    public static Positions findShortestWindow(int[] arr, int[] set) {
        Positions min = null;
        int begin = 0;

        while (true) {
            Positions pos = findIt(arr, begin, set);
            if (!pos.found()) break;

            if (min == null) {
                min = pos;
            } else {
                if (pos.compareTo(min) < 0)
                    min = pos;
            }

            begin = pos.b;
        }

        return min;
    }

    private static Positions findIt(int[] arr, int begin, int[] set) {
        Set<Integer> wantedSet = new HashSet<>();
        Positions pos = new Positions();

        for (int i = 0; i < set.length; i++)
            wantedSet.add(set[i]);

        for (int i = begin; i < arr.length; i++) {
            if (wantedSet.contains(arr[i])) {
                wantedSet.remove(arr[i]);
                pos.set(i);
            }

            if (wantedSet.size() == 0) break;
        }

        return pos;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {6, 7, 1, 3, 2, 4, 5, 2, 3, 1, 2, 5};
        int[] set = new int[] {2, 5, 1};

        Positions p = findShortestWindow(arr, set);
        System.out.println(p);
    }
}
