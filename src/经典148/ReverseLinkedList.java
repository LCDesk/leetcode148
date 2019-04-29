package 经典148;

public class ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 反转策略：A->B->C->D
     * B->A->C->D
     * C->B->A->D
     * D->C->B->A
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode preNext = pre.next;
            ListNode curNext = cur.next;
            ListNode next = curNext.next;
            cur.next = next;
            curNext.next = preNext;
            pre.next = curNext;
        }
        return dummy.next;
    }


}
