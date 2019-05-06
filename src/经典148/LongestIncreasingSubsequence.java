package 经典148;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int index = -1;
        int[] arr = new int[nums.length];
        for (int num : nums) {
            int pos = bs(arr, 0, index, num);
            if (pos == -1) {
                arr[++index] = num;
            } else {
                arr[pos] = num;
            }
        }
        return index + 1;
    }

    private int bs(int[] arr, int i, int j, int num) {
        if (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] < num) {
                return bs(arr, mid + 1, j, num);
            } else {
                if (mid == 0 || arr[mid - 1] < num) {
                    return mid;
                } else {
                    return bs(arr, i, mid - 1, num);
                }
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        System.out.println(l.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
