package 经典148;

public class RemoveNthNodeFromEndOfList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //可以改成双指针法，一边遍历即可
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int delete = len - n;
        ListNode pre = dummy;
        cur = head;
        while (delete-- > 0) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        cur.next = null;
        return dummy.next;
    }


}
