package 贪心算法;

public class Problem53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        for (int num : nums) {
            cur += num;
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}
