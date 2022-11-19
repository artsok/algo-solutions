package io.sokovets.yandex;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Stream;


/**
 * ак известно, два наиболее распространённых формата записи даты — это европейский (сначала день, потом месяц, потом год) и американски (сначала месяц, потом день, потом год). Системный администратор поменял дату на одном из бэкапов и сейчас хочет вернуть дату обратно. Но он не проверил, в каком формате дата используется в системе. Может ли он обойтись без этой информации?
 * Иначе говоря, вам даётся запись некоторой корректной даты. Требуется выяснить, однозначно ли по этой записи определяется дата даже без дополнительной информации о формате.
 * <p>
 * Формат ввода
 * Первая строка входных данных содержит три целых числа —
 *
 * . Гарантируется, что хотя бы в одном формате запись
 * x
 * y
 * z
 * задаёт корректную дату.
 * Формат вывода
 * Выведите 1, если дата определяется однозначно, и 0 в противном случае.
 * Пример 1
 * Ввод	Вывод
 * 1 2 2003
 * 0
 * Пример 2
 * Ввод	Вывод
 * 2 29 2008
 * 1
 * Примечания
 * В первом примере при одной системе записи дата равна 1 февраля, при другой - 2 января 2003 года, то есть однозначно назвать дату не получается.
 * Во втором примере корректный вариант даты может быть только в американском формате, где она задаёт 29 февраля 2008 года.
 */
public class Даты {


    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        private List<String> arr;

        public StreamGobbler(InputStream inputStream, List<String> arr) {
            this.inputStream = inputStream;
            this.arr = arr;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(it -> {
                        arr.add(it);
                    });
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        File commandFile = new File("myFile.txt");
        commandFile.createNewFile();
        commandFile.setExecutable(true);
        Process p = Runtime.getRuntime().exec(commandFile.getAbsolutePath());



//        String cmd = "ls -al";
//        Runtime run = Runtime.getRuntime();
//        Process pr = run.exec(cmd);
//        pr.waitFor();
//        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//        String line = "";
//        while ((line=buf.readLine())!=null) {
//            System.out.println(line);
//        }

        String homeDirectory = System.getProperty("user.home");
        Process process;
        process = Runtime.getRuntime()
                .exec(String.format("sh -c pwd %s", homeDirectory));

        List<String> a = new ArrayList<>();
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), a);

        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;

        System.out.println(a);
    }

    public static Boolean isRunningInsideDocker() {

        try (Stream<String> stream =
                     Files.lines(Paths.get("/proc/1/cgroup"))) {
            return stream.anyMatch(line -> line.contains("/docker"));
        } catch (IOException e) {
            return false;
        }
    }


    /**
    1 <= Days <= 31
            1 <= Months <= 12
            1970 <= Years <= 2069
    **/

    //Можно взять еще остаток от деления 12%

//    public static void main(String[] arg) {
//        //13 12 2003 - 0 (не однозначное решение), может быть и 1-ое февраля и 2 января
//        //1 2 1769
//
//        String date = "1 2 2003";
//
//        int value1 = 1;
//        int value2 = 2;
//        int value 3 = 2003;
//
//        boolean result = false;
//
//        if (Days.contains(value1) && Month.contains(value1)) {
//            result = true;
//        }
//
//        if (Days.contains(value2) && Month.contains(value2)) {
//            result &= true;
//        } else {
//            result &= false;
//        }
//
//        if (!Years.contains(value3)) {
//            return false; //Определить однозначно нельзя
//        }
//
//
//        if (true) {
//            return 0;
//        } return 1;
//
//    }

}
