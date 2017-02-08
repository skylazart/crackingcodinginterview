package problems;

import problems.auxiliar.ArrayUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by fsantos on 2/7/17.
 */
public class Prob136 {
    /*
    Given [2, 6, 1] return 2
    Given [2, 6, 1, 4] return 3 which is sum of the two elements in middle over 2

    2, 6, 1
    length = 3
    max = 6

    2, 6, 1, 4
    length = 4
    min = 1
    max = 6

    1 2 4 6

    2, 6, 1, 4, 5

     */
    public static int findMedian(int[] unsortedArray) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int maxElements = (unsortedArray.length / 2) + 1;

        for (int i = 0; i < unsortedArray.length; i++) {
            priorityQueue.add(unsortedArray[i]);
            if (priorityQueue.size() > maxElements)
                priorityQueue.remove();
        }

        if (unsortedArray.length % 2 == 1)
            return priorityQueue.remove();

        int a = priorityQueue.remove();
        int b = priorityQueue.remove();
        return (a + b) / 2;
    }

    private static int midPoint(int left, int right) {
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{2, 6, 1}));
        System.out.println(findMedian(new int[]{2, 6, 1, 4}));
    }
}
