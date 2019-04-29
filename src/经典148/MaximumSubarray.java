package 经典148;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}
