package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/*
In order to improve customer experience, Amazon has developed a system to provide recommendations to the customer regarding the item they can purchase.
Based on historical customer purchase information, an item association can be defined as - If an item A is ordered by a customer,
then item B is also likely to be ordered by the same customer
(e.g. Book 1 is frequently orderered with Book 2).
All items that are linked together by an item association can be considered to be in the same group.
An item without any association to any other item can be considered to be in its own item association group of size 1.

Given a list of item association relationships(i.e. group of items likely to be ordered together),
write an algorithm that outputs the largest item association group.
If two groups have the same number of items then select the group which contains the item that appears first in lexicographic order.
*/
public class LargestAssociation {

    public static void main(String[] args) {
        System.out.println(largestItemAssociation(Arrays.asList(
                // new PairString("1", "2"), new PairString("3", "4"),
                // new PairString("4", "5"), new PairString("6", "7"), new PairString("7", "8"),
                // , new PairString("8", "9")
                new PairString("Item1", "Item2"), new PairString("Item2", "Item8"), new PairString("Item2", "Item10"),
                new PairString("Item10", "Item12"), new PairString("Item10", "Item4"),
                new PairString("Item10", "Item3"), new PairString("Item3", "Item4"),
                new PairString("Item4", "Item5"))));
    }

    private static List<String> largestItemAssociation(List<PairString> asList) {
        Map<String, LinkedHashSet<String>> graph = new LinkedHashMap<>();

        for (PairString pairString : asList) {
            graph.computeIfAbsent(pairString.first, k -> new LinkedHashSet<String>()).add(pairString.second);
            graph.computeIfAbsent(pairString.second, k -> new LinkedHashSet<String>()).add(pairString.first);

        }

        List<LinkedHashSet<String>> resultList = new ArrayList<LinkedHashSet<String>>();
        HashSet<String> visited = new HashSet<String>();
        for (String node : graph.keySet()) {
            LinkedHashSet<String> connectedNodes = new LinkedHashSet<>();
            dfs(node, graph, connectedNodes, visited);
            if (connectedNodes.size() > 0)
                resultList.add(connectedNodes);
        }

        Collections.sort(resultList, (entry1, entry2) -> {
            if (entry1.size() == entry2.size()) {
                return (entry1.iterator().next().compareTo(entry2.iterator().next()));
            }
            return entry1.size() < entry2.size() ? 1 : -1;
        });

        return new ArrayList<>(resultList.get(0));
    }

    private static void dfs(String node, Map<String, LinkedHashSet<String>> graph, LinkedHashSet<String> connectedNodes,
            HashSet<String> visited) {

        if (visited.add(node)) {
            connectedNodes.add(node);
            for (String adjNode : graph.get(node)) {
                if (!visited.contains(adjNode))
                    dfs(adjNode, graph, connectedNodes, visited);
            }
        }
    }
}
