package 经典148;

public class MergeSortedArray {
    public void merge(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            } else {
                A[m + n - 1] = B[n - 1];
                n--;
            }
        }
        if (n != 0) {
            for (int k = n - 1; k >= 0; k--) {
                A[k] = B[k];
            }
        }
    }
}
