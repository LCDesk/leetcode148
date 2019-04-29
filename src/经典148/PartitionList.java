package 经典148;

public class PartitionList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode root = dummy;
        ListNode cur = head;
        while (cur != null && cur.val < x) {
            root = root.next;
            cur = cur.next;
        }
        ListNode pre = root;
        while (cur != null) {
            if (cur.val < x) {
                ListNode curNext = cur.next;
                pre.next = curNext;
                ListNode rootNext = root.next;
                root.next = cur;
                cur.next = rootNext;
                cur = curNext;
                root = root.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }


}
