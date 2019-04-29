package 双指针;

public class Problem345 {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        char[] chs = s.toCharArray();
        int left = 0;
        int right = chs.length - 1;
        while (left < right) {
            if (isVowel(chs[left]) && isVowel(chs[right])) {
                swap(chs, left, right);
                left++;
                right--;
            } else if (!isVowel(chs[left])) {
                left++;
            } else if (!isVowel(chs[right])) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return new String(chs);
    }

    private void swap(char[] chs, int i1, int i2) {
        char temp = chs[i1];
        chs[i1] = chs[i2];
        chs[i2] = temp;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
        Problem345 p = new Problem345();
        System.out.println(p.reverseVowels("aA"));
    }
}
