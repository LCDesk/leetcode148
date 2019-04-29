package 经典148;

import java.util.*;

public class FourSum {
    Set<ArrayList<Integer>> res = new HashSet<>();

    //超过时间
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        process(nums, 0, 4, target, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void process(int[] nums, int i, int n, int target, List<Integer> list) {
        if (nums.length - i < n) {
            return;
        }
        if (n == 0) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        process(nums, i + 1, n, target, list);
        list.add(nums[i]);
        process(nums, i + 1, n - 1, target - nums[i], list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        FourSum f = new FourSum();
        f.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }
}
