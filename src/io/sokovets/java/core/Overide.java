package io.sokovets.java.core;

public class Overide {

    int a() throws RuntimeException {
        return 4;
    }
}

class A extends Overide {

    private static int a = 54;

    static class AA {

        public void a() {
            System.out.println(a);
        }
    }

}
