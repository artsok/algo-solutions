package io.sokovets.yandex;

import java.io.*;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;


public class КамниИукрашения {
    public static void main(String[] args)  throws Exception  {
        Scanner scan = new Scanner(System.in);
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        char[] jewels = null;
        char[] stones = null;


        int result = 0;

        while (scan.hasNext()) {

            jewels = scan.next().toCharArray();
            if (scan.hasNext()) {
                stones = scan.next().toCharArray();
            }
        }



        if (!Objects.isNull(jewels) && !Objects.isNull(stones)) {
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
        } else {
            System.out.println(result);
        }
        scan.close();
    }
}


/**
 *     public static void main(String[] args) throws Exception {
 *         BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
 *
 *         String J = r.readLine();
 *         String S = r.readLine();
 *
 *         int result = 0;
 *         for (int i = 0; i < S.length(); ++i) {
 *             char ch = S.charAt(i);
 *             if (J.indexOf(ch) >= 0) {
 *                 ++result;
 *             }
 *         }
 *
 *         System.out.println(result);
 *     }
 */