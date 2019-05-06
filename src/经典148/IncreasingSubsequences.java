package 经典148;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    Set<List<Integer>> res = new HashSet<>();

    //回溯算法
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) {
            return new ArrayList<>();
        }
        process(nums, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void process(int[] nums, int i, List<Integer> list) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i == nums.length - 2 && list.size() == 0) {
            list.add(nums[i]);
            process(nums, i + 1, list);
            list.remove(list.size() - 1);
        } else if (i == nums.length - 1 && list.size() == 1) {
            if (nums[i] < list.get(list.size() - 1)) {
                return;
            }
            list.add(nums[i]);
            process(nums, i + 1, list);
            list.remove(list.size() - 1);
        } else {
            process(nums, i + 1, list);
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                process(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        IncreasingSubsequences i = new IncreasingSubsequences();
        System.out.println(i.findSubsequences(new int[]{4, 3, 2, 1}));
    }
}
