package 经典148;

import java.util.*;

public class Subsets {
    Set<ArrayList<Integer>> set = new HashSet<>();

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        process(nums, 0, new ArrayList<>());
        return new ArrayList<>(set);
    }

    private void process(int[] nums, int i, List<Integer> list) {
        if (i == nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }
        process(nums, i + 1, list);
        list.add(nums[i]);
        process(nums, i + 1, list);
        list.remove(list.size() - 1);
    }
}
