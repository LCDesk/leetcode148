package 经典148;

import java.util.ArrayList;

public class SpiralMatrix {
    //螺旋生成数组
    public int[][] generateMatrix(int n) {
        int x1 = 0;
        int y1 = 0;
        int x2 = n - 1;
        int y2 = n - 1;
        int num = 1;
        int[][] res = new int[n][n];

        while (x1 <= x2) {
            if (x1 == x2) {
                res[x1][y1] = num++;
            } else {
                for (int i = y1; i < y2; i++) {
                    res[x1][i] = num++;
                }
                for (int i = x1; i < x2; i++) {
                    res[i][y2] = num++;
                }
                for (int i = y2; i > y1; i--) {
                    res[x2][i] = num++;
                }
                for (int i = x2; i > x1; i--) {
                    res[i][y1] = num++;
                }
            }
            x1++;
            y1++;
            x2--;
            y2--;
        }
        return res;
    }

    //螺旋打印数组
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int x1 = 0;
        int y1 = 0;
        int x2 = m;
        int y2 = n;
        while (x1 <= x2 && y1 <= y2) {
            if (x1 == x2) {
                for (int i = y1; i <= y2; i++) {
                    list.add(matrix[x1][i]);
                }
            } else if (y1 == y2) {
                for (int i = x1; i <= x2; i++) {
                    list.add(matrix[i][y1]);
                }
            } else {
                for (int i = y1; i < y2; i++) {
                    list.add(matrix[x1][i]);
                }
                for (int i = x1; i < x2; i++) {
                    list.add(matrix[i][y2]);
                }
                for (int i = y2; i > y1; i--) {
                    list.add(matrix[x2][i]);
                }
                for (int i = x2; i > x1; i--) {
                    list.add(matrix[i][y1]);
                }
            }
            x1++;
            y1++;
            x2--;
            y2--;
        }
        return list;
    }


    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] arr = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        s.spiralOrder(arr);


    }

}
