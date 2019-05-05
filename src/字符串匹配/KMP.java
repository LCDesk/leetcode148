package 字符串匹配;

public class KMP {
    private int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length];
        next[0] = -1;
        int k = -1;
        int i = 1;
        while (i < pattern.length) {
            if (k == -1 || pattern[k] == pattern[i - 1]) {
                next[i++] = ++k;

            } else {
                k = next[k];
            }
        }
        return next;
    }

    public int strCompare(char[] main, int n, char[] pattern, int m) {
        int[] next = getNext(pattern);
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (j == -1 || main[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == m) {
            return i - m;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        KMP k = new KMP();
        String main = "abccd";
        String pattern = "ccd";
        System.out.println(k.strCompare(main.toCharArray(), main.length(), pattern.toCharArray(), pattern.length()));

    }


}
