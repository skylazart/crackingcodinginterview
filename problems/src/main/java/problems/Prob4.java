package problems;

import javax.jws.Oneway;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by fsantos on 11/24/16.
 */
public class Prob4 {
    public static boolean oneWay(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1)
            return false;

        Map<Character, Integer> freqA = makeFrequencyMap(a);
        int totalDiffs = calculateDiff(freqA, b);

        return totalDiffs <= 1;
    }

    private static int calculateDiff(Map<Character, Integer> freqA, String b) {
        int totalDiff = 0;

        for (int i = 0; i < b.length(); i++) {
            Character chr = b.charAt(i);
            Integer c = freqA.get(chr);
            if (c == null) {
                totalDiff++;
            } else {
                c--;
                if (c < 0) totalDiff++;
                freqA.put(chr, c);
            }
        }
        return totalDiff;
    }

    private static Map<Character, Integer> makeFrequencyMap(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);
            Integer c = freq.get(chr);
            if (c == null) freq.put(chr, 1);
            else freq.put(chr, c + 1);
        }
        return freq;
    }

    public static void main(String[] args) {
        System.out.println(oneWay("pale", "ple"));
        System.out.println(oneWay("pales", "pale"));
        System.out.println(oneWay("pale", "bale"));
        System.out.println(oneWay("pale", "bake"));
    }

}
