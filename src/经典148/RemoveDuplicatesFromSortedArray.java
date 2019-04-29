package 经典148;

public class RemoveDuplicatesFromSortedArray {
    //重复元素最多两次
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int curPoint = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; ) {
            if (nums[i] == pre) {
                nums[curPoint++] = pre;
                while (i < nums.length && nums[i] == pre) {
                    i++;
                }
            } else {
                nums[curPoint++] = nums[i];
                pre = nums[i++];
            }
        }
        return curPoint;
    }

    //每个元素唯一
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }


        int curPoint = 1;
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i] == pre) {
                i++;
            }
            if (i != nums.length) {
                nums[curPoint++] = nums[i];
                pre = nums[i];
            }
        }
        return curPoint;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        r.removeDuplicates(new int[]{1, 1, 2});
    }


}
