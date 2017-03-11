package problems;

/**
 * Created by fsantos on 2/14/17.
 */
public class Prob166 {
    public static String findOperators(int[] arr, int wanted) {
        return findOperators(arr, arr[0], "", 1, wanted);
    }

    private static String findOperators(int[] arr, int acc, String opers, int idx, int wanted) {
        if (acc == wanted)
            return opers;

        if (idx > arr.length)
            return null;

        String sum = findOperators(arr, acc + arr[idx], opers + "+", idx + 1, wanted);
        if (sum != null) return sum;

        String multiply = findOperators(arr, acc * arr[idx], opers + "*", idx + 1, wanted);
        if (multiply != null) return multiply;

        String divide = findOperators(arr, acc / arr[idx], opers + "/", idx + 1, wanted);
        if (divide != null) return divide;

        String subtract = findOperators(arr, acc - arr[idx], opers + "-", idx + 1, wanted);
        if (subtract != null) return subtract;

        return null;
    }

    public static void main(String[] args) {
        String opers = findOperators(new int[]{5, 5, 5}, 15);
        if (opers != null)
            System.out.println(opers);
    }
}
