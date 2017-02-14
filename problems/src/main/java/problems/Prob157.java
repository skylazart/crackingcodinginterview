package problems;

/**
 * Created by fsantos on 2/12/17.
 */
public class Prob157 {
    public static int sumAllNumbersFromString(String s) {
        StringBuilder sb = new StringBuilder();
        int acc = 0;

        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);
            if (chr > '0' && chr < '9') {
                sb.append(chr);
            } else {
                if (sb.length() == 0) continue;
                acc += Integer.parseInt(sb.toString());
                sb = new StringBuilder();
            }
        }

        if (sb.length() > 0)
            acc += Integer.parseInt(sb.toString());

        return acc;
    }

    public static void main(String[] args) {
        String s = "11aa22";
        System.out.println(sumAllNumbersFromString(s));
    }
}
