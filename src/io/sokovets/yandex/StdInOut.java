package io.sokovets.yandex;

import java.util.*;

public class StdInOut {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();



        // Complete this line
        // Complete this line

        System.out.println(a);
        // Complete this line
        // Complete this line
    }

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] jewels = null;
        char[] stones = null;
        int result = 0;

        while(scan.hasNext()) {
            jewels = scan.next().toCharArray();
            stones = scan.next().toCharArray();
        }


        Set<Character> unicJewels = new HashSet<>();

        for (char ch : jewels) {
            unicJewels.add(ch);
        }


        for (int i = 0; i < stones.length; i++) {

            if (unicJewels.contains(stones[i])) {
                result += 1;
            }

        }
        System.out.println(result);


        scan.close();
    }

}
