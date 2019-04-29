package 经典148;

public class SearchInsertPosition {
    //搜索一个位置
    public int searchInsert(int[] nums, int target) {
        return binSearch(nums, target, 0, nums.length - 1);
    }

    private int binSearch(int[] nums, int target, int i, int j) {
        if (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return binSearch(nums, target, i, mid - 1);
            } else {
                return binSearch(nums, target, mid + 1, j);
            }
        } else {
            return i;
        }
    }


    //搜索一个范围
    public int[] searchRange(int[] A, int target) {
        return process(A, 0, A.length - 1, target);
    }

    private int[] process(int[] A, int i, int j, int target) {
        if (i <= j) {
            int mid = (i + j) / 2;
            if (A[mid] > target) {
                return process(A, i, mid - 1, target);
            } else if (A[mid] < target) {
                return process(A, mid + 1, j, target);
            } else {
                int[] res = new int[]{mid, mid};
                if (mid > 0 && A[mid - 1] == target) {
                    A[mid]--;
                    res[0] = process(A, i, mid - 1, target)[0];
                    A[mid]++;
                }
                if (mid < A.length - 1 && A[mid + 1] == target) {
                    A[mid]--;
                    res[1] = process(A, mid + 1, j, target)[1];
                    A[mid]++;
                }
                return res;
            }
        } else {
            return new int[]{-1, -1};
        }

    }


    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
