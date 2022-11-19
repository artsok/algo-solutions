package io.sokovets.leetcode.easy.easy;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Alice and Bob are traveling to Rome for separate business meetings.
 * <p>
 * You are given 4 strings arriveAlice, leaveAlice, arriveBob, and leaveBob. Alice will be in the city from the dates arriveAlice to leaveAlice (inclusive), while Bob will be in the city from the dates arriveBob to leaveBob (inclusive). Each will be a 5-character string in the format "MM-DD", corresponding to the month and day of the date.
 * <p>
 * Return the total number of days that Alice and Bob are in Rome together.
 * <p>
 * You can assume that all dates occur in the same calendar year, which is not a leap year. Note that the number of days per month can be represented as: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
 * Output: 3
 * Explanation: Alice will be in Rome from August 15 to August 18. Bob will be in Rome from August 16 to August 19. They are both in Rome together on August 16th, 17th, and 18th, so the answer is 3.
 * Example 2:
 * <p>
 * Input: arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
 * Output: 0
 * Explanation: There is no day when Alice and Bob are in Rome together, so we return 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * All dates are provided in the format "MM-DD".
 * Alice and Bob's arrival dates are earlier than or equal to their leaving dates.
 * The given dates are valid dates of a non-leap year.
 */
public class CountDaysSpentTogether2409 {


    public static void main(String[] args) {
        //Тест кейс 1
//        String arriveAlice = "08-15";
//        String leaveAlice = "08-18";
//        String arriveBob = "08-16";
//        String leaveBob = "08-19";

        //Тест кейс 2
//        String arriveAlice = "10-01";
//        String leaveAlice = "10-31";
//
//        String arriveBob = "11-01";
//        String leaveBob = "12-31";


        //Тест кейс 2
        String arriveAlice = "09-01";
        String leaveAlice = "10-19";

        String arriveBob = "06-19";
        String leaveBob = "10-20";

        System.out.println(new CountDaysSpentTogether2409().countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        //08-15 -> 09-15 - from August 15 to September 15.

        int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //Складываем сюда все дни по Алисе
        Set<String> allAliceDays = new LinkedHashSet<>();

        //Текущий день + месяц  ALice
        int currentAliceDay = Integer.parseInt(arriveAlice.replace("-", "")); //День приезда отображаем в числах.

        //Текущий месяц и день
        int currentAliceMM = Integer.parseInt(arriveAlice.split("-")[0]); //Парсинг месяца
        int currentAliceDD = Integer.parseInt(arriveAlice.split("-")[1]); //Парсинг дня

        //Когда уезжать
        int leaveAliceMM = Integer.parseInt(leaveAlice.split("-")[0]); //Месяц когда должны уехать
        int leaveAliceDD = Integer.parseInt(leaveAlice.split("-")[1]); //День когда должны уехать
        int leaveAliceInt = Integer.parseInt(leaveAlice.replace("-", ""));
        String currentAlice = "";


        //Пока текущий день не равняется последнему дню отъезда
        while (!currentAlice.equals(leaveAlice)) {

            int totalDaysInMonth = daysInMonth[currentAliceMM - 1]; //Получили сколько дней в месяце

            //Идем по дням в месяце. Старт наш текущий день у алисы и до конца месяца итерируемся.
            //Выходим когда дни совпадут
            for (int i = currentAliceDD; i <= totalDaysInMonth; i++) {


                String visitedDay;

                if (currentAliceMM < 10) {
                    visitedDay = "0" + currentAliceMM;
                } else {
                    visitedDay = "" + currentAliceMM;
                }

                if (i < 10) {
                    visitedDay += "-0" + i;
                } else {
                    visitedDay += "-" + i;
                }

                allAliceDays.add(visitedDay);

                currentAlice = visitedDay;

                if (i == leaveAliceDD && currentAliceMM == leaveAliceMM) { //Смотрим это последний месяц и нужный день
                    break;
                }
            }

            if (currentAliceMM < leaveAliceMM) {
                currentAliceMM++;
                currentAliceDD = 1;
            }
        }


        Set<String> allBobDays = new HashSet<>();

        int currentBobDay = Integer.parseInt(arriveBob.replace("-", ""));
        ;
        int currentBobMM = Integer.parseInt(arriveBob.split("-")[0]);
        int currentBobDD = Integer.parseInt(arriveBob.split("-")[1]);

        //Когда уезжать
        int leaveBobMM = Integer.parseInt(leaveBob.split("-")[0]); //Месяц когда должны уехать
        int leaveBobDD = Integer.parseInt(leaveBob.split("-")[1]); //День когда должны уехать
        int leaveBobInt = Integer.parseInt(leaveBob.replace("-", ""));

        String currentBob = "";

        //Получили все дни для Alice
        while (!currentBob.equals(leaveBob)) {

            int totalDaysInMonth = daysInMonth[currentBobMM - 1];

            for (int i = currentBobDD; i <= totalDaysInMonth; i++) {
                String visitedDay;

                if (currentBobMM < 10) {
                    visitedDay = "0" + currentBobMM;
                } else {
                    visitedDay = "" + currentBobMM;
                }

                if (i < 10) {
                    visitedDay += "-0" + i;
                } else {
                    visitedDay += "-" + i;
                }

                allBobDays.add(visitedDay);

                currentBob = visitedDay;

                if (i == leaveBobDD && currentBobMM == leaveBobMM) {
                    break;
                }
            }

            if (currentBobMM < leaveBobMM) {
                currentBobMM++;
                currentBobDD = 1;
            }
        }


        int temp = allAliceDays.size();
        allAliceDays.removeAll(allBobDays);

        return temp - allAliceDays.size();
    }
}


/**
 *
 * int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
 *
 *         //Складываем сюда все дни по Алисе
 *         Set<Integer> allAliceDays = new HashSet<>();
 *
 *         //Текущий день + месяц  ALice
 *         int currentAliceDay = Integer.parseInt(arriveAlice.replace("-", "")); //День приезда отображаем в числах.
 *
 *         //Текущий месяц и день
 *         int currentAliceMM = Integer.parseInt(arriveAlice.split("-")[0]); //Парсинг месяца
 *         int currentAliceDD = Integer.parseInt(arriveAlice.split("-")[1]); //Парсинг дня
 *
 *         //Когда уезжать
 *         int leaveAliceMM = Integer.parseInt(leaveAlice.split("-")[0]); //Месяц когда должны уехать
 *         int leaveAliceDD = Integer.parseInt(leaveAlice.split("-")[1]); //День когда должны уехать
 *         int leaveAliceInt = Integer.parseInt(leaveAlice.replace("-", ""));
 *
 *
 *         //Пока текущий день не равняется последнему дню отъезда
 *         while (currentAliceDay != leaveAliceInt) {
 *
 *             int totalDaysInMonth = daysInMonth[currentAliceMM - 1]; //Получили сколько дней в месяце
 *
 *             //Идем по дням в месяце. Старт наш текущий день у алисы и до конца месяца итерируемся.
 *             //Выходим когда дни совпадут
 *             for (int i = currentAliceDD; i <= totalDaysInMonth; i++) {
 *
 *                  String visitedDay;
 *                 if (i < 9) {
 *                     visitedDay = currentAliceMM + "0" + i;
 *                 } else {
 *                     visitedDay = currentAliceMM + "" + i;
 *                 }
 *
 *
 *                 int visitedDayInt = Integer.parseInt(visitedDay);
 *                 allAliceDays.add(visitedDayInt);
 *                 currentAliceDay = visitedDayInt;
 *                 if (i == leaveAliceDD) {
 *                     break;
 *                 }
 *             }
 *
 *             if (currentAliceMM < leaveAliceMM) {
 *                 currentAliceMM++;
 *                 currentAliceDD = 1;
 *             }
 *         }
 *
 *
 *
 *         Set<Integer> allBobDays = new HashSet<>();
 *
 *         int currentBobDay = Integer.parseInt(arriveBob.replace("-", ""));;
 *         int currentBobMM = Integer.parseInt(arriveBob.split("-")[0]);
 *         int currentBobDD = Integer.parseInt(arriveBob.split("-")[1]);
 *
 *         //Когда уезжать
 *         int leaveBobMM = Integer.parseInt(leaveBob.split("-")[0]); //Месяц когда должны уехать
 *         int leaveBobDD = Integer.parseInt(leaveBob.split("-")[1]); //День когда должны уехать
 *         int leaveBobInt = Integer.parseInt(leaveBob.replace("-", ""));
 *
 *         //Получили все дни для Alice
 *         while (currentBobDay != leaveBobInt) {
 *
 *             int totalDaysInMonth = daysInMonth[currentBobMM - 1];
 *
 *             for (int i = currentBobDD; i <= totalDaysInMonth; i++) {
 *
 *                 String visitedDay;
 *                 if (i < 9) {
 *                     visitedDay = currentBobMM + "0" + i;
 *                 } else {
 *                     visitedDay = currentBobMM + "" + i;
 *                 }
 *
 *
 *                 int visitedDayInt = Integer.parseInt(visitedDay);
 *                 allBobDays.add(visitedDayInt);
 *                 currentBobDay = visitedDayInt;
 *
 *                 if (i == leaveBobDD) {
 *                     break;
 *                 }
 *             }
 *
 *             if (currentBobMM < leaveBobMM) {
 *                 currentBobMM++;
 *                 currentBobDD = 1;
 *             }
 *         }
 *
 *
 *         int temp = allAliceDays.size();
 *         allAliceDays.removeAll(allBobDays);
 *
 *         return temp - allAliceDays.size();
 */