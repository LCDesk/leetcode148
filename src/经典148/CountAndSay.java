package 经典148;

public class CountAndSay {
    //只能暴力解
    public String countAndSay(int n) {
        String res = "1";
        int start = 0;
        int end = 0;
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            while (end < res.length()) {
                while (end < res.length() && res.charAt(end) == res.charAt(start)) {
                    end++;
                }
                sb.append((end - start)).append(res.charAt(start));
                start = end;
            }
            res = sb.toString();

            start = 0;
            end = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        System.out.println(cs.countAndSay(5));
    }


}
