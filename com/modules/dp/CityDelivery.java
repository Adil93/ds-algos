package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

class GraphNode {
    int node;
    int distanceFromComapny;

    GraphNode(int node, int distanceFromComapny) {
        this.node = node;
        this.distanceFromComapny = distanceFromComapny;
    }
}

class Result {

    /*
     * Complete the 'order' function below.
     *
     * The function is expected to return an INTEGER_ARRAY. The function accepts
     * following parameters: 1. UNWEIGHTED_INTEGER_GRAPH city 2. INTEGER company
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes. 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */

    public static List<Integer> order(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {

        List<Integer> result = new ArrayList<Integer>();
        int numRoads = cityFrom.size();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < numRoads; i++) {

            if (!map.containsKey(cityFrom.get(i))) {
                map.put(cityFrom.get(i), new ArrayList<Integer>(Arrays.asList(cityTo.get(i))));
            } else {

                map.get(cityFrom.get(i)).add(cityTo.get(i));
            }

            if (!map.containsKey(cityTo.get(i))) {
                map.put(cityTo.get(i), new ArrayList<Integer>(Arrays.asList(cityFrom.get(i))));
            } else {
                map.get(cityTo.get(i)).add(cityFrom.get(i));
            }
        }

        Set<Integer> visited = new HashSet<Integer>();

        Collections.sort(map.get(company));
        result.addAll(map.get(company));

        visited.add(company);
        visited.addAll(map.get(company));

        LinkedList<GraphNode> list = new LinkedList<GraphNode>();

        int currentDistance = 2;
        list.addAll(getGraphList(map.get(company), 1));

        List<Integer> tempResult = new ArrayList<Integer>();
        while (!list.isEmpty()) {

            GraphNode pop = list.poll();
            List<Integer> popList = removeVisited(map.get(pop.node), visited);
            visited.addAll(popList);
            List<GraphNode> popNodes = getGraphList(popList, pop.distanceFromComapny + 1);

            if (!(currentDistance == pop.distanceFromComapny + 1)) {
                Collections.sort(tempResult);
                result.addAll(tempResult);
                tempResult.clear();
                currentDistance = pop.distanceFromComapny + 1;
            }

            tempResult.addAll(popList);
            list.addAll(popNodes);
        }
        return result;

    }

    private static List<GraphNode> getGraphList(List<Integer> list, int distanceFromComapny) {
        List<GraphNode> graphNodes = new ArrayList<GraphNode>();
        for (Integer elem : list) {
            GraphNode node = new GraphNode(elem, distanceFromComapny);
            graphNodes.add(node);
        }
        return graphNodes;
    }

    private static List<Integer> removeVisited(List<Integer> list, Set<Integer> visited) {
        List<Integer> removedList = new ArrayList<Integer>();

        for (Integer elem : list) {
            if (!visited.contains(elem))
                removedList.add(elem);
        }
        return removedList;
    }
}

public class CityDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] cityNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int cityNodes = Integer.parseInt(cityNodesEdges[0]);
        int cityEdges = Integer.parseInt(cityNodesEdges[1]);

        List<Integer> cityFrom = new ArrayList<>();
        List<Integer> cityTo = new ArrayList<>();

        IntStream.range(0, cityEdges).forEach(i -> {
            try {
                String[] cityFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                cityFrom.add(Integer.parseInt(cityFromTo[0]));
                cityTo.add(Integer.parseInt(cityFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int company = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.order(cityNodes, cityFrom, cityTo, company);

        System.out.println("Result Nodes");
        for (Integer res : result) {
            System.out.println(res);
        }

        bufferedReader.close();

    }
}

/*
 * Sample test cases
 * 
 * 1 =>
 *
 * 5 5 1 2 1 5 1 3 2 4 3 5 1
 *
 *
 * 2 =>
 *
 * 3 1 1 2 2
 *
 *
 *
 * 3 =>
 *
 * 5 8 1 2 1 5 2 4 3 5 3 8 8 6 2 7 2 9 1
 */
