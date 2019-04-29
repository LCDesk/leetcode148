package 经典148;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int len = matrix.length - 1;
        int x1 = 0;
        int y1 = 0;
        int x2 = len;
        int y2 = len;
        while (x1 < x2) {
            for (int i = 0; i < len; i++) {
                int temp = matrix[x1][y1 + i];
                matrix[x1][y1 + i] = matrix[x2 - i][y1];
                matrix[x2 - i][y1] = matrix[x2][y2 - i];
                matrix[x2][y2 - i] = matrix[x1 + i][y2];
                matrix[x1 + i][y2] = temp;
            }
            x1++;
            y1++;
            x2--;
            y2--;
            len = len - 2;
        }
    }

    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        r.rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }
}
