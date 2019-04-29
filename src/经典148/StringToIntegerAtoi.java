package 经典148;

public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        int flag = -1;
        int i = 0;
        int res = 0;
        if ("".equals(str)) {
            return res;
        }
        if (str.charAt(0) == '-') {
            flag = 1;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        for (; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                break;
            }
            if (res != 0 && (res - Integer.MIN_VALUE / 10.0) * 10 < str.charAt(i) - '0') {
                res = Integer.MIN_VALUE;
                break;
            }

            res = res * 10 - (str.charAt(i) - '0');

        }
        if (flag == -1) {
            res = res == Integer.MIN_VALUE ? Integer.MAX_VALUE : -res;
        }
        return res;
    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        StringToIntegerAtoi s = new StringToIntegerAtoi();
        System.out.println(s.myAtoi("-6147483648"));

    }
}
