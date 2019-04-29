package 经典148;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//递归版本
public class PreOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public List<Integer> preorderTraversal1(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            List<Integer> left = preorderTraversal1(root.left);
            List<Integer> right = preorderTraversal1(root.right);
            list.addAll(left);
            list.addAll(right);
            return list;
        }

        //非递归版本
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return list;
        }
    }


}
