package 双指针;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem524 {
    //原始版本
    public String findLongestWord1(String s, List<String> d) {
        if (s == null || d == null || s.length() == 0) {
            return "";
        }


        TreeSet<String> set = new TreeSet<>(((o1, o2) ->
        {
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            } else {
                return o1.compareTo(o2);
            }
        }));
        for (String s1 : d) {
            int i = 0;
            int j = 0;
            for (; i < s1.length() && j < s.length(); i++, j++) {
                while (j < s.length() && s1.charAt(i) != s.charAt(j)) {
                    j++;
                }
            }
            if (i == s1.length() && j <= s.length()) {
                set.add(s1);
            }
        }
        return set.size() == 0 ? "" : set.first();
    }

    //版本二
    public String findLongestWord(String s, List<String> d) {
        String res = "";

        for (String target : d) {
            //剪枝操作，将不需要比较的单词直接跳过
            if (target.length() < res.length() || (target.length() == res.length() && res.compareTo(target) < 0)) {
                continue;
            }
            if (isContain(s, target)) {
                res = target;
            }
        }
        return res;
    }


    //判断一个字符串是否包含另一个字符串,双指针
    private boolean isContain(String s, String target) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }


    public static void main(String[] args) {
        Problem524 p = new Problem524();

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //list.add("plea");
        String s = "abpcplea";
        System.out.println(p.findLongestWord(s, list));
    }

}
