package 背包问题汇总;

public class CompleteBag {
    //物品可用无限
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[dp.length - 1] == amount + 1 ? -1 : dp[dp.length - 1];
    }

    public static void main(String[] args) {
        CompleteBag c = new CompleteBag();
        System.out.println(c.coinChange(new int[]{1, 2, 5}, 11));
        ;
    }

}
