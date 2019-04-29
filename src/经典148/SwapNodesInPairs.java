package 经典148;


public class SwapNodesInPairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode count = head;
        int len = 0;
        while (count != null) {
            len++;
            count = count.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for (int i = 0; i < len / 2; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }


}
