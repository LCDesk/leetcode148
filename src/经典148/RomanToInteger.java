package 经典148;

public class RomanToInteger {

    //也可以从后往前
    public int romanToInt(String s) {
        char[] chs = s.toCharArray();
        int sum = 0;
        int pre = transForm(chs[0]);
        int start = 0;
        for (int i = 1; i < chs.length; i++) {
            if (transForm(chs[i]) > pre) {
                sum += transForm(chs[i]) - pre;
                if (i < chs.length - 1) {
                    pre = transForm(chs[i + 1]);
                    start = i + 1;
                    i++;
                }
                continue;
            }
            while (i < chs.length && transForm(chs[i]) == pre) {
                i++;
            }
            sum += (i - start) * pre;
            if (i < chs.length) {
                pre = transForm(chs[i]);
            }
            start = i;
        }
        if (start == chs.length - 1) {
            sum += transForm(chs[start]);
        }

        return sum;
    }

    private int transForm(char ch) {
        if (ch == 'I') {
            return 1;
        } else if (ch == 'V') {
            return 5;
        } else if (ch == 'X') {
            return 10;
        } else if (ch == 'L') {
            return 50;
        } else if (ch == 'C') {
            return 100;
        } else if (ch == 'D') {
            return 500;
        } else {
            return 1000;
        }
    }

    //整数转成罗马数字
    public String intToRoman(int num) {
        int M = num / 1000;
        num = num % 1000;
        int CM = 0;
        if (num >= 900) {
            CM = 1;
            num -= 900;
        }
        int D = num / 500;
        num = num % 500;
        int CD = 0;
        if (num >= 400) {
            CD = 1;
            num -= 400;
        }
        int C = num / 100;
        num = num % 100;
        int XC = 0;
        if (num >= 90) {
            XC = 1;
            num -= 90;
        }
        int L = num / 50;
        num = num % 50;
        int XL = 0;
        if (num >= 40) {
            XL = 1;
            num -= 40;
        }
        int X = num / 10;
        num = num % 10;
        int IX = 0;
        if (num >= 9) {
            IX = 1;
            num -= 9;
        }
        int V = num / 5;
        num = num % 5;
        int IV = 0;
        if (num >= 4) {
            IV = 1;
            num -= 4;
        }
        int I = num;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append("M");
        }
        for (int i = 0; i < CM; i++) {
            sb.append("CM");
        }
        for (int i = 0; i < D; i++) {
            sb.append("D");
        }
        for (int i = 0; i < CD; i++) {
            sb.append("CD");
        }
        for (int i = 0; i < C; i++) {
            sb.append("C");
        }
        for (int i = 0; i < XC; i++) {
            sb.append("XC");
        }
        for (int i = 0; i < L; i++) {
            sb.append("L");
        }
        for (int i = 0; i < XL; i++) {
            sb.append("XL");
        }
        for (int i = 0; i < X; i++) {
            sb.append("X");
        }
        for (int i = 0; i < IX; i++) {
            sb.append("IX");
        }
        for (int i = 0; i < V; i++) {
            sb.append("V");
        }
        for (int i = 0; i < IV; i++) {
            sb.append("IV");
        }
        for (int i = 0; i < I; i++) {
            sb.append("I");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        System.out.println(r.intToRoman(58));
    }
}
