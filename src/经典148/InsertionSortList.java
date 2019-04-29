package 经典148;

public class InsertionSortList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre;


        while (cur != null) {
            pre = temp;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            ListNode next = pre.next;
            pre.next = cur;
            pre = pre.next;
            cur = cur.next;
            pre.next = next;
        }
        return temp.next;
    }
}