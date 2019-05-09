package 贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class Problem452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int pre = 0;
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[pre][1]) {
                res++;
                pre = i;
            } else if (points[i][1] < points[pre][1]) {
                pre = i;
            }
        }
        res++;
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        Problem452 p = new Problem452();
        System.out.println(p.findMinArrowShots(arr));
    }
}
