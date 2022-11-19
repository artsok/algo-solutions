package io.sokovets.leetcode.easy.easy;

public class LongestCommonPrefix14 {

    public static void main(String[] args) {

    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 2) {
            return strs[0];
        }

        String words1 = strs[0];
        String words2 = strs[1];

        int minSize = Math.min(words1.length(), words2.length());

        StringBuilder commonPrefix = new StringBuilder();

        for (int i = 0; i < minSize; i++) {
            if (words1.charAt(i) == words2.charAt(i)) {
                commonPrefix.append(words1.charAt(i));
            } else {
                break;
            }
        }

        if (commonPrefix.length() == 0) {
            return "";
        }

        //Итерируемся со второго слова
        for (int i = 2; i < strs.length; i++) {

            //Берем префикс и идем от последнего к первому
            for (int k = minSize; k >= 0; k--) {

                //Совподает ли текущее слово с нашим префиксом, который мы нашли раньше из первых двух слов
                if (strs[i].startsWith(commonPrefix.toString())) {
                    break;
                }

                commonPrefix.deleteCharAt(k);
            }

            if (commonPrefix.length() == 0) {
                return "";
            }
        }

        return commonPrefix.toString();

    }
}
