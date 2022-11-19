package io.sokovets.yandex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) throws IOException {
        String[] line = Files.readString(Paths.get("/Users/a19434089/IdeaProjects/HackerrankTasks/src/io/sokovets/yandex/input.txt")).split(" ");
        Files.writeString(Paths.get("output.txt"), Arrays.toString(line));

        int val1 = Integer.parseInt(line[0].trim());
        int val2 = Integer.parseInt(line[1].trim());

        int result = val1 + val2;

        Files.writeString(Paths.get("/Users/a19434089/IdeaProjects/HackerrankTasks/src/io/sokovets/yandex/output.txt"), String.valueOf(result));
    }

}
