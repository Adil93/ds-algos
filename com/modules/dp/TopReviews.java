package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopReviews {

    public static void main(String[] args) {
        System.out.println(TopNumCompetitors(6, 2,
                Arrays.asList("newshop", "shopnow", "afashion", "fashionbeats", "mymarket", "tcellular"),

                6,
                Arrays.asList("newshop is providing good services in the city; everyone should use newshop",
                        "best services by newshop", "fashionbeats has great services in the city",
                        "I am proud to have fashionbeats", "mymarket has awesome services",
                        "Thanks Newshop for the quick delivery")));
    }

    public static List<String> TopNumCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors,
            int numReviews, List<String> reviews) {

        Map<String, Integer> reviewCountMap = new HashMap<>();

        for (String competitor : competitors) {
            competitor.split(" ", 2);
            for (String review : reviews) {
                if (review.toLowerCase().contains(competitor.toLowerCase())) {
                    reviewCountMap.computeIfPresent(competitor.toLowerCase(), (k, oldVal) -> oldVal + 1);
                    reviewCountMap.computeIfAbsent(competitor.toLowerCase(), k -> 1);
                }
            }
        }

        if (topNCompetitors >= reviewCountMap.size()) {
            return sortLexiographically(new ArrayList<String>(reviewCountMap.keySet()));
        }

        List<Map.Entry<String, Integer>> mapList = new ArrayList<Map.Entry<String, Integer>>(reviewCountMap.entrySet());

        return sortByValueAndLexioGraphically(mapList).subList(0, topNCompetitors).stream().map(entry -> entry.getKey())
                .toList();

    }

    private static List<String> sortLexiographically(List<String> competitors) {
        Collections.sort(competitors, (comp1, comp2) -> comp1.compareTo(comp2));
        return competitors;
    }

    private static List<Map.Entry<String, Integer>> sortByValueAndLexioGraphically(
            List<Map.Entry<String, Integer>> mapList) {
        Collections.sort(mapList, (entry1, entry2) -> {
            if (entry1.getValue() == entry2.getValue()) {
                return (entry1.getKey().compareTo(entry2.getKey()));
            }
            return entry2.getValue().compareTo(entry1.getValue());
        });

        return mapList;
    }
}
