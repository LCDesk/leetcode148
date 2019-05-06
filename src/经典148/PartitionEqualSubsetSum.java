package 经典148;

//01背包问题
public class PartitionEqualSubsetSum {
    //回溯算法
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return process(nums, 0, sum / 2);

    }

    private boolean process(int[] nums, int i, int target) {
        if (target == 0) {
            return true;
        }
        if (i == nums.length || target < 0) {
            return false;
        }
        return process(nums, i + 1, target) || process(nums, i + 1, target - nums[i]);
    }

    //动态规划
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = dp.length - 1; i >= 0; i--) {
                if (dp[i] && i + num < dp.length) {
                    dp[i + num] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartition(new int[]{1, 5, 11, 5}));
    }
}
