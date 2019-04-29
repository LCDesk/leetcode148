package 经典148;

public class DecodeWays {


    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        //对于字符串问题，最好使用dp[i]表示0~i-1上的问题,这样dp[0]就可以表示空字符串
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) > '0' && s.charAt(i - 1) <= '9') {
                dp[i] += dp[i - 1];
            }
            if (Integer.valueOf(s.substring(i - 2, i)) >= 10 && Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings("226"));
    }


}
