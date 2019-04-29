package 经典148;


public class ConvertSortedListToBinarySearchTree {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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

    //有序链表转化成BST
    public TreeNode sortedListToBST(ListNode head) {
        return process(head);
    }

    private TreeNode process(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode pre = midPre(node);
        if (pre == null) {
            return new TreeNode(node.val);
        }
        ListNode mid = pre.next;
        pre.next = null;
        TreeNode head = new TreeNode(mid.val);
        head.left = process(node);
        head.right = process(mid.next);
        return head;
    }

    private ListNode midPre(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode slow = node;
        ListNode fast = node;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        return pre;
    }


    //有序数组转成BST
    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    private TreeNode process(int[] nums, int i, int j) {
        if (i <= j) {
            int mid = (i + j) / 2;
            TreeNode head = new TreeNode(nums[mid]);
            head.left = process(nums, i, mid - 1);
            head.right = process(nums, mid + 1, j);
            return head;
        } else {
            return null;
        }

    }


}
