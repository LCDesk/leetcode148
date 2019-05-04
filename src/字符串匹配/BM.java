package 字符串匹配;

import com.sun.org.apache.regexp.internal.RE;

//坏字符和好后缀,假设只包含26个小写字母
public class BM {
    //生成bad char哈希表
    private void generateBC(char[] pattern, int[] BC) {
        for (int i = 0; i < BC.length; i++) {
            BC[i] = -1;
        }
        for (int i = 0; i < pattern.length; i++) {
            BC[pattern[i] - 'a'] = i;
        }
    }

    //只是用坏字符规则
    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[26];
        generateBC(b, bc);
        int[] suffix=new int[m];
        boolean[] prefix=new boolean[m];
        generateGS(b,m,suffix,prefix);
        int i = 0;
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; j--) {
                if (a[i + j] != b[j]) {
                    break;
                }
            }
            if (j == -1) {
                return i;
            }
            int x=j - bc[a[i + j] - 'a'];
            int y=0;
            if(j<m-1)
            {
                y=moveByGS(j,m,suffix,prefix);
            }
            i=i+Math.max(x,y);
        }
        return -1;
    }

    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k=m-j+1;
        if(suffix[k]!=-1)
        {
            return j-suffix[k]+1;
        }
        for (int i = j+2; i <m-1 ; i++) {
            if(prefix[m-i])
            {
                return i;
            }
        }
        return m;
    }

    // b 表示模式串，m 表示长度，suffix，prefix 数组事先申请好了
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && b[j] == b[m - j - 1]) {
                k++;
                --j;
                suffix[k] = j + 1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }


}
