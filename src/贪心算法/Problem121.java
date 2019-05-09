package 贪心算法;

public class Problem121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[pre]) {
                pre = i;
            } else {
                max = Math.max(max, prices[i] - prices[pre]);
            }
        }
        return max;
    }
}
