package 经典148;

public class Candy {

    //左右两遍遍历
    public int candy(int[] ratings) {

        if (ratings.length == 1) {
            return 1;
        }
        int[] dp = new int[ratings.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i + 1] + 1, dp[i]);
            }
        }
        int res = 0;
        for (int i : dp) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        System.out.println(c.candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
    }


}
