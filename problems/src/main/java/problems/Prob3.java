package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by fsantos on 11/24/16.
 */
public class Prob3 {
    public static boolean isPermutation(String a, String b) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            Character chr = a.charAt(i);
            Integer c = freq.get(chr);

            if (c == null)
                freq.put(chr, 1);
            else
                freq.put(chr, c + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            Character chr = b.charAt(i);
            Integer c = freq.get(chr);
            if (c == null) return false;

            freq.put(chr, c - 1);
        }

        for (int i = 0; i < a.length(); i++) {
            Character chr = a.charAt(i);
            Integer c = freq.get(chr);
            if (c != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
