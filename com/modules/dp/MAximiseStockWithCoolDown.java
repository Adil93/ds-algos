package dp;

public class MAximiseStockWithCoolDown {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 1)
            return 0;
        int[] sa = new int[n];
        int[] sb = new int[n];
        int[] sc = new int[n];
        sa[0] = 0;
        sb[0] = -prices[0];
        sc[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; ++i) {
            sa[i] = Math.max(sa[i - 1], sc[i - 1]);
            sb[i] = Math.max(sb[i - 1], sa[i - 1] - prices[i]);
            sc[i] = sb[i - 1] + prices[i];
        }
        return Math.max(sa[n - 1], sc[n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 0, 2 };
        int ans = maxProfit(arr);
        System.out.println(ans);
    }
}
