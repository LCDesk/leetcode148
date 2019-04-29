package 经典148;

public class SearchInRotatedSortedArray {
    //数组不包含重复元素,要求时间复杂度O(logn)
    //一定是一个有序+一个可能有序或者无序的
    public int search1(int[] nums, int target) {
        return process1(nums, 0, nums.length - 1, target);
    }

    private int process1(int[] nums, int i, int j, int target) {
        if (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[j]) {
                if (nums[mid] < target && nums[j] >= target) {
                    return process1(nums, mid + 1, j, target);
                } else {
                    return process1(nums, i, mid - 1, target);
                }
            } else {
                if (nums[mid] > target && nums[i] <= target) {
                    return process1(nums, i, mid - 1, target);
                } else {
                    return process1(nums, mid + 1, j, target);
                }
            }
        } else {
            return -1;
        }
    }

    //数组包含重复数字
    public boolean search2(int[] nums, int target) {
        return process(nums, 0, nums.length - 1, target);
    }

    private boolean process(int[] nums, int i, int j, int target) {
        if (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[i] == nums[mid] && nums[mid] == nums[j]) {
                return process(nums, i + 1, j - 1, target);
            }
            if (nums[mid] <= nums[j]) {
                if (nums[mid] < target && nums[j] >= target) {
                    return process(nums, mid + 1, j, target);
                } else {
                    return process(nums, i, mid - 1, target);
                }
            } else {
                if (nums[mid] > target && nums[i] <= target) {
                    return process(nums, i, mid - 1, target);
                } else {
                    return process(nums, mid + 1, j, target);
                }
            }


        } else {
            return false;
        }

    }


    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();

        System.out.println(s.search2(new int[]{3,1,1}, 3));


    }

}
