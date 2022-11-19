package io.sokovets.interviewbit;

import java.time.LocalTime;

public class PalindromicTime {

    public static void main(String[] args) {
        //String hours = "21:00";
        //String hours = "23:59";
        //String hours = "00:00";
        //String hours = "10:10";
        String hours = "05:51"; //10:01

        System.out.println(new PalindromicTime().solve(hours));

    }

    public int solve(String A) {

        String[] time = A.split(":");
        Integer hours = Integer.parseInt(time[0]);
        Integer hv = hours;
        Integer minutes = Integer.parseInt(time[1]);

        if (hours == 0 && minutes == 0) {
            return 0;
        }

        if (hours == 23 && minutes == 59) {
            return 1;
        }

        char[] hoursInCharArray = time[0].toCharArray(); //01
        int reversedHours = swap(hoursInCharArray[0], hoursInCharArray[1]); //10

        if (reversedHours == minutes) {
            return 0;
        }

        int palindromicTime = reversedHours - minutes; //12 - 23 = -11

        if (palindromicTime > 0) {
            return palindromicTime;
        } else {
            for (int i = 0; ; i++) {
                hours = hours + i;
                if (hours <= 9) {
                    hoursInCharArray = ("0" + hours).toCharArray();
                } else {
                    hoursInCharArray = String.valueOf(hours).toCharArray();
                }

                reversedHours = swap(hoursInCharArray[0], hoursInCharArray[1]);
                if (reversedHours == 60) {
                    continue;
                }
                palindromicTime = reversedHours - minutes; //-1

                int suggestTime = 0;
                if (palindromicTime < 0) {
                    suggestTime = i*60 + palindromicTime;
                } else {
                    suggestTime =  i*60 + palindromicTime;
                }

                if (!checkIfPalindromic(hv, minutes, suggestTime)) {
                    continue;
                }
            }
        }
    }

    private boolean checkIfPalindromic(int hours, int time, int suggestTime) {
        String date = LocalTime.of(hours, time).plusMinutes(suggestTime).toString();
        System.out.println(date);


        return false;
    }


    private int swap(char a, char b) {
        return Integer.parseInt("" + b + a);
    }
}
