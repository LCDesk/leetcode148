package 经典148;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<List<Integer>> res = new ArrayList<>();

    //层次遍历
    public ArrayList<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return res;
        }
        process1(root, 0);
        Collections.reverse(res);
        return res;
    }

    private void process1(TreeNode node, int height) {
        if (node == null) {
            return;
        }
        if (res.size() <= height) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.val);
            res.add(list);
        } else {
            res.get(height).add(node.val);
        }
        process1(node.left, height + 1);
        process1(node.right, height + 1);
    }


    //zigzag方式遍历
    public ArrayList<List<Integer>> zigzagLevelOrder(TreeNode root) {
        process(root, 0);
        return res;

    }

    private void process(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (res.size() <= depth) {
            List<Integer> list = new LinkedList<>();
            list.add(node.val);
            res.add(list);
        } else {
            if ((depth & 1) == 1) {
                res.get(depth).add(0, node.val);
            } else {
                res.get(depth).add(node.val);
            }
        }
        process(node.left, depth + 1);
        process(node.right, depth + 1);
    }
}
