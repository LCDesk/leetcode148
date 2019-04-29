package 经典148;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

//经典n皇后问题
public class NQueens {
    //皇后的放置方案

    LinkedHashSet<Integer> cols = new LinkedHashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return res;
        }
        process(0, n, new ArrayList<>());
        return res;
    }

    private void process(int index, int n, List<String> list) {
        if (index == n) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < n; i++) {
                if (!cols.contains(i)) {
                    int rows = 0;
                    boolean flag = true;
                    for (Integer col : cols) {
                        if (isOblique(rows++, col, index, i)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        cols.add(i);
                        list.add(produceStr(i, n));
                        process(index + 1, n, list);
                        list.remove(list.size() - 1);
                        cols.remove(i);
                    }
                }
            }
        }
    }

    private boolean isOblique(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) == Math.abs(y1 - y2);
    }

    private String produceStr(int k, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == k) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    int num = 0;

    public int totalNQueens(int n) {
        process(0, n);
        return num;
    }

    private void process(int index, int n) {
        if (index == n) {
            num++;
        } else {
            for (int i = 0; i < n; i++) {
                if (!cols.contains(i)) {
                    int rows = 0;
                    boolean flag = true;
                    for (Integer col : cols) {
                        if (isOblique(rows++, col, index, i)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        cols.add(i);
                        process(index + 1, n);
                        cols.remove(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        NQueens n = new NQueens();
        System.out.println(n.totalNQueens(4));
    }
}
