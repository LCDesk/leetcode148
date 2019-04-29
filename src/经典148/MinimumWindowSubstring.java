package 经典148;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    //没有考虑到重复字符
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        int left = 0;
        int right = 0;
        String res = "";
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        while (right < s.length()) {
            while (right < s.length() && map.size() < set.size()) {
                if (set.contains(s.charAt(right))) {
                    map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                }
                right++;
            }
            while (map.size() == set.size()) {
                char ch = s.charAt(left);
                if (!map.containsKey(ch)) {
                    left++;
                    continue;
                }
                int count = map.get(ch);
                if (count == 1) {
                    res = "".equals(res) ? s.substring(left, right) : res.length() < right - left ? res : s.substring(left, right);
                    map.remove(ch);
                } else {
                    map.put(ch, count - 1);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));

    }


}
