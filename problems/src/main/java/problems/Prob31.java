package problems;

/**
 * Created by fsantos on 12/5/16.
 */

/**
 * Binary search in a shifted array
 */

public class Prob31 {
    public static int find(int[] arr, int needed) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = midPoint(left, right);

            if (needed == arr[mid]) {
                // Found it
                return mid;
            }

            if (arr[left] < arr[mid]) {
                // This half is increasing
                if (needed < arr[mid] && needed >= arr[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int midPoint(int left, int right) {
        if (left == right) return left;
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 1, 2, 3};

        System.out.println(find(arr, 4));
        System.out.println(find(arr, 1));
        System.out.println(find(arr, 3));
        System.out.println(find(arr, 2));
    }

}
