package 经典148;

public class ReverseInteger {
    public int reverse(int x) {
        String str = x + "";
        int end = 0;
        int flag = -1;
        int res = 0;
        if (str.charAt(end) == '-') {
            end++;
            flag = 1;
        }
        for (int i = str.length() - 1; i >= end; i--) {
            if (res != 0 && (res - Integer.MIN_VALUE / 10.0) * 10 < str.charAt(i) - '0') {
                res = 0;
                break;
            }
            res = res * 10 - (str.charAt(i) - '0');
        }

        return flag == -1 ? -res : res;
    }

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(1463847412));

    }
}