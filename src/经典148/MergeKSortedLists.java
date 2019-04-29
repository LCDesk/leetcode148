package 经典148;

import java.util.ArrayList;


public class MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.size() - 1);
    }

    //使用了归并算法的思路
    private ListNode mergeLists(ArrayList<ListNode> lists, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            ListNode m1 = mergeLists(lists, i, mid);
            ListNode m2 = mergeLists(lists, mid + 1, j);
            return mergeTwoLists(m1, m2);
        } else {
            return lists.get(i);
        }

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }


}
