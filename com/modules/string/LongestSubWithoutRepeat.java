package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubWithoutRepeat {
    public static void main(String[] args) {

        System.out.println(longSubStringWithoutRepeat("aaaabaaa"));
        System.out.println(longSubStringWithoutRepeat("AABCDEF"));
        System.out.println(longSubStringWithoutRepeat("ABCDEFF"));
        System.out.println(longSubStringWithoutRepeat("CODINGISAWESOME"));
        System.out.println(longSubStringWithoutRepeat("always be coding"));
    }

    private static int longSubStringWithoutRepeat(String input) {

        if (input == null || input.length() == 0)
            return 0;

        Set<Character> uniqueChars = new HashSet<Character>();

        int low = 0, high = 0;
        int max = 0;

        String longestStr = "";

        while (high < input.length()) {

            char ch = input.charAt(high);
            if (uniqueChars.add(ch)) {
                high++;
            } else {

                if (uniqueChars.size() > max) {
                    longestStr = input.substring(low, high + 1);
                }

                max = Math.max(max, uniqueChars.size());
                uniqueChars.remove(input.charAt(low));
                low++;
            }
        }
        System.out.println(longestStr);
        return max;
    }
}
