package 经典148;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    Set<Integer> col = new HashSet<>();
    Set<Integer> row = new HashSet<>();

    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    process(matrix, i, j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 4396) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void process(int[][] matrix, int i, int j) {
        if (!row.contains(i)) {
            row.add(i);
            for (int index = 0; index < matrix[0].length; index++) {
                if (matrix[i][index] != 0) {
                    matrix[i][index] = 4396;
                }
            }
        }
        if (!col.contains(j)) {
            col.add(j);
            for (int index = 0; index < matrix.length; index++) {
                if (matrix[index][j] != 0) {
                    matrix[index][j] = 4396;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes s = new SetMatrixZeroes();

        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        s.setZeroes(arr);


    }
}
