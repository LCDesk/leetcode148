package 经典148;

import java.util.PriorityQueue;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : num) {
            pq.add(i);
        }
        int res = 0;
        int cur = 1;
        int start = pq.poll();
        while (!pq.isEmpty()) {
            if (pq.peek() == start) {
                pq.poll();
                continue;
            }
            if (pq.peek() == start + 1) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 1;
            }
            start = pq.poll();
        }
        return Math.max(res, cur);
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        l.longestConsecutive(new int[]{0, -1});


    }
}
