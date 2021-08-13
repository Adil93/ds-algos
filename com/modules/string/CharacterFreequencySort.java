package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterFreequencySort {
    public static void main(String[] args) {

        System.out.println(freequentCharInString("aaabbccctttt", 2));
    }

    public static char freequentCharInString(String input, int k) {
        char[] inputs = input.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (Character inp : inputs) {
            if (map.containsKey(inp)) {
                map.put(inp, map.get(inp) + 1);
            } else {
                map.put(inp, 1);
            }
        }

        List<Map.Entry<Character, Integer>> mapList = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(mapList, (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));
        return mapList.get(k).getKey();

    }
}
