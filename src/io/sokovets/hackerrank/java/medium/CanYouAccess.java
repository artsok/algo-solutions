package io.sokovets.hackerrank.java.medium;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;

/**
 * You are given a class Solution and an inner class Inner.Private. The main method of class Solution takes an integer  as input.
 * The powerof2 in class Inner.Private checks whether a number is a power of .
 * You have to call the method powerof2 of the class Inner.Private from the main method of the class Solution.
 *
 * https://www.hackerrank.com/challenges/can-you-access/problem?isFullScreen=true
 */
public class CanYouAccess {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private


            //https://stackoverflow.com/questions/14112166/instantiate-private-inner-class-with-java-reflection
            Inner inner = (Inner) Inner.class.newInstance(); //Создали объект статичческого класса
            Class<?> innerClass = Inner.class.getDeclaredClasses()[0]; //далее взяли у него класс, предпологаем что он один.
            Constructor<?> constructor = innerClass.getDeclaredConstructors()[0]; //Далее взяли конструктор у класса.
            constructor.setAccessible(true); //сделали к нему доступ
            o = constructor.newInstance(inner); //создали объект нашего приватного класса

            Method method = o.getClass().getDeclaredMethod("powerof2", int.class); //Нашли метод у приватного класса
            method.setAccessible(true); //получи доступ к нему
            Object result = method.invoke(o, num); //Вызвали метод и передали туда параметр
            System.out.println(num + " is " + result); //Напечатали результат

            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main
    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}