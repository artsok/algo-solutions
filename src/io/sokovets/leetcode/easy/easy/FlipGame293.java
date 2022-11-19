package io.sokovets.leetcode.easy.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing a Flip Game with your friend.
 *
 * You are given a string currentState that contains only '+' and '-'. You and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move, and therefore the other person will be the winner.
 *
 * Return all possible states of the string currentState after one valid move. You may return the answer in any order. If there is no valid move, return an empty list [].
 *
 *
 *
 * Example 1:
 *
 * Input: currentState = "++++"
 * Output: ["--++","+--+","++--"]
 * Example 2:
 *
 * Input: currentState = "+"
 * Output: []
 */
public class FlipGame293 {

    public List<String> generatePossibleNextMoves(String currentState) {

        //++++
        //--++
        //-++-
        //++--

        //1. Загнать в char и подсчитать сколько символов + и - +-+-+-
        //split(++) и если 0, то ничего не возвращаем, а если есть что-то

        //

        char[] chars = currentState.toCharArray();
        List<String> result = new ArrayList<>();


        for (int i = 0; i + 1 < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {

                if (chars[i] == '+' && chars[j] == '+') {
                    chars[i] = '-';
                    chars[j] = '-';
                    String temp = new String(chars);

                    result.add(temp);
                    chars[i] = '+';
                    chars[j] = '+';
                }

                break;
            }

        }
        return result;
    }

}
