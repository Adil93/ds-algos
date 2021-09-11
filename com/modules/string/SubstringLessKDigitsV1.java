package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubstringLessKDigitsV1 {

    public static void main(String[] args) {
        System.out.println(subStringsLessKDist("awaglkhjkllop", 4));
    }

    public static List<String> subStringsLessKDist(String input, int k) {

        if (input == null || input.length() == 0)
            return new ArrayList<>();
        Set<String> result = new HashSet<>();

        Map<Character, Integer> countMap = new HashMap<Character, Integer>();

        for (int i = 0; i < k; i++) {
            countMap.put(input.charAt(i), countMap.getOrDefault(input.charAt(i), 0) + 1);
        }

        if (countMap.size() == k - 1) {
            result.add(input.substring(0, k));
        }

        for (int i = k; i < input.length(); i++) {
            countMap.put(input.charAt(i - k), countMap.get(input.charAt(i - k)) - 1);

            if (countMap.get(input.charAt(i - k)) == 0) {
                countMap.remove(input.charAt(i - k));
            }

            countMap.put(input.charAt(i), countMap.getOrDefault(input.charAt(i), 0) + 1);

            if (countMap.size() == k - 1) {
                result.add(input.substring(i - k + 1, i + 1));
            }

        }
        return new ArrayList<String>(result);
    }
}
