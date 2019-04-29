package 经典148;


public class ReverseNodesInKGroup {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head;
        ListNode tail = head;
        ListNode check = head;
        int needReverse = 0;
        while (check != null) {
            needReverse++;
            if (needReverse == k) {
                break;
            }
            check = check.next;
        }
        if (needReverse != k) {
            return head;
        }
        ListNode cur = head.next;
        next.next = null;
        int i = 1;
        while (cur != null && i < k) {
            ListNode temp = cur.next;
            cur.next = next;
            next = cur;
            cur = temp;
            i++;
        }
        tail.next = reverseKGroup(cur, k);
        return next;

    }


}
