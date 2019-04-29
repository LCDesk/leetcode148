package 经典148;

public class RecoverBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode fristNode = null;
    TreeNode secondNode = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    //o(n)的空间复杂度
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = fristNode.val;
        fristNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (fristNode == null && pre.val > root.val) {
            fristNode = pre;
        }
        if (fristNode != null && pre.val > root.val) {
            secondNode = root;
        }
        pre = root;
        inorder(root.right);
    }

    //基于Morris遍历的,找到前序节点，然后指向自己，形成循环
    public void recoverTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root, m1 = null, m2 = null, last = null;
        while (cur != null) {
            TreeNode pre = cur.left;
            if (pre != null) {
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    pre.right = null;
                }
            }
            if (last == null) {
                last = cur;
            } else {
                if (m1 == null && last.val > cur.val) {
                    m1 = last;
                    m2 = cur;
                } else if (m1 != null && last.val > cur.val) {
                    m2 = cur;
                    last = cur;
                }
            }
            cur = cur.right;
        }
        int t = m1.val;
        m1.val = m2.val;
        m2.val = t;
    }
}
