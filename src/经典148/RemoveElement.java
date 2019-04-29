package 经典148;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                swap(nums, i, --j);
            } else {
                i++;
            }
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        r.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);

    }
}
