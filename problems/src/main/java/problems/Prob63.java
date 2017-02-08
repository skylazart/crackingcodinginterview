package problems;

/**
 * Created by fsantos on 1/5/17.
 */
public class Prob63 {
    /*
    Input:   str = "a,b$c"
    c,b$a

    Output:  str = "c,b$a"

    Input:   str = "Ab,c,de!$"
    ed,c,bA$$

    Output:  str = "ed,c,bA!$"
     */

    /*
    "a,b$c"
    " , $ "

    "c, $ "
     */

    public static boolean isSpecial(char chr) {
        if (chr == '!' || chr == '$' || chr == ',') return true;
        return false;
    }

    public static char[] specialReverse(char[] arr) {
        char[] reversed = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (isSpecial(arr[i]))
                reversed[i] = arr[i];
        }

        int outIdx = 0;
        int inIdx = arr.length - 1;

        while (inIdx >= 0) {
            if (isSpecial(arr[inIdx])) {
                inIdx--;
                continue;
            }

            if (isSpecial(reversed[outIdx])) {
                outIdx++;
                continue;
            }

            reversed[outIdx] = arr[inIdx];
            outIdx++;
            inIdx--;
        }
        return reversed;
    }

    public static void main(String[] args) {
        char[] arr = new char[] {'a', ',', 'b', '$', 'c'};
        char[] reverted = specialReverse(arr);

        printArr(arr);
        printArr(reverted);
    }

    private static void printArr(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
