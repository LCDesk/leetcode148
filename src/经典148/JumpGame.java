package 经典148;

public class JumpGame {
    //leetcode 385ms
    @Deprecated
    public boolean canJump1(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] && (i + nums[i] < dp.length && !dp[i + nums[i]] || !dp[dp.length - 1])) {
                for (int j = 1; i + j < dp.length && j <= nums[i]; j++) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }

    //能否跳到最后
    //从后往前遍历
    public boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
        }
        return n == 1;
    }

    //跳到最后最小的步数
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int maxReach = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int j = 1; i + j < dp.length && j <= nums[i]; j++) {
                if (i + j <= maxReach) {
                    continue;
                }
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                maxReach = i + j;
                if (maxReach == dp.length - 1) {
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }


    public static void main(String[] args) {


    }

}
