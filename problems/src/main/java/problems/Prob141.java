package problems;

import problems.auxiliar.ArrayUtils;

import java.util.*;

/**
 * Created by fsantos on 2/8/17.
 */
public class Prob141 {
    public static class Limits {
        private final int begin;
        private final int end;

        public Limits(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    public static int totalAmountOfTime(List<Limits> list) {
        Collections.sort(list, new Comparator<Limits>() {
            @Override
            public int compare(Limits o1, Limits o2) {
                return o2.end - o1.end;
            }
        });


        int max = list.get(0).end;
        int[] arr = new int[max + 1];
        for (Limits x: list) {
            Arrays.fill(arr, x.begin, x.end + 1, 1);
        }

        ArrayUtils.printArr(arr, ", ");

        int start = -1;
        int end = -1;
        int acc = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 && start == -1)
                start = end = i;

            if (arr[i] == 1 && start != -1)
                end = i;

            if (arr[i] == 0 && start != -1 && end != -1) {
                acc += end - start;
                end = -1;
                start = -1;
            }
        }

        if (start != -1 && end != -1) {
            acc += end - start;
        }

        return acc;
    }

    public static void main(String[] args) {
        List<Limits> list = new ArrayList<>();
        list.add(new Limits(1, 4));
        list.add(new Limits(6, 8));
        list.add(new Limits(2, 4));
        list.add(new Limits(7, 9));
        list.add(new Limits(10, 15));

        System.out.println(totalAmountOfTime(list));
    }
}
