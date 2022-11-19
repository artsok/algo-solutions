package io.sokovets.yandex.practicum.introduction;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Допустим, мы проводим онлайн-конкурс работ молодых художников.
 * Всего представлено NN работ, которые идентифицируются числами от 00 до N-1N−1 включительно. Нужно поддержать 3 типа запроса:
 * <p>
 * Лайк работы с идентификатором id.
 * Дизлайк работы с идентификатором id.
 * <p>
 * Вернуть лучшие KK работ.
 * Оценку работы будем считать просто: число лайков минус число дизлайков.
 */
public class ОнлайнКонкурсРаботМолодыхХудожников {

    int[] allPictures;

    public ОнлайнКонкурсРаботМолодыхХудожников(int size) {
        allPictures = new int[size];
    }

    public static void main(String[] args) {
        ОнлайнКонкурсРаботМолодыхХудожников a = new ОнлайнКонкурсРаботМолодыхХудожников(5);
        a.like(0);
        a.like(0);
        a.like(0);

        a.like(4);
        a.like(4);

        a.like(2);
        a.like(2);
        a.dislike(2);

        System.out.println(Arrays.toString(a.getBestWork(2)));
    }

    void like(int id) {
        allPictures[id] += 1;
    }

    void dislike(int id) {
        allPictures[id] -= 1;
    }

    int[] getBestWork(int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for (int i = 0; i < allPictures.length; i++) {
            Map.Entry<Integer, Integer> entry = Map.entry(i, allPictures[i]);
            priorityQueue.add(entry);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().getKey();
        }

        return result;
    }
}
