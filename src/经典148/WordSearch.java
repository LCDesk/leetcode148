package 经典148;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (process(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean process(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        board[i][j] = '*';
        boolean res = process(board, word, index + 1, i + 1, j) ||
                process(board, word, index + 1, i - 1, j) ||
                process(board, word, index + 1, i, j + 1) ||
                process(board, word, index + 1, i, j - 1);
        board[i][j] = word.charAt(index);
        return res;
    }

}
