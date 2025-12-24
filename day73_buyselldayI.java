public class day73_buyselldayI {
    public static int BuySellDayI(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for(int i=1; i<prices.length; i++) {
            int curr = prices[i] - min;
            profit = Math.max(profit, curr);
            min    = Math.min(min, prices[i]);
        }

        return profit;
    }
}
