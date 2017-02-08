package problems;

/**
 * Created by fsantos on 1/5/17.
 */
public class Prob67 {
    private static void combine(String s) {
        combine("", s);
    }

    private static void combine(String prefix, String s) {
        if (s.length() == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            combine(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
        }
    }

    public static void main(String[] args) {
        combine("abcde");
    }
}
