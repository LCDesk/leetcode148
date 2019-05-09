package 贪心算法;

public class Problem605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    n--;
                    if (n == 0) {
                        break;
                    }
                    i += 2;
                } else {
                    i++;
                }
            }
        }
        return n == 0;
    }
}
