package io.sokovets.leetcode.easy.medium;

import java.util.*;

/**
 * There are a total of numses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 * <p>
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 * <p>
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 * <p>
 * <p>
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 */

//https://www.youtube.com/watch?v=9HuVckRAhUY
public class CourseScheduleII210 {
    public static void main(String[] args) {
        int num = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}; //Пререквезиты, говорят, о том, что курс 1 зависит от курса 0, курс два зависит от курса 0, курс 3 зависит от курса 1 и 2
        System.out.println(Arrays.toString(new CourseScheduleII210().findOrder(num, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>(); //название курса и сколько раз он повторяется в пререквезитах
        Map<Integer, List<Integer>> adjList = new HashMap<>();//название курсу и от каких курсов он зависит

        //{{1, 0}, {2, 0}, {3, 1}, {3, 2}}
        for (int i = 0; i < numCourses; i++) {
             inDegree.put(i, 0); //Map = {0, 1}, {1, 0}, {2, 0}, {3, 0};
            adjList.put(i, new ArrayList<>()); //adjustment - корректировка, подгонка, регулирование Map = {0, new ArrayList() }, {1, new ArrayList() }, {2, new ArrayList() }, {3, new ArrayList()};
        }



       //{{1, 0}, {2, 0}, {3, 1}, {3, 2}} - примерные пререквезиты
        for (int[] p : prerequisites) {
            // с1 -c2. Потому-что мы знаем, что у нас всегда массиве из двуз значений
            int c1 = p[0]; //берем название курса
            int c2 = p[1]; //от какого курса зависит
            inDegree.merge(c1, 1, (a, b) -> a + b); //берем название курса и увеличиваем +1 если повторяется // inDegree Map = {1, 1}, {2, 1}, {3, 2}, {0, 0};
            adjList.get(c2).add(c1); //Например: курс 0 и от него будут зависить курсы 1 (Курс с2, позволяет нам пройти курс с названием с1) adjListMap = = {0, [1, 2]}, {1, [3]}, {2, [3])}, {3, new ArrayList()};
        }

        //В очереди текущие курсы(которые мы сможем пройти), если смотреть на очередь как на симуляцию.
        //Мы положим туда вначале все курсы , которые мы можем начать проходить.
        //Берём курс из очереди - это как бы его проходим в данный момент
        Queue<Integer> queue = new LinkedList<>(); //Создаем очередь курсов, которые можем пройти сразу.

        for (int i = 0; i < numCourses; i++) {
            if (inDegree.get(i) == 0) { //Если курс не зависит от тругого курса то мы готовы сразу его пройти
                queue.add(i);
            }
        }

        List<Integer> tmp = new ArrayList<>(); //Объявляем список для ответа

        while (!queue.isEmpty()) { //Пока очередь не будет пустой
            int c = queue.poll();
            tmp.add(c);
            for (int next : adjList.get(c)) { //Идем по всем курсам в списке и понижаем кол-во раз, сколько он повторяется
                inDegree.merge(next, -1, (a, b) -> (a + b)); //Например: курс 1, зависит от 0, изменяем кол-во его повторений
                if (inDegree.get(next) == 0) {  //смотрим, что если курс который взяли повторяется 0 раз, то добавляем в очередь
                    queue.add(next);
                }
            }
        }

        //преобразование arraylist в массив
        if (tmp.size() == numCourses) {
            int[] ans = new int[tmp.size()];
            for (int i = 0; i < tmp.size(); i++) {
                ans[i] = tmp.get(i);
            }
            return ans;
        }
        return new int[]{};
    }
}