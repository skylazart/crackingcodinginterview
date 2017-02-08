package problems;

/**
 * Created by fsantos on 1/2/17.
 */
public class Prob48 {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 1, 3, 5, 4, 6};
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);
    }
}
