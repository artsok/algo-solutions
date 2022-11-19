package io.sokovets.yandex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class МагическаяПодстрока {

    public static void main(String[] args) {


        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String T = "abcd";
        String S = "abef";


        StringBuilder sb = new StringBuilder(S);
        if (sb.reverse().toString().equals(T)) {
            System.out.println("-1");
        } else {

            char[] chars = T.toCharArray();
            Map<Character, Integer> map = new HashMap<>();

            for (char ch : chars) {
                map.merge(ch, 1, Integer::sum);
            }

            char[] magic = S.toCharArray();
            int minIndex = Integer.MAX_VALUE;

            int totalCount = 0;

            for (int i = 0; i < magic.length; i++) {

                if (map.containsKey(magic[i])) {
                    //ccde
                    map.merge(magic[i], 1, (a, b) -> a - 1);

                    totalCount++;

                    int count = map.get(magic[i]);
                    if (count == 0) {
                        map.remove(magic[i]);
                    }
                    minIndex = Math.min(T.indexOf(magic[i]), minIndex);
                }

                if (totalCount == 3) {
                    break;
                }
            }

            if (totalCount == 3) {
                System.out.println(minIndex);
            } else {
                System.out.println("-1");
            }

        }

    }
}
