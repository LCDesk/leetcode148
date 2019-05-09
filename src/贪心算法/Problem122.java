package 贪心算法;

public class Problem122 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int pre = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[pre]) {
                max += prices[i] - prices[pre];
            }
            pre = i;
        }
        return max;
    }
}
