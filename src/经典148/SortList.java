package 经典148;


//链表的归并排序
public class SortList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);

    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //利用快慢指针找链表的中点
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //拆成两个链表
        ListNode r = mergeSort(slow.next);
        slow.next = null;
        ListNode l = mergeSort(head);
        return mergeList(l, r);

    }

    private ListNode mergeList(ListNode l, ListNode r) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
                cur.next = null;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
                cur.next = null;
            }
        }
        if (r == null) {
            cur.next = l;
        }
        if (l == null) {
            cur.next = r;
        }
        return head.next;
    }
}
