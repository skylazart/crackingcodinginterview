package problems;

/**
 * Created by fsantos on 2/8/17.
 */
public class Prob140 {
    public static String reverse(String s, int K) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            arr[i] = s.charAt(i);

        for (int i = 0; i < s.length(); i += K) {
            int left = i;
            int right = i + (K - 1);
            reverse(arr, left, right);
        }

        return new String(arr);
    }

    public static void reverse(char[] arr, int left, int right) {
        while (left < right)
            exch(arr, left++, right--);
    }

    private static void exch(char[] arr, int left, int right) {
        char t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;
    }

    public static void main(String[] args) {
        System.out.println(reverse("felipe", 3));
    }
}
