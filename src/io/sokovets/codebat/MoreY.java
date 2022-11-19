package io.sokovets.codebat;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class MoreY {
    public static void main(String[] args) {
        /**
         *
         Given a list of strings, return a list where each string has "y" added at its start and end.

         moreY(["a", "b", "c"]) → ["yay", "yby", "ycy"]
         moreY(["hello", "there"]) → ["yhelloy", "ytherey"]
         moreY(["yay"]) → ["yyayy"]

         */
    }

    public List<String> moreY(List<String> strings) {
        //strings.replaceAll(s -> "y".concat(s).concat("y"));
        //return strings;
        return strings.stream().map(it -> "y" + it + "y").collect(Collectors.toList());
    }
}
