package io.sokovets.yandex.backend.autumn;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int line = scan.nextInt();
        System.out.println(line);

        while (scan.hasNext()) {
            System.out.println(scan.next());
        }

        scan.close();
    }
}
