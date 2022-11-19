package io.sokovets.leetcode.easy.medium;

import java.util.*;

/**
 * You have a chat log of n messages. You are given two string arrays messages and senders where messages[i] is a message sent by senders[i].
 * <p>
 * A message is list of words that are separated by a single space with no leading or trailing spaces. The word count of a sender is the total number of words sent by the sender. Note that a sender may send more than one message.
 * <p>
 * Return the sender with the largest word count. If there is more than one sender with the largest word count, return the one with the lexicographically largest name.
 * <p>
 * Note:
 * <p>
 * Uppercase letters come before lowercase letters in lexicographical order.
 * "Alice" and "alice" are distinct.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: messages = ["Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"], senders = ["Alice","userTwo","userThree","Alice"]
 * Output: "Alice"
 * Explanation: Alice sends a total of 2 + 3 = 5 words.
 * userTwo sends a total of 2 words.
 * userThree sends a total of 3 words.
 * Since Alice has the largest word count, we return "Alice".
 * Example 2:
 * <p>
 * Input: messages = ["How is leetcode for everyone","Leetcode is useful for practice"], senders = ["Bob","Charlie"]
 * Output: "Charlie"
 * Explanation: Bob sends a total of 5 words.
 * Charlie sends a total of 5 words.
 * Since there is a tie for the largest word count, we return the sender with the lexicographically larger name, Charlie.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == messages.length == senders.length
 * 1 <= n <= 104
 * 1 <= messages[i].length <= 100
 * 1 <= senders[i].length <= 10
 * messages[i] consists of uppercase and lowercase English letters and ' '.
 * All the words in messages[i] are separated by a single space.
 * messages[i] does not have leading or trailing spaces.
 * senders[i] consists of uppercase and lowercase English letters only.
 */
public class SenderWithLargestWordCount2284 {


    //Если по кол-ву слов одинаково, то вернуть у кого самое длинное имя по принципу lexicographically largest name

    public static void main(String[] args) {

        //String[] senders = new String[]{"OXlq", "IFGaW", "XQPeWJRszU", "Gb", "HArIr", "Gb", "FnZd", "FnZd", "HArIr", "OXlq", "IFGaW", "XQPeWJRszU", "EMoUs", "Gb", "EMoUs", "EMoUs"};
        //String[] messages = new String[]{"tP x M VC h lmD", "D X XF w V", "sh m Pgl", "pN pa", "C SL m G Pn v", "K z UL B W ee", "Yf yo n V U Za f np", "j J sk f qr e v t", "L Q cJ c J Z jp E", "Be a aO", "nI c Gb k Y C QS N", "Yi Bts", "gp No g s VR", "py A S sNf", "ZS H Bi De dj dsh", "ep MA KI Q Ou"};

        //String[] messages = new String[]{"How is leetcode for everyone", "Leetcode is useful for practice"};
        //String[] senders = new String[]{"Bob", "Charlie"};

        String[] messages = new String[]{"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"};
        String[] senders = new String[]{"Alice", "userTwo", "userThree", "Alice"};

        //String[] messages =  new String[]{"l","E","e","L","U","B","H","H","l","I","E","c","s","t","s","u","r","F","Q","v","K","x","M","r","o","k","o","E","x","f"};
        //String[] senders = new String[]{"TYproPIptp","ZinKBnptgb","MabHvYDOvr","KJsXlcnoLX","IMjvhaCNQU","qWTfyhzuge","CBCPpuHdKb","HpDxmDTUwp","SgOTFxFYpl","PctQGYkMuz","KqAEViZnnc","DVTKOJLZPc","InJQqHsICO","bNhncDzkLu","IvbKSkMTWM","nOjJjZjQTa","ekqBBwyCYb","zADZhwSwFj","LswFXzVDyF","bhIcpZBHWb","mesrFSlmqJ","OZZKylOPUj","OVDIlCRBro","IIhwLrjgHo","HrXZYYiXnT","pmHsmhKLoB","ppIkHHnBqQ","gNGHfhhxEL","VSZuisvhuQ","qaPorTEGcL"};

        System.out.println(new SenderWithLargestWordCount2284().largestWordCount(messages, senders));
    }


    //Отсортировать по максимальным кол-вам слов
    //Отсортировать по самому длинному слову
    //Отсортировать по легографическмоу


    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> senderWithWordCount = new HashMap<>();


        for (int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");
            senderWithWordCount.merge(senders[i], words.length, Integer::sum);
        }

        int maxValue = Collections.max(senderWithWordCount.values());

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));

        for (Map.Entry<String, Integer> entry : senderWithWordCount.entrySet()) {
            if (entry.getValue() == maxValue) {
                pq.add(entry.getKey());
            }
        }


        return pq.poll();
    }

}
