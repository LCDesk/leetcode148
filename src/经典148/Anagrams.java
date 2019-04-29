package 经典148;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = reP(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }

    private String reP(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    sb.append(i + 'a');
                }
            }
        }
        return sb.toString();
    }


}
