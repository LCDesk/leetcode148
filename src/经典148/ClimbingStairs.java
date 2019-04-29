package 经典148;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int n1 = 1;
        int n2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = n2;
            n2 += n1;
            n1 = temp;
        }
        return n2;
    }

}
