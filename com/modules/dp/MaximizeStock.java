package dp;

import java.util.Arrays;
import java.util.List;

public class MaximizeStock {
    public static void main(String[] args) {
        List<Integer> stockList = Arrays.asList(1, 2, 100);

        long maxProfit = getMaximumProfit(stockList);
        System.out.println(maxProfit);

    }

    public static long getMaximumProfit(List<Integer> prices) {

        int days = prices.size();
        long maxProfit = 0;

        boolean[] sellingOn = getSellingOn(prices, days);

        long totalCost = 0;
        long numShares = 0;

        for (int i = 0; i < days; i++) {
            if (!sellingOn[i]) {
                totalCost += prices.get(i);
                numShares++;
            } else {
                maxProfit += (numShares * prices.get(i)) - totalCost;
                numShares = 0;
                totalCost = 0;
            }
        }
        return maxProfit;

    }

    private static boolean[] getSellingOn(List<Integer> prices, int days) {
        long localMax = Long.MIN_VALUE;
        boolean[] sellingOn = new boolean[days];
        Arrays.fill(sellingOn, false);

        for (int i = days - 1; i >= 0; i--) {
            if (localMax < prices.get(i)) {
                sellingOn[i] = true;
                localMax = prices.get(i);
            }
        }

        return sellingOn;
    }
}
