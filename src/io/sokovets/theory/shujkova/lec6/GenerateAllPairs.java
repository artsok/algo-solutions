package io.sokovets.theory.shujkova.lec6;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://javascopes.com/java-array-permutations-75fc7e7f/
public class GenerateAllPairs {

    public static void main(String[] args) {
        int a[] = {1, 2, 3};

        //new GenerateAllPairs().printAllRecursive(a, 3);
        //System.out.println("mm");
        //new GenerateAllPairs().perm(a, 3);
        //System.out.println("mm");
        new GenerateAllPairs().generateAllWords("abf");



        //new GenerateAllPairs().perm(a, 3, memo);
        new GenerateAllPairs().generateAllWords("abc");
        System.out.println();
    }

    void generate(int t, int[] a) {
        int size = a.length - 1;
        if (t == size) {
            for (int i = 0; i < size; ++i) {
                System.out.println(Arrays.toString(a));
            }
        } else {
            for (int j = t - 1; j < a.length; ++j) {
                swapMe(t, j, a);
                t++;
                generate(t, a);
                swapMe(t, j, a);
            }
        }
    }

    public void printAllRecursive(int[] elements, int n) {

        if (n == 1) {
            System.out.println(Arrays.toString(elements));
        } else {
            for (int i = 0; i < n - 1; i++) {
                printAllRecursive(elements, n - 1);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            printAllRecursive(elements, n - 1);
        }

    }

    List<String> generateAllWords(String a) {

        List<int[]> memo = new ArrayList<>();

        int l = 0;
        int r = a.length();
        while (l < r) {
            String substring = a.substring(l, r);
            int[] index = new int[substring.length()];
            Arrays.setAll(index, i -> i);
            perm(index, index.length, memo);
            l++;
        }

        l = 0;
        r = a.length();
        while (l < r) {
            String substring = a.substring(l, r);
            int[] index = new int[substring.length()];
            Arrays.setAll(index, i -> i);
            perm(index, index.length, memo);
            r--;
        }

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int[] words: memo) {

            for (int i = 0; i < words.length; i++) {
                sb.append(a.charAt(words[i]));
            }
            result.add(sb.toString());
            sb.delete(0, words.length);
        }



        //perm();

        return null;
    }

    void perm(int[] lst, int n, List<int[]> hashSet) {
        int[] copy = Arrays.copyOf(lst, lst.length);
        if (n == 1) {
            hashSet.add(copy);
        } else {
            for (int j = n - 1; j >= 0; j--) {
                swap(lst, j, n - 1);
                perm(lst, n - 1, hashSet);
                swap(lst, j, n - 1);
            }
        }
    }

    private void swapMe(int i, int i1, int[] a) { //i = 5, i1 = 10
        a[i] = a[i] + a[i1];
        a[i1] = a[i] - a[i1];
        a[i] = a[i] - a[i1];
    }

    public final void swap(int[] a, int i, int j) {
        if (i >= 0 && j >= 0) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }


}
