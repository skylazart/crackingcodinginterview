package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fsantos on 11/24/16.
 */
public class Prob1 {
    public static int test(Map<Character, Integer> dic, String sub) {
        int left = sub.length();

        for (int i = 0; i < sub.length(); i++) {
            Character chr = sub.charAt(i);

            Integer c = dic.get(chr);
            if (c != null && c > 0) {
                left--;
                dic.put(chr, c - 1);
                continue;
            }
        }

        return left;
    }

    private static Map<Character, Integer> buildDic(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);
            Integer c = dic.get(chr);
            if (c == null) {
                dic.put(chr, 1);
            } else {
                dic.put(chr, c + 1);
            }
        }

        return dic;
    }

    public static void main(String[] args) {
        String smaller = "abbc";
        String bigger = "xxxxxxxxxxcbabadcbbabbcbabaabccbabc";

        Map<Character, Integer> dic = buildDic(smaller);

        // Searching in the substring
        int i = 0;
        while (i < bigger.length() - (smaller.length() - 1)) {
            String t = bigger.substring(i, i + smaller.length());

            Map<Character, Integer> dicCopy = new HashMap<>(dic);
            int left = test(dicCopy, t);
            if (left == 0) {
                System.out.println("Index:" + i);
                i += 1;
            } else {
                i += left;
            }
        }
    }
}
