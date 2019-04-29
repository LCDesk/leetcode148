package 经典148;

public class FirstMissingPositive {
    //也可以不使用额外空间，放入正确位置把前一个数字顶出来
    public int firstMissingPositive(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                arr[num - 1] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
