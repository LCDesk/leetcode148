package 经典148;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 1;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                max = Math.max(max, right - left);
                set.remove(s.charAt(left));
                left++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}
