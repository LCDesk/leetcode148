package 经典148;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /**
     * dp[j] 0-j之间被拆分成回文子串的最小分割数
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i;
            if (dp[i] != 0) {
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome(s.substring(j, i + 1))) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


    ArrayList<ArrayList<String>> res = new ArrayList<>();

    //返回所有可被分割成回文串的结果
    public ArrayList<ArrayList<String>> partition(String s) {
        process(s, 0, new ArrayList<>());
        return res;
    }

    private void process(String s, int start, List<String> list) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                list.add(str);
                process(s, i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        System.out.println(p.partition("aab"));

    }

}
