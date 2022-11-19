package io.sokovets.timecomplexity;

//answer: O(N), because second loop waits when "i" will be half of n. Половину будет выполнено в первом while (так как тут делам n на 2),
// а внутренний while тоже будет отработать только на половину значений, которые в него поступят. В итоге будет N/2+N/2~O(N)
public class WhileLoop {
    public static void main(String[] args) {
        int n = 6;
        int i = 0;
        while (i < n / 2){
            System.out.println("outer loop");
            //result += arr[i];
            i += 1;
            while (i >= n / 2 && i < n){
                System.out.println("inner loop");
                i += 1;
            }
        }
    }
}

/**
 *     Здесь будет Q(LogN), так как каждый раз делим на 2 кол-в наших элементов.
 *
 *      int a = 0, i = N;
 *         while (i > 0) {
 *             a += i;
 *             i /= 2;
 *         }
 */