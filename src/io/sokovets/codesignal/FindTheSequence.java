package io.sokovets.codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheSequence {

    public static void main(String[] args) {
        String a = "LLRRRLL";
        System.out.println(new FindTheSequence().findNumberSequence(a));
    }

    public List<Integer> findNumberSequence(String direction) {
        int n = (int) Math.pow(2, direction.length());

        int l = 0;
        int r = n;


        for (int i = 0; i < direction.length(); i++) {

            char way = direction.charAt(i);
            int center = l + (r - l) / 2; //32
            if (way == 'L') {
                System.out.println(r);
                r = center;
            } else {
                System.out.println(l);
                l = center;
            }
        }
        return Arrays.asList(l, r);
    }
}
