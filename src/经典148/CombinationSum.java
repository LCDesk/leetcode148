package 经典148;

import java.util.*;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    //无重复元素,每个数字可以重复使用
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        process(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void process(int[] candidates, int target, List<Integer> list, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (target - candidates[i] >= 0) {
                    list.add(candidates[i]);
                    process(candidates, target - candidates[i], list, i);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    Set<ArrayList<Integer>> set = new HashSet<>();

    //有重复元素，每个数字只能使用一次
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        process2(candidates, target, new ArrayList<>(), 0);
        return new ArrayList<>(set);
    }

    private void process2(int[] candidates, int target, List<Integer> list, int start) {
        if (target == 0) {
            set.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[start]) {
                    continue;
                }
                if (target - candidates[i] >= 0) {
                    list.add(candidates[i]);
                    process2(candidates, target - candidates[i], list, i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        c.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    }

}
