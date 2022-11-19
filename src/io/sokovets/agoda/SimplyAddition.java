package io.sokovets.agoda;

// ## Question
// You are given two positive number n and m.
// You have to find simply addition of both number but with a given condition that there is not any carry system in this addition.

// ## Examples
// Input: m = 456, n = 854
// Output: 200
// ```
// Input: m = 456 , n = 4
// Output: 450


// 4 5 6
//     4
// 2 0 1

// Main class should be named 'Solution'
public class SimplyAddition {


    public static void main(String[] args) {
        System.out.println(new SimplyAddition().simplyAddition(8458, 8732));
    }

    int simplyAddition(int n, int m) {

        StringBuilder sb = new StringBuilder();

        int index = 0;

        String max = String.valueOf(Math.max(n, m));

        while (n != 0 && m != 0) {
            int n1 = n % 10;
            int m1 = m % 10;
            sb.append((n1 + m1) % 10);
            n = n / 10;
            m = m / 10;
            index++;
        }

        return Integer.parseInt(max.substring(0, max.length() - index).concat(sb.reverse().toString()));
    }


    //https://www.geeksforgeeks.org/special-addition-two-number/
    public static int xSum(int n, int m) {
        int res = 0;
        int multiplier = 1;
        int bit_sum;

        // Add numbers till each
        // number become zero
        while (true) {

            if (n == 0 && m == 0)
                break;

            // Add each bits
            bit_sum = (n % 10) + (m % 10);

            // Neglect carry
            bit_sum %= 10;

            // Update result
            res = (bit_sum * multiplier) + res;
            n /= 10;
            m /= 10;

            // Update multiplier
            multiplier *= 10;

        }
        return res;
    }

}
