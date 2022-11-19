package io.sokovets.leetcode.easy.medium;

public class DesignTicTacToe348 {

    /**
     * Your TicTacToe object will be instantiated and called as such:
     * TicTacToe obj = new TicTacToe(n);
     * int param_1 = obj.move(row,col,player);
     */
    public static void main(String[] args) {

    }
}

class TicTacToe {

    int[] rows;
    int[] cols;

    //сумма диагонали по направлению /
    int diag;

    //сумма диагонали по направлению \
    int anti_diag;

    int n;

    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        //Если у нас игрок #2 то мы его мутируем в -1, чтобы потом смогли просто посчитать значения по модулю
        if (player == 2) {
            player = -1;
        }

        rows[row] += player; //Так как матрица заполняется 0, то прибавляем наше значение
        cols[col] += player;

        if (row == col) {
            diag += player;
        }

        if (row + col == n - 1) { //Прикольная формула диагонали назад
            anti_diag += player;
        }

        if (Math.abs(diag) == n || Math.abs(anti_diag) == n || Math.abs(rows[row]) == n || Math.abs(cols[col]) == n) {
            return player == -2 ? 2 : 1;
        }
        return 0;
    }
}

