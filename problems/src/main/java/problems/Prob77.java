package problems;

/**
 * Created by fsantos on 1/12/17.
 */
public class Prob77 {
    public static String reverse(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();

        for (int i =0; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("felipe"));
    }
}
