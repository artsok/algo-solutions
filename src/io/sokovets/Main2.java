package io.sokovets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.sokovets.TestEnum.getByValue;

enum TestEnum {

    TEST1("AAA"),
    TEST2("BBB");

    private String value;

    private static final Map<String, TestEnum> testMap = new HashMap<>();

    TestEnum(String value) {
        this.value = value;
    }

    public static TestEnum getByValue(String value) {
        if (testMap.isEmpty()) {
            Arrays.stream(TestEnum.values()).map(v -> testMap.put(v.value, v));
        }
        return testMap.get(value == null ? "" : value.toUpperCase());
    }

    public String getValue() {
        return value;
    }

}
