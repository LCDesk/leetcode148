package 经典148;

import java.util.*;



public class PostOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //递归版本
    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = postorderTraversal1(root.left);
        List<Integer> right = postorderTraversal1(root.right);
        left.addAll(right);
        left.add(root.val);
        return left;
    }

    //非递归版本,取巧的写法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            list.add(node.val);
        }
        Collections.reverse(list);
        return list;
    }


}
