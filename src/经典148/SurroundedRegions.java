package 经典148;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                infection(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                infection(board, board.length - 1, i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                infection(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                infection(board, i, board[0].length - 1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void infection(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '1';
        infection(board, i - 1, j);
        infection(board, i + 1, j);
        infection(board, i, j - 1);
        infection(board, i, j + 1);
    }

    public static void main(String[] args) {
        SurroundedRegions s = new SurroundedRegions();
        char[][] chs = {{'O'}};

        s.solve(chs);
    }

}
