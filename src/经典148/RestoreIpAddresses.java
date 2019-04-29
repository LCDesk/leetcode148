package 经典148;

import java.util.ArrayList;

public class RestoreIpAddresses {
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> restoreIpAddresses(String s) {
        process(s, 0, 0, "");
        return res;
    }

    //深搜
    private void process(String s, int i, int count, String target) {
        if (count == 4) {
            if (i == s.length()) {

                res.add(target.substring(0, target.length() - 1));
            }
            return;
        }

        for (int j = i + 1; j <= s.length() && j <= i + 3; j++) {
            if (j != i + 1 && s.charAt(i) == '0') {
                return;
            }
            if (Integer.valueOf(s.substring(i, j)) <= 255) {
                process(s, j, count + 1, target + s.substring(i, j) + ".");
            }
        }
    }

    public static void main(String[] args) {
        String s = "010010";
        RestoreIpAddresses r = new RestoreIpAddresses();
        System.out.println(r.restoreIpAddresses(s));

    }

}
