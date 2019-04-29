package 双指针;

public class Problem633 {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0;
        int right = (int) Math.sqrt(c);
        int sum = 0;
        while (left <= right) {
            sum = left * left + right * right;
            if (sum < c) {
                left++;
            } else if (sum > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

}
