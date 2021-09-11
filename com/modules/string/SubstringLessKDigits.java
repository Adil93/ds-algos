package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringLessKDigits {

    public static void main(String[] args) {
        System.out.println(subStringsLessKDist("awaglkhjkllop", 4));
    }

    public static List<String> subStringsLessKDist(String inputstring, int k) {
        List<String> result = new ArrayList<>();
        if (inputstring == null)
            return result;

        int len = inputstring.length();

        if (len == 0)
            return result;

        for (int i = 0; i <= len - k; i++) {
            String subStr = inputstring.substring(i, i + k);
            if (hasMentionedCriteria(subStr, k))
                result.add(subStr);
        }

        return result;
    }

    private static boolean hasMentionedCriteria(String str, int k) {
        Set<Character> countSet = new HashSet<Character>();

        for (int i = 0; i < str.length(); i++) {
            countSet.add(str.charAt(i));
        }

        if (countSet.size() == k - 1)
            return true;
        else
            return false;
    }
}
