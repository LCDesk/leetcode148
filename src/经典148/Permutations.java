package 经典148;

import java.util.*;

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    //没有重复值的全排列
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        process(nums, 0, new ArrayList<>());
        return res;
    }

    private void process(int[] nums, int count, List<Integer> list) {
        if (count == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited.contains(i) || (i > 0 && !visited.contains(i - 1) && nums[i - 1] == nums[i])) {
                    continue;
                }
                visited.add(i);
                list.add(nums[i]);
                process(nums, count + 1, list);
                list.remove(list.size() - 1);
                visited.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();

        p.permuteUnique(new int[]{1, 1, 2});
    }
}

