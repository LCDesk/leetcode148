package 经典148;

public class LongestPalindromicSubstring {
    //动态规划法dp[i][j]表示i-j是否为回文
    public String longestPalindrome1(String s) {
        if ("".equals(s)) {
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = s.charAt(0) + "";
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            if (i != dp.length - 1) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (dp[i][i + 1]) {
                    res = s.substring(i, i + 2);
                }
            }
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < dp.length - i; j++) {
                dp[j][j + i] = dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
                if (dp[j][j + i]) {
                    res = i + 1 > res.length() ? s.substring(j, j + i + 1) : res;
                }
            }
        }
        return res;
    }

    //中心扩展法
    public String longestPalindrome2(String s) {
        if ("".equals(s)) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2 + 1;
            }
        }
        return s.substring(start, end);

    }

    private int expandCenter(String s, int i, int j) {
        int left = i;
        int right = j;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    //马拉车算法
    public String longestPalindrome3(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        String str = sb.toString();
        int max = 1;
        int id = 0;
        int res = 0;
        int sum = 0;
        int[] maxRight = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            if (i < max) {
                maxRight[i] = Math.min(max - i, maxRight[2 * id - i]);
            } else {
                maxRight[i] = 1;
            }
            while (i - maxRight[i] >= 0 && i + maxRight[i] < str.length() && str.charAt(i - maxRight[i]) == str.charAt(i + maxRight[i])) {
                maxRight[i]++;
            }
            if (i + maxRight[i] > max) {
                max = i + maxRight[i];
                id = i;
            }
            if (maxRight[i] > sum) {
                sum = maxRight[i];
                res = i;
            }
            if (max == str.length()) {
                break;
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = res - sum + 1; i < res + sum; i++) {
            if (str.charAt(i) != '#') {
                ret.append(str.charAt(i));
            }
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome3(""));

    }

}
