package 背包问题汇总;

public class ZeroOrOneBag {
    //背包无价值(略)
    //背包有价值
    public int maxValue(int[] value, int[] weight, int maxWeight) {
        int[] dp = new int[maxWeight + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }
        int max = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = dp.length - 1; j >= weight[i]; j--) {
                if (dp[j - weight[i]] != -1) {
                    dp[j] = Math.max(dp[j - weight[i]] + value[i], dp[j]);
                    max = Math.max(dp[j], max);
                }
            }
        }
        return max;
    }


}
