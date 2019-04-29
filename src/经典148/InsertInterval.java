package 经典148;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InsertInterval {
    //插入区间
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean insert = false;
        for (int[] interval : intervals) {
            if (!insert && interval[0] > newInterval[0]) {
                insert = true;
                list.add(newInterval);
            }
            list.add(interval);
        }
        if (list.size() != intervals.length + 1) {
            list.add(newInterval);
        }
        Iterator<int[]> it = list.iterator();
        int[] pre = it.next();
        while (it.hasNext()) {
            int[] cur = it.next();
            if (cur[1] < pre[1]) {
                it.remove();
            } else if (cur[0] <= pre[1]) {
                pre[1] = cur[1];
                it.remove();
            } else {
                pre = cur;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //合并区间
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int[] cur = null;
        for (int i = 1; i < intervals.length; i++) {
            cur = list.get(list.size() - 1);
            if (cur[1] < intervals[i][1] && cur[1] >= intervals[i][0]) {
                cur[1] = intervals[i][1];
            } else if (cur[1] < intervals[i][1]) {
                list.add(intervals[i]);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        InsertInterval i = new InsertInterval();

        int[][] arr = {{1, 4}, {0, 4}};
        int[] insert = {2, 7};
        System.out.println(i.merge(arr));


    }

}
