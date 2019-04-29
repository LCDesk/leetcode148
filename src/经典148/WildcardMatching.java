package 经典148;

public class WildcardMatching {
    //超出时间限制
    public boolean isMatch1(String s, String p) {
        StringBuilder sb = new StringBuilder();
        if (p.length() > 0) {
            sb.append(p.charAt(0));
            for (int i = 1; i < p.length(); i++) {
                if (p.charAt(i) == '*' && sb.charAt(sb.length() - 1) == '*') {
                    continue;
                }
                sb.append(p.charAt(i));
            }
        }
        return process(s, 0, sb.toString(), 0);
    }

    public boolean process(String s, int sIndex, String p, int pIndex) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        boolean res = false;
        if (p.charAt(pIndex) == '?') {
            res = process(s, sIndex + 1, p, pIndex + 1);
        } else if (p.charAt(pIndex) == '*') {
            for (int i = 0; sIndex + i <= s.length(); i++) {
                res |= process(s, sIndex + i, p, pIndex + 1);
                if (res) {
                    break;
                }
            }
        } else if (sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex)) {
            res = process(s, sIndex + 1, p, pIndex + 1);
        }
        return res;
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            dp[s.length()][i] = p.charAt(i) == '*' && dp[s.length()][i + 1];
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i][j] = dp[i + 1][j + 1];
                } else if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i + 1][j] || dp[i + 1][j + 1] || dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        WildcardMatching w = new WildcardMatching();
        System.out.println(w.isMatch("", ""));
    }
}
