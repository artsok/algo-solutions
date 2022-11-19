package io.sokovets.theory;

//Наибольший общий делитель (Greatest common divisor)
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        int a = new GreatestCommonDivisor().findGcd(5,10);
        System.out.println(a);
    }

    //Наибольший общий делитель
    private int findGcd(int a, int b){
        while(b != 0){
            int rem = a%b;
            a = b;
            b = rem;
        }

        return a;
    }
}
