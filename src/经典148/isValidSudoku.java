package 经典148;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class isValidSudoku {
    List<Set<Integer>> rows = new ArrayList<>();
    List<Set<Integer>> cols = new ArrayList<>();
    List<Set<Integer>> nines = new ArrayList<>();

    public boolean isValidSudoku(char[][] board) {
        return prepareList(board, rows, cols, nines);


    }


    private boolean prepareList(char[][] board, List<Set<Integer>> rows, List<Set<Integer>> cols, List<Set<Integer>> nines) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    if (rows.size() <= i) {
                        rows.add(new HashSet<>());
                    }
                    if (cols.size() <= j) {
                        cols.add(new HashSet<>());
                    }
                    if (nines.size() <= ((i / 3) * 3 + j / 3)) {
                        nines.add(new HashSet<>());
                    }
                    continue;
                }
                if (rows.size() <= i) {
                    Set<Integer> set = new HashSet<>();
                    set.add(board[i][j] - '0');
                    rows.add(set);
                } else {
                    if (rows.get(i).contains(board[i][j] - '0')) {
                        return false;
                    }
                    rows.get(i).add(board[i][j] - '0');
                }
                if (cols.size() <= j) {
                    Set<Integer> set = new HashSet<>();
                    set.add(board[i][j] - '0');
                    cols.add(set);
                } else {
                    if (cols.get(j).contains(board[i][j] - '0')) {
                        return false;
                    }
                    cols.get(j).add(board[i][j] - '0');
                }
                if (nines.size() <= (i / 3) * 3 + j / 3) {
                    Set<Integer> set = new HashSet<>();
                    set.add(board[i][j] - '0');
                    nines.add(set);
                } else {
                    if (nines.get((i / 3) * 3 + j / 3).contains(board[i][j] - '0')) {
                        return false;
                    }
                    nines.get((i / 3) * 3 + j / 3).add(board[i][j] - '0');
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isValidSudoku i = new isValidSudoku();
        char[][] chs = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},

        };

        i.isValidSudoku(chs);
    }

}
