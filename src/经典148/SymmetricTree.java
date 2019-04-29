package 经典148;

public class SymmetricTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }
        if (root == null) {
            return true;
        }
        return process(root.left, root.right);
    }

    private boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && process(left.left, right.right) && process(left.right, right.left);
    }


}
