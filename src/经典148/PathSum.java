package 经典148;

import java.util.ArrayList;
import java.util.List;


public class PathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        process(root, 0, sum, new ArrayList<>());
        return res;
    }

    private void process(TreeNode node, int target, int sum, List<Integer> list) {
        list.add(node.val);
        target += node.val;
        if (node.left == null && node.right == null) {
            if (target == sum) {
                res.add(new ArrayList<>(list));
            }
        } else {
            if (node.left != null) {
                process(node.left, target, sum, list);
            }
            if (node.right != null) {
                process(node.right, target, sum, list);
            }
        }
        list.remove(list.size() - 1);
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return process(root, 0, sum);
    }

    private boolean process(TreeNode node, int target, int sum) {
        target += node.val;
        if (node.left == null && node.right == null) {
            if (target == sum) {
                return true;
            }
            return false;
        }
        boolean res = false;
        if (node.left != null) {
            res = process(node.left, target, sum) || res;
        }
        if (node.right != null) {
            res = res || process(node.right, target, sum);
        }
        return res;

    }


}
