package io.sokovets.leetcode.easy.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LongestPalindromebyConcatenatingTwoLetterWords2131 {

    public static void main(String[] args) {
        String[] a = new String[]{"ab", "ty", "yt", "lc", "cl", "ab", "ac"};
        String[] b = new String[]{"lc"};
        String[] c = new String[]{"lc", "cl", "gg"};
        String[] d = new String[]{"cc", "ll", "xx"};
        String[] e = new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"};
        String[] f = new String[]{"em", "pe", "mp", "ee", "pp", "me", "ep", "em", "em", "me"}; //14
        String[] g = new String[]{"qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf", "of", "of", "oo", "of", "of", "qf", "qf", "of"}; //14

        System.out.println(new LongestPalindromebyConcatenatingTwoLetterWords2131().longestPalindrome(g));
    }


    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        Map<String, Integer> map1 = new HashMap<>();

        int maxLength = 0;

        //ba
        //yt


//        for(String word : words) {
//            if(map1.containsKey(word)) {
//                // When reverse is available, it means 4 letter word can be added in palindrome
//
//                map1.put(word, map1.get(word) - 1);
//                if(map1.get(word) == 0) {
//                    map1.remove(word);
//                }
//            } else {
//                StringBuilder sb = new StringBuilder();
//                sb.append(word.charAt(1)).append(word.charAt(0));
//                map1.put(sb.toString(), map1.getOrDefault(sb.toString(), 0) + 1);
//            }
//        }

        for (String word : words) {
            if (!map.containsKey(word)) {
                String reverse = new StringBuilder(word).reverse().toString();
                map.merge(reverse, 1, Integer::sum);
            } else {
                maxLength += 4;
                map.put(word, map.get(word) - 1);

                if (map.get(word) == 0) {
                    map.remove(word);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int totalCount = entry.getValue();
            if (word.charAt(0) == word.charAt(1) && totalCount != 0) {
                maxLength += 2;
                break;
            }
        }

        return maxLength;
    }


    /**
     *  Так заметки
     for (Map.Entry<String, Integer> entry : map.entrySet()) {
     int totalCount = entry.getValue();
     String word = entry.getKey();


     if (totalCount / 2 != 0) {
     if (word.charAt(0) == word.charAt(1)) {
     maxLength += totalCount * 2;
     } else {
     maxLength += (totalCount / 2) * 4;
     }

     }
     }

     //Find palindrome word
     for (
     Map.Entry<String, Integer> entry : map.entrySet()) {
     String word = entry.getKey();
     if (word.charAt(0) == word.charAt(1)) {
     maxLength += 2;
     break;
     }
     }
     */

//    public int longestPalindrome(String[] words) {
//        //"lc",-1
//        //"cl",-1
//
//        //"gg"
//
//        //map:lc ->2
//        //map:gg ->1
//
//        //["ab","ty","yt","lc","cl","ab"]
//        //words = ["cc","ll","xx"]
//
//        //ab - 1
//
//
//        Map<String, Integer> map = new ConcurrentHashMap<>();
//
//        int maxLength = 0;
//
//        for(String word : words) {
//            if(map.containsKey(word)) {
//                // When reverse is available, it means 4 letter word can be added in palindrome
//                //result += 4;
//                map.put(word, map.get(word) - 1);
//                if(map.get(word) == 0) {
//                    map.remove(word);
//                }
//            } else {
//                StringBuilder sb = new StringBuilder();
//                sb.append(word.charAt(1)).append(word.charAt(0));
//                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
//            }
//        }
//
//
////        for (int i = 0; i < words.length; i++) {
////
////            if (map.size() == 0) {
////                map.put(words[i], 1);
////                continue;
////            }
////
////            StringBuilder sb = new StringBuilder(words[i]);
////            String reverseWord = sb.reverse().toString();
////
////            if (!map.containsKey(words[i])) {
////                if (map.containsKey(reverseWord)) {
////                    map.merge(reverseWord, 1, Integer::sum);
////                    continue;
////                }
////
////                map.merge(words[i], 1, Integer::sum);
////            }
//
////            } else {
////
////                String word = words[i];
////                if (word.charAt(0) == word.charAt(1)) {
////                    map.merge(words[i], 1, Integer::sum);
////                } else {
////                    map.merge(words[i], 1, (a, b) -> a - 1);
////                }
////            }
//    //    }
//
//
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//
//            int totalNumberOfCharacters = entry.getValue() * 2;
//            maxLength += (totalNumberOfCharacters / 4) * 4;
//
//            if (totalNumberOfCharacters % 4 == 0) {
//                map.remove(entry.getKey());
//            } else {
//                map.put(entry.getKey(), totalNumberOfCharacters % 4 / 2);
//            }
//        }
//
//
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            String letters = entry.getKey();
//            if (letters.charAt(0) == letters.charAt(1)) {
//                maxLength += 2;
//                break;
//            }
//
//        }
//
//
//        return maxLength;
//    }
}
