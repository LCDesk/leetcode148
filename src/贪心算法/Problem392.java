package 贪心算法;

public class Problem392 {
    //o(n*m)
    public boolean isSubsequence1(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.equals(t) || "".equals(s)) {
            return true;
        }
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Problem392 p = new Problem392();
        System.out.println(p.isSubsequence1("axc", "ahbgdc"));
    }
}
