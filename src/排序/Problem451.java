package 排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character>[] list = new ArrayList[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (list[entry.getValue()] == null) {
                list[entry.getValue()] = new ArrayList<>();
            }
            list[entry.getValue()].add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == null) {
                continue;
            }
            for (Character character : list[i]) {
                sb.append(mulStr(character, i));
            }
        }
        return sb.toString();
    }

    private String mulStr(char ch, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
