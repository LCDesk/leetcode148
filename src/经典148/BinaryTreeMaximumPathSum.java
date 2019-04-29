package 经典148;


public class BinaryTreeMaximumPathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class ReturnType {
        int maxRoot;
        int maxSide;
        int max = 0;

        public ReturnType(int maxRoot, int maxSide, int max) {
            this.maxRoot = maxRoot;
            this.maxSide = maxSide;
            this.max = max;
        }
    }

    public int maxPathSum(TreeNode root) {

        return process(root).max;
    }

    private ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, 0, Integer.MIN_VALUE);
        }
        ReturnType left = process(root.left);
        ReturnType right = process(root.right);
        int maxRoot = left.maxSide + right.maxSide + root.val;
        int maxSide = root.val;
        maxSide = Math.max(maxSide, Math.max(left.maxSide + root.val, right.maxSide + root.val));
        int max = Math.max(left.max, right.max);
        max = Math.max(max, Math.max(maxRoot, maxSide));
        return new ReturnType(maxRoot, maxSide, max);
    }


}
