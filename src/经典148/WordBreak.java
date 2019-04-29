package 经典148;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    Set<String> set = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if ("".equals(s) || set.contains(s)) {
            return true;
        }

        boolean flag = false;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                set.add(word);
                flag = flag | wordBreak(s.substring(word.length()), wordDict);
                if (flag) {
                    return flag;
                }
            }
        }
        return false;
    }
}
