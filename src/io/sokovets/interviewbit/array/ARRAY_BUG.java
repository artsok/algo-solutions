package io.sokovets.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ARRAY_BUG {

    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(28, 68, 100, 90, 46, 58, 54, 74);

        //54 74 28 68 100 90 46 58

        System.out.println(new ARRAY_BUG().rotateArray(arrayList, 78));
    }

    public List<Integer> rotateArray(List<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (B > A.size())
            B = B % A.size();

        for (int i = 0; i < A.size(); i++) {
            if (B + i >= A.size()) ////Если сдвиг и текущий индекс больше размера листа
                ret.add(A.get(i + B - A.size())); //
            else //Если сдвиг и текущий индекс не больше размера листа
                ret.add(A.get(i + B));
        }


        return ret;
    }
}
