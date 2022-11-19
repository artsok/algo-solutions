package io.sokovets.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lets say performOps was called with A : [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]] .
 *
 * What would be the output of the following call :
 */
public class ARRAY_2D {

    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(0, Arrays.asList(1, 2, 3, 4));
        A.add(1, Arrays.asList(5, 6, 7, 8));
        A.add(2, Arrays.asList(9, 10, 11, 12));


        ArrayList<ArrayList<Integer>> B = new ARRAY_2D().performOps(A);
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.get(i).size(); j++) {
                System.out.print(B.get(i).get(j) + " ");
            }
        }
    }


    ArrayList<ArrayList<Integer>> performOps(List<List<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }
}
