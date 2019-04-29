package 经典148;

public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return isNumber(s.charAt(0));
        }
        int i = 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            i = 1;
        }
        while (i < s.length()) {
            if (i == 0 && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
                return false;
            }
            if (i == 1 && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
                if (!isNumber(s.charAt(i - 1)) || s.charAt(i - 1) != '.') {
                    return false;
                }
            }
            if (s.charAt(i) == '.') {
                return afterDot(s, i + 1);
            }
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                return afterE(s, i + 1);
            }
            if (!isNumber(s.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isNumber(Character ch) {
        return ch >= '0' && ch <= '9';

    }


    private boolean afterDot(String s, int i) {
        if (i == s.length()) {
            if (i - 2 >= 0 && isNumber(s.charAt(i - 2))) {
                return true;
            }
            return false;
        }
        for (int j = i; j < s.length(); j++) {

            if (s.charAt(j) == 'e' || s.charAt(j) == 'E') {
                if (j == i) {
                    return false;
                }
                return afterE(s, j + 1);
            }
            if (!isNumber(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }


    private boolean afterE(String s, int i) {
        if (i == s.length()) {
            return false;
        }
        if (s.charAt(i) == '-') {
            if (i + 1 == s.length()) {
                return false;
            }
            i++;
        }
        for (int j = i; j < s.length(); j++) {
            if (!isNumber(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidNumber v = new ValidNumber();
        System.out.println(v.isNumber("46.e3"));


    }
}
