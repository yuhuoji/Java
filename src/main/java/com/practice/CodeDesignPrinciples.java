package com.practice;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class CodeDesignPrinciples {
    public class PersonAgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person person1, Person person2) {
            // 比较规则：按照年龄降序排序
            return Integer.compare(person1.getAge(),person2.getAge());

        }
    }

    @Test
    public void test(){
        Person person1 = new Person("A", 20);
        Person person2 = new Person("B", 30);
        System.out.println(person1.compareTo(person2));

        PersonAgeComparator personAgeComparator = new PersonAgeComparator();
        System.out.println(personAgeComparator.compare(person1, person2));
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 实现 Comparable 接口的 compareTo 方法
    @Override
    public int compareTo(Person otherPerson) {
        // 比较规则：按照年龄升序排序
        return Integer.compare(this.age, otherPerson.age);
    }
}