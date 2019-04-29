package 经典148;


public class ConstructBinaryTreeFromTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    //根据中序和后序构造二叉树
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        return inPostProcess(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }


    private TreeNode inPostProcess(int[] inorder, int ii, int ij, int[] postorder, int pi, int pj) {
        if (ii > ij) {
            return null;
        }
        TreeNode head = new TreeNode(postorder[pj]);
        int index = p2i(inorder, postorder[pj]);
        head.left = inPostProcess(inorder, ii, index - 1, postorder, pi, pj - ij + index - 1);
        head.right = inPostProcess(inorder, index + 1, ij, postorder, pj - ij + index, pj - 1);
        return head;
    }

    private int p2i(int[] inorder, int value) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //根据前序和中序
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return preInProcess(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode preInProcess(int[] preorder, int pi, int pj, int[] inorder, int ii, int ij) {
        if (pi > pj) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[pi]);
        int index = p2i(inorder, preorder[pi]);
        head.left = preInProcess(preorder, pi + 1, index - ii + pi, inorder, ii, index - 1);
        head.right = preInProcess(preorder, index - ii + pi + 1, pj, inorder, index + 1, ij);
        return head;
    }


    public static void main(String[] args) {
        int[] inorder = {-1};
        int[] postorder = {-1};
        ConstructBinaryTreeFromTraversal c = new ConstructBinaryTreeFromTraversal();
        System.out.println(c.buildTree1(inorder, postorder));
    }
}
