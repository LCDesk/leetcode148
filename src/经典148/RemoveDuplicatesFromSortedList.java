package 经典148;

public class RemoveDuplicatesFromSortedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //删除重复的节点
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(head.val - 1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != pre.val) {
                cur = cur.next;
                pre = pre.next;
            } else {
                ListNode next = cur.next;
                cur.next = null;
                pre.next = next;
                cur = next;
            }
        }
        return dummy.next;
    }

    //只留下不重复的节点
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(head.val - 1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode before = null;
        while (cur != null) {
            if (cur.val != pre.val) {
                before = pre;
                pre = pre.next;
                cur = cur.next;

            } else {
                while (cur != null && cur.val == pre.val) {
                    ListNode next = cur.next;
                    cur.next = null;
                    pre.next = next;
                    cur = next;
                }
                pre.next = null;
                before.next = cur;
                pre = cur;
                if (cur != null) {
                    cur = cur.next;
                }
            }
        }
        return dummy.next;
    }


}
