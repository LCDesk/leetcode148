package 经典148;

import java.util.*;


//构建斜率和点数的对应关系
public class MaxPointOnLine {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }

    }

    public int maxPoints(Point[] points) {
        int n = points.length;
        if (n < 2) {
            return n;
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            // 分别统计与点i重合以及垂直的点的个数
            int dup = 1, vtl = 0;
            Map<Float, Integer> map = new HashMap<>();
            Point a = points[i];

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                Point b = points[j];
                if (a.x == b.x) {
                    if (a.y == b.y) {
                        dup++;
                    } else {
                        vtl++;
                    }
                } else {
                    float k = (float) (a.y - b.y) / (a.x - b.x);
                    if (map.containsKey(k)) {
                        map.put(k, 1);
                    } else {
                        map.put(k, map.get(k) + 1);
                    }
                }
            }

            int max = vtl;
            for (float k : map.keySet()) {
                max = Math.max(max, map.get(k));
            }
            ret = Math.max(ret, max + dup);
        }
        return ret;
    }
}
