package io.sokovets.leetcode.easy.easy;

/**
 * There are n employees, each with a unique id from 0 to n - 1.
 *
 * You are given a 2D integer array logs where logs[i] = [idi, leaveTimei] where:
 *
 * idi is the id of the employee that worked on the ith task, and
 * leaveTimei is the time at which the employee finished the ith task. All the values leaveTimei are unique.
 * Note that the ith task starts the moment right after the (i - 1)th task ends, and the 0th task starts at time 0.
 *
 * Return the id of the employee that worked the task with the longest time. If there is a tie between two or more employees, return the smallest id among them.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10, logs = [[0,3],[2,5],[0,9],[1,15]]
 * Output: 1
 * Explanation:
 * Task 0 started at 0 and ended at 3 with 3 units of times.
 * Task 1 started at 3 and ended at 5 with 2 units of times.
 * Task 2 started at 5 and ended at 9 with 4 units of times.
 * Task 3 started at 9 and ended at 15 with 6 units of times.
 * The task with the longest time is task 3 and the employee with id 1 is the one that worked on it, so we return 1.
 * Example 2:
 *
 * Input: n = 26, logs = [[1,1],[3,7],[2,12],[7,17]]
 * Output: 3
 * Explanation:
 * Task 0 started at 0 and ended at 1 with 1 unit of times.
 * Task 1 started at 1 and ended at 7 with 6 units of times.
 * Task 2 started at 7 and ended at 12 with 5 units of times.
 * Task 3 started at 12 and ended at 17 with 5 units of times.
 * The tasks with the longest time is task 1. The employees that worked on it is 3, so we return 3.
 * Example 3:
 *
 * Input: n = 2, logs = [[0,10],[1,20]]
 * Output: 0
 * Explanation:
 * Task 0 started at 0 and ended at 10 with 10 units of times.
 * Task 1 started at 10 and ended at 20 with 10 units of times.
 * The tasks with the longest time are tasks 0 and 1. The employees that worked on them are 0 and 1, so we return the smallest id 0.
 */
public class TheEmployeeThatWorkedOntheLongestTask2432 {


    public int hardestWorker(int n, int[][] logs) {
        //TimeComplexity = O(N)
        //SpaceComplexity = O(N)
        //1. [1,1],[3,7],[2,12],[7,17]
        //2. new int[n];
        //3. start position = 0;
        //4. iterate through logs
        //5. current times - startPosition; //update startPosition
        //6. save current time to array of employees
        //get min index [0->1],[1-10],[2-10];

        int[] employees = new int[n];

        for (int i = 0; i < employees.length; i++) {
            employees[i] = Integer.MIN_VALUE;
        }

        //[[0,3],[2,5],[0,9],[1,15]]
        // 0 - 4
        // 2- 2
        // 1 - 6

        int currentUnit = 0;

        for (int[] log : logs) {
            int employeeId = log[0]; //
            int unitsOfTimes = log[1] - currentUnit;
            currentUnit = log[1];
            employees[employeeId] = Math.max(employees[employeeId], unitsOfTimes);
        }


        int minIndex = 0;


        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != Integer.MIN_VALUE) {

                if (employees[minIndex] < employees[i]) {
                    minIndex = i;
                }
            }
        }

        return minIndex;

    }

}
