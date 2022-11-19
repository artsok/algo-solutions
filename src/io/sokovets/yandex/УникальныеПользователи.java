package io.sokovets.yandex;

import java.util.*;

public class УникальныеПользователи {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        List<String> emails = new ArrayList<>();


        int N  = scan.nextInt();


        while (N != 0) {
            emails.add(scan.next().trim());
            N--;
        }

        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {

            if(!email.toLowerCase().equals(email)) {
                continue;
            }

            if (email.length() < 4 && email.length() < 50) {
                continue;
            }



            String[] rawEmail = email.split("@");
            String login = rawEmail[0];
            String domainName = rawEmail[1];


            int lastIndex = domainName.lastIndexOf(".");
            String subSequenceDomain = domainName.substring(0, lastIndex).replaceAll("\\.", "");


            if (login.contains("-")) {
                int firstPlusSign = login.indexOf("-");
                login = login.substring(0, firstPlusSign);
            }

            login = login.replaceAll("\\.", "");

            uniqueEmails.add(login + "@" + subSequenceDomain);

        }

        System.out.println(uniqueEmails.size());

    }


}
