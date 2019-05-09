package 贪心算法;

public class Problem665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean res = true;
        int count = 0;
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[pre]) {
                if (count < 1) {
                    count++;
                } else {
                    res = false;
                    break;
                }
            } else {
                pre = i;
            }
        }
        if (res) {
            return true;
        }
        count = 0;
        pre = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[pre]) {
                if (count < 1) {
                    count++;
                } else {
                    return false;
                }
            } else {
                pre = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem665 p = new Problem665();
        System.out.println(p.checkPossibility(new int[]{3, 4, 2, 3}));
    }
}
