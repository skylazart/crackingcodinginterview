package problems;

/**
 * Created by fsantos on 1/12/17.
 */
public class Prob78 {
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T wanted) {
        int left = 0;
        int right = arr.length - 1;

        // check
        while (left <= right) {
            int mid = midPoint(left, right);
            int cmp = wanted.compareTo(arr[mid]);
            if (cmp == 0) return mid;

            if (cmp > 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
    /*
    8, 10, 12, 2, 5, 7 wanted = 7
    8, 10, 12, 2, 5, 7 wanted = 8

    8, 9, 10, 12, 2, 5, 7 wanted = 13

     */
    public static int binarySearchRotated(int[] arr, int wanted) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = midPoint(left, right);

            if (wanted == arr[mid])
                return mid;

            if (wanted > arr[mid]) {
                if (arr[mid] < arr[right]) {
                     if (wanted <= arr[right]) {
                         left = mid + 1;
                     } else {
                         right = mid - 1;
                     }
                } else {
                    right = mid - 1;
                }
            } else {
                if (arr[left] < arr[mid] && wanted < arr[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int midPoint(int left, int right) {
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        //System.out.println(binarySearch(new Integer[]{2, 5, 7, 8, 10, 12}, 12));
        //System.out.println(binarySearch(new Integer[]{8, 10, 12, 2, 5, 7}, 7));
        System.out.println(binarySearchRotated(new int[]{8, 10, 12, 2, 5, 7}, 7));
        System.out.println(binarySearchRotated(new int[]{8, 10, 12, 2, 5, 7}, 8));
        System.out.println(binarySearchRotated(new int[]{8, 10, 12, 2, 5, 7}, 10));
        System.out.println(binarySearchRotated(new int[]{8, 9, 10, 12, 2, 5, 7}, 5));
        System.out.println(binarySearchRotated(new int[]{8, 9, 10, 12, 2, 5, 7}, 8));
        System.out.println(binarySearchRotated(new int[]{8, 9, 10, 12, 2, 5, 7}, 9));
        System.out.println(binarySearchRotated(new int[]{8, 9, 10, 12, 2, 5, 7}, 10));
        System.out.println(binarySearchRotated(new int[]{8, 9, 10, 12, 2, 5, 7}, 12));
        System.out.println(binarySearchRotated(new int[]{8, 9, 10, 12, 2, 5, 7}, 2));
        System.out.println(binarySearchRotated(new int[]{8, 9, 10, 12, 2, 5, 7}, 5));
        System.out.println(binarySearchRotated(new int[]{8, 9, 10, 12, 2, 5, 7}, 13));
        System.out.println(binarySearchRotated(new int[]{8, 9, 10, 12, 2, 5, 7}, 3));
    }
}
