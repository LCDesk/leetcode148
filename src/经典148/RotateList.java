package 经典148;

public class RotateList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //时间复杂度高
    public ListNode rotateRight1(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }
        while (n > size) {
            n -= size;
        }
        int rorate = size - n;
        if (rorate == 0) {
            return head;
        }
        ListNode cur = head;
        while (--rorate > 0) {
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        tail.next = head;
        return res;
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        if (len == 1) {
            return head;
        }
        tail.next = head;
        ListNode cur = head;
        int size = len - n % len;
        while (--size > 0) {
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        return res;


    }
}
