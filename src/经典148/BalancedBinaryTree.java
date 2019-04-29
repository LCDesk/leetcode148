package 经典148;


public class BalancedBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class ReturnType {
        int height;
        boolean isBalance;

        public ReturnType(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalance;
    }

    private ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, true);
        }
        ReturnType left = process(root.left);
        ReturnType right = process(root.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBanlanced = left.isBalance && right.isBalance && (Math.abs(left.height - right.height) <= 1);
        return new ReturnType(height, isBanlanced);
    }


}
