package 经典148;


public class MaximumDepthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


    }

    public int maxDepth(TreeNode root) {
        return process(root);
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(process(root.left), process(root.right)) + 1;
    }
}
