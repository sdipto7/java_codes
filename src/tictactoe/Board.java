package tictactoe;

public class Board {

    char[][] board = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},};

    public Board() {
    }

    void showBoard() {
        for (char[] rows : board) {
            for (char column : rows) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
}
