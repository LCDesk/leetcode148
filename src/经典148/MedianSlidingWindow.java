package 经典148;

import java.util.ArrayList;
import java.util.List;

public class MedianSlidingWindow {
    //只能使用插排+二分查找
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int pos;
        int index;
        list.add(nums[0]);
        for (int i = 1; i < k; i++) {
            pos = binSearchInsert(list, nums[i]);
            list.add(pos, nums[i]);
        }
        double[] res = new double[nums.length - k + 1];
        res[0] = getMedian(list, k);
        for (int i = k; i < nums.length; i++) {
            index = binSearch(list, nums[i - k]);
            list.remove(index);
            pos = binSearchInsert(list, nums[i]);
            list.add(pos, nums[i]);
            res[i - k + 1] = getMedian(list, k);
        }
        return res;
    }

    private int binSearch(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > num) {
                right = mid - 1;
            } else if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    private double getMedian(List<Integer> list, int k) {
        if (k % 2 == 0) {
            return ((long) list.get(k / 2 - 1) + list.get(k / 2)) / 2.0;
        } else {
            return list.get(k / 2);
        }


    }

    private int binSearchInsert(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > num) {
                right = mid - 1;
            } else {
                if (mid == list.size() - 1 || list.get(mid + 1) > num) {
                    return mid + 1;
                }
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MedianSlidingWindow m = new MedianSlidingWindow();
        System.out.println(m.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2));


    }

}
