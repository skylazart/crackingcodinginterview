package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fsantos on 11/24/16.
 */
public class Prob2 {
    public static boolean isAllUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);
            if (set.contains(chr)) {
                return false;
            } else {
                set.add(chr);
            }
        }

        return true;
    }

    public static boolean isAllUniqueNoAdditionalSpace(String s) {
        if (s.length() < 2) return true;

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAllUnique("abcdefg"));
        System.out.println(isAllUnique("abcdefgaa"));
        System.out.println(isAllUniqueNoAdditionalSpace("abcdefg"));
        System.out.println(isAllUniqueNoAdditionalSpace("abcdefgaa"));
    }
}
