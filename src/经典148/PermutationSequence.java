package 经典148;

import java.util.HashSet;
import java.util.Set;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int num = factor(n);
            for (int i = 1; i <= 9; i++) {
                if (!set.contains(i)) {
                    if (num >= k) {
                        set.add(i);
                        sb.append(i);
                        break;
                    }
                    k -= num;
                }
            }
        }
        return sb.toString();
    }

    private int factor(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        PermutationSequence p = new PermutationSequence();
        System.out.println(p.getPermutation(4, 9));
    }
}
