package io.sokovets.codility;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Однодневная тренировка будет проводиться дважды в течение следующих 10 дней.
 * Есть N сотрудников (пронумерованных от 0 до N−1), желающих принять в нем участие.
 * Каждый сотрудник предоставил список того, в какой из следующих 10 дней он сможет принять участие в тренинге.
 * Предпочтения сотрудников представлены в виде массива строк. E[K] - это строка, состоящая из цифр ('0-9'),
 * представляющий дни, в которые K-й сотрудник может посещать обучение.
 * <p>
 * Даты, в течение которых будет проходить тренинг, еще не назначены.
 * Каково максимальное количество сотрудников, которые могут присутствовать хотя бы в течение одного из двух запланированных дней?
 */
public class ScheduleTraining {


    public static void main(String[] args) {
        String[] a = {"039", "4", "14", "32", "", "34", "7"};
        System.out.println(new ScheduleTraining().solution(a));
    }

    public int solution(String[] E) {
        Map<Integer, List<Integer>> employees = new HashMap<>();

        int index = 0;
        for (String days : E) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < days.length(); i++) {
                int k = Integer.parseInt(String.valueOf(days.charAt(i)));
                list.add(k);
            }
            employees.put(index, list);
            index++;
        }

        Map<Integer, Integer> counts = new ConcurrentHashMap<>();

        for (List<Integer> values : employees.values()) {
            for (int n : values) {
                counts.merge(n, 1, Integer::sum);
            }
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                counts.remove(entry.getKey());
            }
        }


        Map<String, String> result = new HashMap<>();
        List<String> commonDays = counts.keySet()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        for (String employeesDays : E) {
            for (String mostActiveDay : commonDays) {
                if (employeesDays.contains(mostActiveDay)) {
                    result.put(employeesDays, mostActiveDay);
                }
            }
        }
        return result.entrySet().size();
    }

}
