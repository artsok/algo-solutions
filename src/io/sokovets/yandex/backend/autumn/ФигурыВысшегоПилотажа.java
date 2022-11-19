package io.sokovets.yandex.backend.autumn;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.parseInt;

public class ФигурыВысшегоПилотажа {

    private static class Attender {

        String name;
        int score;
        int mistake;

        public Attender(String name, String score, String mistake) {
            this.name = name;
            this.score = parseInt(score);
            this.mistake = parseInt(mistake);
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public int getMistake() {
            return mistake;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attender attenders = (Attender) o;
            return name.equals(attenders.name) && score == attenders.score && mistake == attenders.mistake;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, score, mistake);
        }
    }


    public static void main(String[] args) throws IOException {
        String[] line = Files.readString(Paths.get("/Users/19434089/IdeaProjects/HackerrankTasks/src/io/sokovets/yandex/backend/autumn/input.txt")).split("\n");

        Map<String, Integer> disciplineWithMaxCount = new HashMap<>();

        int index = 1;
        int countOfTypes = parseInt(line[0]);


        while (countOfTypes >= index) {
            String info = line[index];
            String[] infoArray = info.split(",");
            disciplineWithMaxCount.put(infoArray[0], Integer.valueOf(infoArray[1]));
            index++;
        }

        int attendersCount = parseInt(line[index]);
        index++;

        int srartPosition = index;

        index = 0;

        //Создали
        Map<String, PriorityQueue<Attender>> map = new HashMap<>();

        while (attendersCount > index) {
            String attenderLine = line[srartPosition];
            String[] attenderInfo = attenderLine.split(",");
            //helios,racing,12,135

            Attender attender = new Attender(attenderInfo[0], attenderInfo[2], attenderInfo[3]);

            String discipline = attenderInfo[1];

            PriorityQueue<Attender> priorityQueue;
            if (map.containsKey(discipline)) {
                priorityQueue = map.get(discipline);
            } else {
                priorityQueue = new PriorityQueue<>((a, b) -> compareAttenders(a, b));
            }
            priorityQueue.add(attender);
            map.put(discipline, priorityQueue);
            index++;
            srartPosition++;
        }

        List<String> result = new ArrayList<>();

        //Идем по всм дисциплинам, которые у нас были
        for (Map.Entry<String, Integer> entry : disciplineWithMaxCount.entrySet()) {

            //Получили по дисциплине участников отсортированных по значению
            PriorityQueue<Attender> attenders = map.get(entry.getKey());

            //далее согласно кол-ву мест берем участников которые нам подходят
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(attenders.poll().getName());
            }
        }

        result.sort(String.CASE_INSENSITIVE_ORDER);

        System.out.println(result);

        //result.sort();  отсортированные в лексикографическом порядке независимо от своего приоритета при отборе и выбранной ими специальной дисциплине.
    }

    private static int compareAttenders(Attender a, Attender b) {

        if (a.getScore() != b.getScore()) {
            return b.getScore() - a.getScore(); //Сначала сортируем кто имеет больше score
        } else {
            return a.getMistake() - b.getMistake(); //Затем сортируем кто имеет меньше ошибок
        }
    }

}
