package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestItem {

    public static void main(String[] args) {
        System.out.println(LargestItemAssociation(Arrays.asList(new PairString("1", "2"), new PairString("3", "4"),
                new PairString("4", "5"), new PairString("6", "7"), new PairString("7", "8")

        )));

        // new PairString("Item1", "Item2"), new PairString("Item2", "Item8"), new
        // PairString("Item2", "Item10"),
        // new PairString("Item10", "Item12"), new PairString("Item10", "Item4"),
        // new PairString("Item10", "Item3"), new PairString("Item3", "Item4"),
        // new PairString("Item4", "Item5"))));
    }

    static List<String> LargestItemAssociation(List<PairString> itemAssociation) {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();

        for (PairString pairString : itemAssociation) {

            if (map.containsKey(pairString.first)) {
                map.get(pairString.first).add(pairString.second);

                if (!map.containsKey(pairString.second)) {
                    map.put(pairString.second, map.get(pairString.first));
                }
            }
            if (map.containsKey(pairString.second)) {
                map.get(pairString.second).add(pairString.first);

                if (!map.containsKey(pairString.first)) {
                    map.put(pairString.first, map.get(pairString.second));
                }
            }

            if (!map.containsKey(pairString.first) && !map.containsKey(pairString.second)) {
                map.put(pairString.first, new LinkedHashSet<String>());
                map.put(pairString.second, map.get(pairString.first));
                map.get(pairString.first).add(pairString.first);
                map.get(pairString.first).add(pairString.second);
            }

        }

        Map<String, Integer> countMap = new HashMap<>();

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            countMap.put(entry.getKey(), entry.getValue().size());
        }

        List<Map.Entry<String, Integer>> mapList = new ArrayList<Map.Entry<String, Integer>>(countMap.entrySet());
        Collections.sort(mapList, (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));

        int largeCount = mapList.get(mapList.size() - 1).getValue();
        List<String> sameLengthKeys = new ArrayList<>();
        sameLengthKeys.stream().map(word -> word.toLowerCase());
        for (int i = mapList.size() - 1; i >= 0; i--) {
            if (mapList.get(i).getValue() != largeCount) {
                break;
            }
            if (mapList.get(i).getKey().equals(map.get(mapList.get(i).getKey()).iterator().next()))
                sameLengthKeys.add(mapList.get(i).getKey());

        }

        // map.get(mapList.get(0).getKey());
        // map.computeIfPresent(key, remappingFunction)

        return new ArrayList<String>(map.get(mapList.get(mapList.size() - 1).getKey()));

    }

}
