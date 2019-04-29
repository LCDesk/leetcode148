package 经典148;

public class ImplementStrstr {
    //利用了substring
    public String strStr1(String haystack, String needle) {
        if ("".equals(needle.trim())) {
            return haystack;
        }
        int len = needle.length();
        for (int i = 0; i <= haystack.length() - len; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + len).equals(needle)) {
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }

    //KMP算法，判断一个字符串是不是另一个字符串子串
    private int[] getNext(String ps) {
        int[] next = new int[ps.length()];
        next[0] = -1;
        int k = -1;
        int i = 0;
        while (i < ps.length() - 1) {
            if (k == -1 || ps.charAt(i) == ps.charAt(k)) {
                next[++i] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    //不移动i，只移动j，这样就不会出现回头的情况，只有一边扫描
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int[] next = getNext(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrstr i = new ImplementStrstr();
        i.strStr("aaa", "aaa");
    }

}
