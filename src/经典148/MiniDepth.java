package 经典148;

public class MiniDepth {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //版本1
    public int run1(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null) {
            depth = run1(root.left) + 1;
        }
        if (root.right != null) {
            depth = (root.left == null ? run1(root.right) + 1 : Math.min(depth, run1(root.right) + 1));
        }
        return depth;
    }

    //版本二
    public int run(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        if (root.right == null) {
            return run(root.left) + 1;
        } else if (root.left == null) {
            return run(root.right) + 1;
        }
        return Math.min(run(root.left), run(root.right)) + 1;
    }
}
