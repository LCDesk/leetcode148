package 双指针;

public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        int i = 0;
        int j = 0;
        while (i < m) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                swap(nums1, nums2, i++, j);
                while (j < nums2.length - 1 && nums2[j] > nums2[j + 1]) {
                    swap(nums2, nums2, j, j + 1);
                    j++;
                }
                j = 0;
            }
        }
        for (int k = m; k < nums1.length; k++) {
            nums1[k] = nums2[k - m];
        }
    }

    private void swap(int[] arr1, int[] arr2, int i, int j) {
        arr1[i] = arr1[i] ^ arr2[j];
        arr2[j] = arr1[i] ^ arr2[j];
        arr1[i] = arr1[i] ^ arr2[j];
    }

    public static void main(String[] args) {
        Problem88 p = new Problem88();
        int[] nums1 = {1, 2, 6, 0, 0, 0};
        int[] nums2 = {2, 5, 7};
        p.merge(nums1, 3, nums2, 3);

    }

}
