package 经典148;

public class Sqrtx {
    //利用牛顿迭代法
    public int mySqrt(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Sqrtx s = new Sqrtx();
        System.out.println(s.mySqrt(8));
    }
}
