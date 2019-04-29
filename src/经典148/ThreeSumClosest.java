package 经典148;

import java.util.*;

public class ThreeSumClosest {
    //想一想两数之和怎么找的？
    //三数之和通常固定一个数然后双指针找与两个数
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        Set<ArrayList<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                }
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
