package 经典148;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int index = s.lastIndexOf(" ");
        return s.substring(index + 1).length();

    }

    public static void main(String[] args) {
        System.out.println("sjh".lastIndexOf(" "));
    }
}
