package io.sokovets.hackerrank;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        if (scanner.hasNextLine()) {
            String val = scanner.nextLine();
            System.out.printf("%d %s",++i, val);
        }
    }
}

