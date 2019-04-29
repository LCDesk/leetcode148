package 经典148;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        int i = num.length - 1;
        for (; i >= 1; i--) {
            if (num[i] > num[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            Arrays.sort(num);
            return;
        }
        i--;

        for (int j = num.length - 1; j > i; j--) {
            if (num[j] > num[i]) {
                swap(num, i, j);
                Arrays.sort(num, i + 1, num.length);
                return;
            }
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        n.nextPermutation(new int[]{2, 2, 0, 4, 3, 1});


    }
}



