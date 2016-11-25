package problems;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob6 {
    public static String compress(String s) {
        StringBuilder sb = new StringBuilder();

        Character prev = s.charAt(0);
        int freq = 1;

        for (int i = 1; i < s.length(); i++) {
            Character chr = s.charAt(i);
            if (chr != prev) {
                sb.append(prev);
                sb.append(freq);
                freq = 1;
                prev = chr;
            } else {
                freq++;
            }
        }

        sb.append(prev);
        sb.append(freq);

        String t = sb.toString();
        // Return original string when compressed is bigger
        return t.length() > s.length() ? s : t;
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("a"));
        System.out.println(compress("aaaaa"));
        System.out.println(compress("abcdefghpppppppppppp"));
    }
}
