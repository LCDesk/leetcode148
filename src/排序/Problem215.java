package 排序;

//快排或者堆排序解决Kth的问题
public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        return partion(nums, 0, nums.length - 1, k - 1);
    }
    //快排的partion过程
    private int partion(int[] nums, int i, int j, int k) {
        int start = i;
        int end = j;
        int num = nums[start];
        int index = start + 1;
        while (index < nums.length && start < end) {
            if (nums[index] > num) {
                swap(nums, start, index);
                start = index;
                index++;
            } else if (nums[index] < num) {
                swap(nums, index, end);
                end--;
            } else {
                index++;
            }
        }
        if (k < start - i) {
            return partion(nums, i, start - 1, k);
        } else if (start - i < k) {
            return partion(nums, start + 1, j, k - start - 1 + i);
        }
        return num;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Problem215 p = new Problem215();
        System.out.println(p.findKthLargest(new int[]{99, 99}, 1));
    }

}
