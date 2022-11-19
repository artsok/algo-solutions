package io.sokovets.leetcode.easy.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {


    public static void main(String[] args) {
        char[][] a = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };


        char[][] b = new char[][]{ //Expected false
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        char[][] c = new char[][]{ //Expected true
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(new ValidSudoku().isValidSudoku(c));
    }

    public boolean isValidSudoku(char[][] board) {

        int N = board.length;
        int M = board[0].length;

        Set<Character> set = new HashSet<>();

        //Проверка по горизонтали
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }

        //Проверка по вертикали
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
            set.clear();
        }

        int startX = 0;
        int startY = 0;
        int stopX = 2;
        int stopY = 2;

        int countareas = 0;

        while (countareas != 9) {

            if (stopY > 9) { //Если больше, то нужно сбрасывать startY и stoptY = до пред.значений и увеличивать startX, чтобы перейти на след.строку
                startX = startX + 3;
                stopX = stopX + 3;

                startY = 0;
                stopY = 2;
            }


            for (int i = startX; i <= stopX; i++) {
                for (int j = startY; j <= stopY; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
            set.clear();

            startY = stopY + 1;
            stopY = (stopY + 3);
            countareas++;
        }
        return true;
    }
}
