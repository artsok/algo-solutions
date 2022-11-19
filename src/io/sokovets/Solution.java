package io.sokovets;

import java.util.*;

enum Event {
    ENTER, SERVED
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
//Переписать на PriorityQueue
class Priorities {

    private final Comparator<Student> cgpa = ((o1, o2) -> {
        return Double.compare(o2.getCGPA(), o1.getCGPA());
    });
    private final Comparator<Student> id = Comparator.comparingInt(Student::getID);
    private final Comparator<Student> alphabetical_order = Comparator.comparing(Student::getName);

    private final List<Student> students = new LinkedList<>();

    List<Student> getStudents(List<String> students) {
        for (String line : students) {
            String[] data = line.split("\\s");
            String eventName = data[0];

            if (eventName.equals(Event.ENTER.name())) {
                this.students.add(new Student(
                        Integer.parseInt(data[3]),
                        data[1],
                        Double.parseDouble(data[2])));
            } else if (eventName.equals(Event.SERVED.name())) {
                this.students.sort(cgpa
                        .thenComparing(alphabetical_order)
                        .thenComparing(id));
                int FI = 0;
                if (this.students.size() > 0) {
                    this.students.remove(FI);
                }
            }
        }

        return new ArrayList<>(this.students);
    }
}

class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCGPA() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}

