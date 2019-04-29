package 双指针;

public class Problem680 {

    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int left = -1;
        int right = s.length();
        while (++left <= --right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            }
        }
        return true;

    }

    private boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Problem680 p = new Problem680();
        System.out.println(p.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

}
