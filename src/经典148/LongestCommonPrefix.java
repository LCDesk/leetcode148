package 经典148;

class Trie {
    Trie[] next;
    int count;

    public Trie() {
        this.next = new Trie[26];
        this.count = 1;
    }
}


public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Trie head = new Trie();
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            Trie cur = head;
            for (int i = 0; i < s.length(); i++) {
                if (cur.next[s.charAt(i) - 'a'] == null) {
                    cur.next[s.charAt(i) - 'a'] = new Trie();
                } else {
                    cur.next[s.charAt(i) - 'a'].count++;
                }
                cur = cur.next[s.charAt(i) - 'a'];
            }
        }
        while (head != null) {
            Trie temp = null;
            for (int i = 0; i < head.next.length; i++) {
                if (head.next[i] != null) {
                    if (head.next[i].count == strs.length) {
                        sb.append((char) (i + 'a'));
                        temp = head.next[i];
                    }
                    break;
                }
            }
            head = temp;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        l.longestCommonPrefix(new String[]{"dog", "flow", "flight"});

    }
}
