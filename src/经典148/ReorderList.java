package 经典148;

import java.util.Stack;


public class ReorderList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //复杂度特别高
    public void reorderList1(ListNode head) {
        process(head);
    }

    private ListNode process(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        ListNode next = process(head.next);
        head.next = cur;
        cur.next = next;
        return head;
    }

    //快慢指针找中点
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode head2 = reverse(slow);
        merger(head, head2);
    }

    private void merger(ListNode head, ListNode head2) {
        ListNode cur = head;
        ListNode h1 = head.next;
        ListNode h2 = head2;
        while (h1 != null && h2 != null) {
            cur.next = h2;
            h2 = h2.next;
            cur = cur.next;
            cur.next = h1;
            h1 = h1.next;
            cur = cur.next;
        }
        if (h1 != null) {
            cur.next = h1;
        }
        if (h2 != null) {
            cur.next = h2;
        }
    }

    private ListNode reverse(ListNode mid) {
        if (mid == null || mid.next == null) {
            return mid;
        }
        Stack<ListNode> stack = new Stack<>();
        while (mid != null) {
            stack.push(mid);
            mid = mid.next;
        }
        ListNode res = stack.pop();
        ListNode cur = res;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return res;
    }

}
