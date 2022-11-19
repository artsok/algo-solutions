package io.sokovets;

import java.util.*;

public class Result {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();


        //System.out.println(updateTimes(Arrays.asList(1,2,3,4,5), Arrays.asList(5,4,3, 2, 1)));
        System.out.println(updateTimes(Arrays.asList(1,2,3,4,5), Arrays.asList(1,2,3,4,5)));
    }

    //select name, uin from employee left join employee_uin on employee.id = employee_uin.id where age < 25 order by name, imployee.id asc;


    public static int updateTimes(List<Integer> signalOne, List<Integer> signalTwo) {

        int index = 0;
        int maxFreq = 0;
        int countFreq = 0;

        while (index < signalOne.size() || index < signalTwo.size()) {

            int valueSignalOne = signalOne.get(index);
            int valueSignalTwo = signalTwo.get(index);

            if (valueSignalOne == valueSignalTwo) {

                if (valueSignalOne > maxFreq) {
                    maxFreq = Math.max(maxFreq, valueSignalOne);
                    countFreq++;
                }
            }
            index++;
        }

        return countFreq;
    }
    //public static int updateTimes(List<Integer> signalOne, List<Integer> signalTwo) {
        // Write your code here

        //Iterate all signalOne and signalOne
        //inroduce countNumber
        //inc count
        //handle maxValue

        //[3,2,3,3,3,5,4]
        //[3,2,3,4,3,5,4, 4]

//        Deque<Integer> deque = new ArrayDeque<>();
//
//        int index = 0;
//        //int updateFrequence = 0;
//
//
//        while (index < signalOne.size() || index < signalTwo.size()) {
//            int valueSignalOne = signalOne.get(index);
//            int valueSignalTwo = signalTwo.get(index);
//
//            if (valueSignalOne == valueSignalTwo) { //[1-1]
//                if (deque.isEmpty()) {
//                    deque.add(valueSignalOne); //1
//                    index++;
//                    continue;
//                }
//
//                if (deque.peekLast() > valueSignalOne) {
//                    continue;
//                } else {
//                    deque.add(valueSignalOne);
//                }
//            }
//
//            index++;
//        }
//
//        //System.out.println(deque.size());
//        return deque.size();
//    }

}

