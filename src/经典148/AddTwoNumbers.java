package 经典148;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            int num = (l1.val + l2.val + count) % 10;
            count = (l1.val + l2.val + count) / 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int num = (l1.val + count) % 10;
            count = (l1.val + count) / 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int num = (l2.val + count) % 10;
            count = (l2.val + count) / 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            l2 = l2.next;
        }
        if (count != 0) {
            cur.next = new ListNode(count);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(0);
        node2.next = node3;
        AddTwoNumbers a = new AddTwoNumbers();
        a.addTwoNumbers(node1, node2);
    }
}
