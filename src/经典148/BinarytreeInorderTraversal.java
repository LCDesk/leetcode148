package 经典148;

import java.util.*;

public class BinarytreeInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归版本
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = inorderTraversal(root.left);
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    //非递归版本
    public ArrayList<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (visited.contains(node)) {
                list.add(node.val);
            } else {
                visited.add(node);
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return list;
    }
}
