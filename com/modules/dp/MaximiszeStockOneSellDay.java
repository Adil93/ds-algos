package dp;

import java.util.Arrays;
import java.util.List;

public class MaximiszeStockOneSellDay {
    public static void main(String[] args) {
        // List<Integer> stockList = Arrays.asList(1, 30, 5, 8, 20, 15);
        // List<Integer> stockList = Arrays.asList(7, 1, 5, 3, 6, 4);
        List<Integer> stockList = Arrays.asList(2, 1, 2, 0, 1);
        // List<Integer> stockList = Arrays.asList(100, 180, 260, 310, 40, 535, 695);
        long maxProfit = getMaximumProfit(stockList);
        System.out.println(maxProfit);
    }

    public static long getMaximumProfit(List<Integer> prices) {

        int days = prices.size();
        long maxProfit = 0;
        int i = 0;
        if (days == 1) {
            return 0;
        }

        while (i < days - 1) {
            int localMin = 0;
            int localMax = 0;

            while ((i < days - 1) && prices.get(i) >= prices.get(i + 1)) {
                i++;
            }

            localMin = prices.get(i++);

            if (i == days)
                break;

            while (i < days && prices.get(i) >= prices.get(i - 1)) {
                i++;
            }

            localMax = prices.get(i - 1);
            maxProfit += (localMax - localMin);
        }

        return maxProfit;

    }

}
