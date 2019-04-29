package 经典148;


public class SumRootToLeafNumbers {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        process(root, new StringBuilder());
        return sum;
    }

    private void process(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            sum += Integer.valueOf(sb.toString());

        } else {
            if (node.left != null) {
                process(node.left, sb);
            }
            if (node.right != null) {
                process(node.right, sb);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }


}
