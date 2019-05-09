package 贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class Problem435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        //Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        //lambda会增加程序的运行时间
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int erase = 0;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= intervals[pre][1]) {
                erase++;
                pre = i;
            } else if (intervals[i][0] >= intervals[pre][1]) {
                pre = i;
            } else {
                erase++;
            }
        }
        return erase;
    }

    public static void main(String[] args) {
        Problem435 p = new Problem435();
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        p.eraseOverlapIntervals(arr);
    }

}
