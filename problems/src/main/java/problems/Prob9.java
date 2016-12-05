package problems;

// Have to finish it

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob9 {
    public static int isSubstring(String s1, String s2) {
        return -1;
    }


    // Check if s2 is a rotation of s1
    public static boolean isRotation(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            String t = s1.substring(i, s1.length());

            if (s2.startsWith(t)) {
                String left = s1.substring(0, i);
                return (s2.endsWith(left));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
}
