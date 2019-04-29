package 经典148;

public class DivideTwoIntegers {
    //利用位移方法
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int flag = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long d1 = Math.abs((long) dividend);
        long d2 = Math.abs((long) divisor);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((d1 >> i) >= d2) {
                res += 1 << i;
                d1 -= d2 << i;
            }
        }
        return flag == -1 ? -res : res;
    }

    public static void main(String[] args) {
        DivideTwoIntegers d = new DivideTwoIntegers();
        System.out.println(d.divide(100, 3));
    }


}
