package 经典148;

import java.util.List;

//三角形最短路径和
public class Triangle {
    //o(n²)的空间复杂度
    public int minimumTotal1(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = Integer.MAX_VALUE;
                if (j < i) {
                    min = Math.min(min, dp[i - 1][j]);
                }
                if (j > 0) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                dp[i][j] = min + triangle.get(i).get(j);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            res = Math.min(dp[dp.length - 1][i], res);
        }
        return res;
    }

    //o(n)的空间复杂度
    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = triangle.get(len - 1).get(i);
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

}
