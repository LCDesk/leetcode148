package 经典148;

public class PowxN {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        if (n < 0 && n != Integer.MIN_VALUE) {
            x = 1 / x;
            n = -n;
        }
        double half = pow(x, n / 2);
        return (n & 1) == 0 ? half * half : half * half * x;
    }

    public static void main(String[] args) {
        PowxN p = new PowxN();
        p.pow(2, Integer.MIN_VALUE);
    }
}
