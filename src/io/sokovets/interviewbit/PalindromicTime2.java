package io.sokovets.interviewbit;

public class PalindromicTime2 {
    //Как найти последний и первый символ: https://javahungry.blogspot.com/2020/12/find-first-and-last-digit-of-number-in-java.html. Простые решения

    public static void main(String[] args) {
        String time = "21:59";
        System.out.println(new PalindromicTime2().solve(time));
    }

    public int solve(String a) {
        String[] hhMM = a.split(":");
        int hh = Integer.parseInt(hhMM[0]);
        int mm = Integer.parseInt(hhMM[1]);

        int reqTime=0;


        // while(hh%10!=mm/10 || hh/10!=mm%10){    // This condition is basically
        // to check pallindromic condition because FIRST digit of hh should be
        // equal to LAST digit of mm and SECOND digit of hh should be FIRST
        // digit of mm for the pallindrom


        while (hh/10 != mm%10 || hh%10 !=mm/10) { //1 = 4, 2 = 3
            mm++;
            if (mm == 60) {
                mm = 0;
                hh++;
            }
            if (hh == 24) {
                hh = 0;
            }
            reqTime++;
        }

        return reqTime;
    }


    //Мое решение;
//    public int solve(String A) {
//        String[] time = A.split(":");
//        Map<String, String> palindromicTime = findAllPalindromicTime();
//        String key = time[0];
//        int result;
//        int index = 1;
//        do {
//            if (!palindromicTime.containsKey(key)) {
//                while (!palindromicTime.containsKey(key) && Integer.parseInt(key) > 23) {
//                    int hours = Integer.parseInt(key);
//                    hours += 1;
//                    if (hours > 9) {
//                        key = String.valueOf(hours);
//                    } else {
//                        key = "0" + hours;
//                    }
//                }
//            }
//
//
//            String palindromicMinutes = palindromicTime.get(key);
//            if (palindromicMinutes == null) {
//                if (Integer.parseInt(time[0]) == 23 && Integer.parseInt(time[1]) > 32) {
//                    return  60 - Integer.parseInt(time[1]);
//                }
//
//                while (!palindromicTime.containsKey(key)) {
//                    int hours = Integer.parseInt(key);
//                    hours += 1;
//                    if (hours > 9) {
//                        key = String.valueOf(hours);
//                    } else {
//                        key = "0" + hours;
//                    }
//                    palindromicMinutes = palindromicTime.get(key);
//                }
//
//            }
//
//            int palindromTime = Integer.parseInt(key) * 60 + Integer.parseInt(palindromicMinutes);
//            int currentTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
//            result = palindromTime - currentTime;
//            if (result < 0 ) {
//                palindromicTime.remove(key);
//            }
//            index++;
//        } while (result < 0);
//
//        return result;
//    }
//
//    private Map<String, String> findAllPalindromicTime() {
//        String startTime = "00";
//        String endTime = "00";
//        Map<String, String> allPalindromicTime = new LinkedHashMap<>();
//        allPalindromicTime.put("00", "00");
//        for (int i = 1; i < 24; i++) {
//
//            if (i < 10) {
//                startTime = "0" + i;
//            } else {
//                startTime = "" + i;
//            }
//
//
//            endTime = swap(startTime);
//            if (Integer.parseInt(endTime) >= 59) {
//                continue;
//            }
//            allPalindromicTime.put(startTime, endTime);
//        }
//        return allPalindromicTime;
//    }
//
//    private String swap(String endTime) {
//        char[] chars = endTime.toCharArray();
//        return new String(new char[]{chars[1], chars[0]});
//    }


}


