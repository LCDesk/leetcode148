package 经典148;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public ArrayList<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        if (rowIndex == 0) {
            return new ArrayList<>(list);
        }
        list.add(1);
        if (rowIndex == 1) {
            return new ArrayList<>(list);
        }
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = 0; j < i - 1; j++) {
                list.add(list.get(j) + list.get(j + 1));
            }
            for (int j = 1; j < i; j++) {
                list.remove(1);
            }
            list.add(1);
        }
        return new ArrayList<>(list);
    }

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(new ArrayList<>(list));
        if (numRows == 1) {
            return res;
        }
        list.add(1);
        res.add(new ArrayList<>(list));
        if (numRows == 2) {
            return res;
        }
        for (int i = 2; i < numRows; i++) {
            for (int j = 0; j < i - 1; j++) {
                list.add(list.get(j) + list.get(j + 1));
            }
            for (int j = 1; j < i; j++) {
                list.remove(1);
            }
            list.add(1);
            res.add(new ArrayList<>(list));
        }
        return res;
    }


    public static void main(String[] args) {
        PascalsTriangle p = new PascalsTriangle();
        p.generate(5);
    }
}
