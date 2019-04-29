package 经典148;

public class AddBinary {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int[] sum = new int[Math.max(aLen, bLen)];
        int count = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int s = sum.length - 1;
        int temp = 0;
        while (i >= 0 && j >= 0) {
            temp = (a.charAt(i) - '0' + b.charAt(j) - '0' + count) / 2;
            sum[s--] = (a.charAt(i--) - '0' + b.charAt(j--) - '0' + count) % 2;
            count = temp;

        }
        if (i >= 0) {
            for (int k = i; k >= 0; k--) {
                temp = (a.charAt(k) - '0' + count) / 2;
                sum[s--] = (a.charAt(k) - '0' + count) % 2;
                count = temp;
            }
        }
        if (j >= 0) {
            for (int k = j; k >= 0; k--) {
                temp = (b.charAt(k) - '0' + count) / 2;
                sum[s--] = (b.charAt(k) - '0' + count) % 2;
                count = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (count == 1) {
            sb.append(1);
        }
        for (int ch : sum) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("110010"
                , "10111"));
    }

}
