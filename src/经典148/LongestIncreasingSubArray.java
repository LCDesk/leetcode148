package 经典148;

public class LongestIncreasingSubArray {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 1;
            }
        }

        return Math.max(cur, max);
    }
}
