package 经典148;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Integer> list = grayCode(n - 1);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add((list.get(i) << 1) + 1);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            res.add(list.get(i) << 1);
        }
        return res;
    }

    public static void main(String[] args) {
        GrayCode g = new GrayCode();
        g.grayCode(2);
    }
}
