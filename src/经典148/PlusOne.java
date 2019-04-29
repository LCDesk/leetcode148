package 经典148;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int count = 1;
        int temp = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            temp = (digits[i] + count) / 10;
            digits[i] = (digits[i] + count) % 10;
            count = temp;
        }
        if (count == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {

    }
}
