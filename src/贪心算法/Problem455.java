package 贪心算法;

import java.util.Arrays;

public class Problem455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIdx = 0;
        int sIdx = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (s[sIdx] >= g[gIdx]) {
                sIdx++;
                gIdx++;
            } else {
                sIdx++;
            }
        }
        return gIdx;
    }
}
