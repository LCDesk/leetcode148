package 经典148;

import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRightPointersInEachNode {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    //非完美二叉树
    public TreeLinkNode connect1(TreeLinkNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode cur = null;
            while (size-- > 0) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (size == 0) {
                    cur.next = null;
                } else {
                    cur.next = queue.peek();
                }
            }
        }
        return root;
    }

    //完美二叉树
    public TreeLinkNode connect2(TreeLinkNode root) {
        if (root == null) {
            return root;
        }
        TreeLinkNode fristNode = root;
        TreeLinkNode cur = null;
        while (fristNode.left != null) {
            TreeLinkNode temp = fristNode;
            while (temp != null) {
                cur = temp.left;
                cur.next = temp.right;
                cur = temp.right;
                temp = temp.next;
                if (temp != null) {
                    cur.next = temp.left;
                }
            }
            fristNode = fristNode.left;
        }
        return root;
    }
}
