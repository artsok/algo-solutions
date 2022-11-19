package io.sokovets.codility;

import java.util.Arrays;
import java.util.Stack;


public class FixABugInArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6, 7, 9, 9};
        System.out.println(new FixABugInArray().solution(a, 5));
        //System.out.println(new FixABugInArray().solution(a, 6));
        //System.out.println(new FixABugInArray().solution(a, 10));
    }


    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1; //r=6
        while (l < r) { //0 < 2 //1 < 2
            int m = (l + r) / 2; //3   //1 //(1+2)/2 = 1
            if (A[m] > X) { //6 > 5  // 2 > 5
                r = m - 1; //r = 2
                System.out.println("r " + r);
            } else {
                l = m + 1; //l = 1 //l=1
                System.out.println("l " + l);
            }
        }
        if (A[r] == X) {
            return r;
        }
        return -1;
    }

    /*
    int solution(int[] A, int X) {
        int N = A.length;

        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N;

        while (l < r) {

            int m = l + (r - l) / 2;
            //int m = (l + r) / 2;


            if (A[m] > X) {
                r = m - 1;
            } else if (A[m] < X) {
                l = m + 1;
            }
        }


        return -1;
    }
    */

}
