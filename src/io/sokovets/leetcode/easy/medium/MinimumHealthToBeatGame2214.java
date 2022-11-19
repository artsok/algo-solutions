package io.sokovets.leetcode.easy.medium;

/**
 * Medium
 * 2810Add to ListShare
 * You are playing a game that has n levels numbered from 0 to n - 1. You are given a 0-indexed integer array damage where damage[i] is the amount of health you will lose to complete the ith level.
 *
 * You are also given an integer armor. You may use your armor ability at most once during the game on any level which will protect you from at most armor damage.
 *
 * You must complete the levels in order and your health must be greater than 0 at all times to beat the game.
 *
 * Return the minimum health you need to start with to beat the game.
 *
 *
 *
 * Example 1:
 *
 * Input: damage = [2,7,4,3], armor = 4
 * Output: 13
 * Explanation: One optimal way to beat the game starting at 13 health is:
 * On round 1, take 2 damage. You have 13 - 2 = 11 health.
 * On round 2, take 7 damage. You have 11 - 7 = 4 health.
 * On round 3, use your armor to protect you from 4 damage. You have 4 - 0 = 4 health.
 * On round 4, take 3 damage. You have 4 - 3 = 1 health.
 * Note that 13 is the minimum health you need to start with to beat the game.
 *
 * Example 2:
 *
 * Input: damage = [2,5,3,4], armor = 7
 * Output: 10
 * Explanation: One optimal way to beat the game starting at 10 health is:
 * On round 1, take 2 damage. You have 10 - 2 = 8 health.
 * On round 2, use your armor to protect you from 5 damage. You have 8 - 0 = 8 health.
 * On round 3, take 3 damage. You have 8 - 3 = 5 health.
 * On round 4, take 4 damage. You have 5 - 4 = 1 health.
 * Note that 10 is the minimum health you need to start with to beat the game.
 *
 * Example 3:
 *
 * Input: damage = [3,3,3], armor = 0
 * Output: 10
 * Explanation: One optimal way to beat the game starting at 10 health is:
 * On round 1, take 3 damage. You have 10 - 3 = 7 health.
 * On round 2, take 3 damage. You have 7 - 3 = 4 health.
 * On round 3, take 3 damage. You have 4 - 3 = 1 health.
 * Note that you did not use your armor ability.
 *
 *
 *
 * Constraints:
 *
 * n == damage.length
 * 1 <= n <= 105
 * 0 <= damage[i] <= 105
 * 0 <= armor <= 105
 */
public class MinimumHealthToBeatGame2214 {

    int [] damage = {2, 5, 3, 4};
    int armor = 7;

    public static void main(String[] args) {

    }

    long beatGame(int [] damage, int armor) {
        long max = 0;
        long sumOfHealth = 0;

        //max = 4
        //sumOfHealth = 16
        //[2,7,3,3], armor = 4

        for (int i = 0; i < damage.length; i++) {
            sumOfHealth += damage[i];
            max = Math.min(Math.max(damage[i], max), armor); //Ищем максимальное число в массиве damage и далее сравниваем его с нашей броней.
            // Броня всегда применяется один раз полностью, следовательно ее можно полностью вычитывать. дальше если уровень сложность 3
            // и мы будем использовать броню в 4, следоватлеьно броню всю используем
        }
        return sumOfHealth - max +1; //+1 Говорим о том, что нам надо хоть как-то выжить.
    }

}
