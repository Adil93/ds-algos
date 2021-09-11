
package dp;

public class MaximiseStockWithKtransacions {
    public static void main(String[] args) {
        // List<Integer> stockList = Arrays.asList(1, 30, 5, 8, 20, 15);
        // List<Integer> stockList = Arrays.asList(7, 1, 5, 3, 6, 4);
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        // List<Integer> stockList = Arrays.asList(100, 180, 260, 310, 40, 535, 695);
        int k = 2;
        int maxProfit = getMaximumProfit(prices, k);
        System.out.println(maxProfit);
    }

    private static int getMaximumProfit(int[] prices, int k) {
        int days = prices.length;

        if (days == 1 || days == 0) {
            return 0;
        }

        int[][] profit = new int[k + 1][days];

        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;

        for (int j = 0; j < days; j++)
            profit[0][j] = 0;

        for (int t = 1; t <= k; t++) {
            int maxSoFar = Integer.MIN_VALUE;
            for (int d = 1; d < days; d++) {
                maxSoFar = Math.max(maxSoFar, profit[t - 1][d - 1] - prices[d - 1]);
                profit[t][d] = Math.max(profit[t][d - 1], maxSoFar + prices[d]);
            }
        }

        return profit[k][days - 1];
    }
}
