package io.sokovets.epam.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Here's an example of a task:
 *
 * There is a Pojo class.
 * It has two fields: value and length, as well as getters and setters.
 *
 * Getters and setters for the second field are commented.
 *
 * We need to use this entity as a key in the HashMap.
 *
 * Also, using it we need to save Integer Object.
 *
 * For Pojo we setValue "abc" and record it to the HashMap.
 *
 * Then, setLength and try to return it.
 *
 * Question: what will be returned as a result?
 *
 * class Pojo{
 * private String value;
 * private Integer length;
 *
 * public String getValue(){
 * return value;
 * }
 *
 * public void setValue(String value){
 * this.value = value;
 * }
 *
 * //getter, setter for length
 *
 * public static void main(String[] args){
 * Map<Pojo, Integer> map = new HashMap();
 * Pojo key = new Pojo();
 * key.setValue("abc");
 * map.put(key, 1);
 * key.setLength(3);
 * Integer result = map.get(key);
 * System.out.println(result);
 * }
 * }
 *
 */
public final class Pojo{
    private String value;
    private Integer length;

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pojo pojo = (Pojo) o;
        return value.equals(pojo.value) && length.equals(pojo.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, length);
    }

    public static void main(String[] args){
        Map<Pojo, Integer> map = new HashMap();
        Pojo key = new Pojo();
        key.setValue("abc");
        map.put(key, 1);
        key.setLength(3);
        Integer result = map.get(key);
        System.out.println(result);
    }


    //1. сначала предложить ввести hashcode и equals
    //2. далее предложить ввести final поля и поля на класс, чтобы сделать объект не изменяемым

    //3. А если интервьюр, предложить вввести объект который изменяется:
    //When this class becomes immutable, the task can be slightly changed: Instead of the string value,
    // let's insert a mutable Object, for example, Date or another mutable class. Then the questions are:
    // what will happen now, how will this work, and is there any problem?

    //The candidate may suggest using either copying or cloning.
    // If so, it might be a good idea to play around with cloning and exceptions as necessary.



}
