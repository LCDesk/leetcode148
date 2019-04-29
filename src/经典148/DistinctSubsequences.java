package 经典148;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubsequences {

    /**
     * 策略最重要 dp[i][j] [0,j-1]在[0,i-1]中出现的次数
     * 找到一个字符串在另一个字符串中出现的次数
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        //因为i<j的时候可以直接忽略掉
        for (int j = 1; j < dp[0].length; j++) {
            for (int i = j; i < dp.length; i++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j - 1] + dp[i - 1][j] : dp[i - 1][j];
            }
        }
        return dp[s.length()][t.length()];
    }

    /**
     * 找到一个字符串的子序列的个数
     * 策略:以某个字符结尾的个数
     *
     * @param S
     * @return
     */
    public int distinctSubseqII(String S) {
        long[] dp = new long[26];
        for (int i = 0; i < S.length(); i++) {
            dp[S.charAt(i) - 97] = sum(dp) + 1;
        }
        return (int) (sum(dp) % (Math.pow(10, 9) + 7));

    }

    private long sum(long[] arr) {
        int sum = 0;
        for (long i : arr) {
            sum += i;
        }
        return sum;
    }

}
