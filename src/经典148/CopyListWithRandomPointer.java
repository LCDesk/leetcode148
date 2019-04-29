package 经典148;


public class CopyListWithRandomPointer {
    class RandomListNode {
        public int label;
        public RandomListNode next;
        public RandomListNode random;

        public RandomListNode() {
        }

        public RandomListNode(int _val, RandomListNode _next, RandomListNode _random) {
            label = _val;
            next = _next;
            random = _random;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label, null, null);
            RandomListNode next = cur.next;
            cur.next = node;
            node.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            RandomListNode random = cur.random;
            if (random != null) {
                cur.next.random = random.next;
            }
            cur = cur.next.next;
        }
        RandomListNode res = head.next;
        cur = head;
        RandomListNode copy = res;
        while (cur != null) {
            RandomListNode next = cur.next.next;
            if (next == null) {
                cur.next = null;
                copy.next = null;
                cur = null;
            } else {
                cur.next = next;
                copy.next = next.next;
                cur = cur.next;
                copy = copy.next;
            }


        }
        return res;
    }

}
