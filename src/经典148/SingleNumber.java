package 经典148;

public class SingleNumber {

    //其他数字出现两次，找到出现一次的
    public int singleNumber1(int[] A) {
        int res = A[0];
        for (int i = 1; i < A.length; i++) {
            res ^= A[i];
        }
        return res;
    }

    //其他数字出现三次，找到出现一次的
    public int singleNumber2(int[] A) {
        int one = 0;
        int two = 0;
        int three = 0;
        for (int num : A) {
            two |= num & one;
            one ^= num;
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }


}
