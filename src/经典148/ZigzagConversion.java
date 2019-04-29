package 经典148;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (((i / (numRows - 1)) & 1) == 0) {
                sb[index++].append(s.charAt(i));
            } else {
                sb[index--].append(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : sb) {
            res.append(builder);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion z = new ZigzagConversion();
        System.out.println(z.convert("LEETCODEISHIRING", 4));

    }
}
