package problems.auxiliar;

/**
 * Created by fsantos on 1/5/17.
 */
public class ArrayUtils {
    public static void printArr(int[] arr, String sep) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(sep);
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
