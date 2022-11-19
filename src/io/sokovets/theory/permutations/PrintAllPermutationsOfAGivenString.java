package io.sokovets.theory.permutations;

public class PrintAllPermutationsOfAGivenString {

    public static void main(String[] args) {
        //Определили строку из которой надо сделать различные пермутации
        String str = "ABC";

        //Высичлили размер строки
        int n = str.length();

        PrintAllPermutationsOfAGivenString permutation = new PrintAllPermutationsOfAGivenString();
        permutation.permute(str, 0, n - 1);
    }


    /**
     * permutation function
     *
     * @param str string to calculate permutation for
     * @param l   starting index
     * @param r   end index
     */
    private void permute(String str, int l, int r) {
        if (l == r) //Если у нас указатель l и r совпадает, то нужно печатаем
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) { //i присваиваем l и i больше или равно r.
                str = swap(str, l, i); //Берем строку и вызываем перестановку для символов на позиции l и i
                permute(str, l + 1, r); //Вызываем опять сами себя и увеличиваем индекс l на 1
                str = swap(str, l, i); //Когда
            }
        }
    }

    public String swap(String a, int i, int j) {
        char temp; //Создаем временную переменную
        char[] charArray = a.toCharArray(); //Преобразуем массив в символы
        temp = charArray[i]; //далее сохраняем символ во временную переменную
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray); //И возвращаем новую строку
    }

}
