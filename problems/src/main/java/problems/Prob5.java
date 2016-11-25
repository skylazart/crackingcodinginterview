package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob5 {
    public static boolean isPalindromePermutaion(String s) {
        String upper = s.toUpperCase();
        int lenValidChars = 0;

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < upper.length(); i++) {
            Character chr = upper.charAt(i);

            if (chr == ' ') continue;

            lenValidChars++;
            Integer c = freq.get(chr);
            if (c == null) freq.put(chr, 1);
            else freq.put(chr, c + 1);
        }

        int totalOdd = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {

            if ((entry.getValue() % 2) != 0) {
                totalOdd++;
            }
        }

        if ((lenValidChars% 2) == 0) {
            // Even number of elements w/o space
            if (totalOdd != 0) return false;
            else return true;
        }

        // Off number of elements w/o space
        if (totalOdd == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutaion("Tact Coa"));
    }
}
