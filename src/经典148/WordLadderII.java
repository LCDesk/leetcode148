package 经典148;

import java.util.*;

//最短路径问题,狄杰斯特拉算法
public class WordLadderII {
    int res = Integer.MAX_VALUE;


    //版本超时，方法是DFS
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        process(beginWord, endWord, set, wordList, 1);
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    private void process(String word, String endword, Set<String> set, List<String> wordList, int count) {
        if (word.equals(endword)) {
            res = Math.min(res, count);
            return;
        }
        for (String s : wordList) {
            if (set.contains(s)) {
                continue;
            }
            if (canTransform(s, word)) {
                set.add(s);
                process(s, endword, set, wordList, count + 1);
                set.remove(s);
            }
        }

    }


    private boolean canTransform(String str, String target) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != target.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }


    //换用DFS解决最短长度问题
    public int ladderLength(String beginWord, String endWord, HashSet<String> wordList) {
        int res = 1;
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int size = 0;
        String str = "";
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size-- > 0) {
                str = queue.poll();
                if (str.equals(endWord)) {
                    return res;
                }
                Iterator<String> it = wordList.iterator();
                for (; it.hasNext(); ) {
                    String s = it.next();
                    if (canTransform(s, str)) {
                        queue.offer(s);
                        it.remove();
                    }
                }
            }
            res++;
        }
        return 0;

    }


}
