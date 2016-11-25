package problems;

// Have to finish it

import java.util.Map;
import java.util.HashMap;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob9 {
    public static int isSubstring(String s1, String s2) {
        return -1;
    }


    // Check if s2 is a rotation of s1
    public static boolean isRotation(String s1, String s2) {
        int idx = isSubstring(s1, s2);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
}
