package 贪心算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem763 {
    public List<Integer> partitionLabels(String S) {
        if (S.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        for (int i = 0; i < S.length(); ) {
            int start = i;
            int end = map.get(S.charAt(i));
            while (++i <= end) {
                if (map.get(S.charAt(i)) > end) {
                    end = map.get(S.charAt(i));
                }
            }
            list.add(end - start + 1);
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "caedbdedda";
        Problem763 p = new Problem763();
        p.partitionLabels(s);
    }


}
