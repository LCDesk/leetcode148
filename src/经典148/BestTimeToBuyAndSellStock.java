package 经典148;

public class BestTimeToBuyAndSellStock {

    //最多买卖两次的最大利润
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int sold = prices[prices.length - 1];
        int buy = prices[0];
        int res = 0;
        int[] before = new int[prices.length];
        int[] after = new int[prices.length];

        //在i天之前出售获得的最大利润
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
                continue;
            }
            before[i] = prices[i] - buy;
        }
        int max = 0;

        //在i天之后出售获得的最大利润
        for (int j = prices.length - 2; j >= 0; j--) {
            if (sold - prices[j] > max) {
                max = sold - prices[j];
            }
            after[j] = max;
            if (prices[j] > sold) {
                sold = prices[j];
                continue;
            }
        }
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, after[i] + before[i]);
        }
        return res;
    }

    //可以买卖任意次
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        }
        return dp[dp.length - 1];
    }

    //只允许买卖一次
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                max = Math.max(max, prices[i] - buy);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        b.maxProfit2(new int[]{3, 3, 5, 0, 0, 3, 1, 4});


    }


}
