package 经典148;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {


        process(1, n, k, new ArrayList<>());
        return res;
    }

    private void process(int i, int n, int count, List<Integer> list) {
        if (count == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i > n) {
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            process(j + 1, n, count - 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        c.combine(4, 2);


    }
}
