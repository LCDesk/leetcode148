package 经典148;


public class ValidateBinarySearchTree {

    class ReturnType {
        long min;
        long max;
        boolean isBST;

        public ReturnType(long min, long max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    private ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(Long.MAX_VALUE, Long.MIN_VALUE, true);
        }
        ReturnType left = process(root.left);
        ReturnType right = process(root.right);
        boolean isBST = left.isBST & right.isBST;
        isBST &= (root.val > left.max && root.val < right.min);
        long max = Math.max(root.val, right.max);
        long min = Math.min(root.val, left.min);
        return new ReturnType(min, max, isBST);
    }
}
