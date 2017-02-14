package problems;

/**
 * Created by fsantos on 2/13/17.
 */
public class Prob161 {
    /*
    Print non-repeated elements in sequence
    aaaabbcccca
    OP: abca
     */
    public static <T extends Comparable<T>> void printNonRepeatedInSequence(T[] arr) {
        T prev = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == prev)
                continue;
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
            prev = arr[i];
        }
    }

    public static void main(String[] args) {
        Character[] arr = new Character[] {'a', 'a', 'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'a'};
        printNonRepeatedInSequence(arr);
    }
}
