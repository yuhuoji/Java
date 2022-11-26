package com.bilibili.chapter03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO 比较器，C++重载运算符，仿函数
 *
 * @date 2022-11-24 16:30
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Person1[] people1 = new Person1[]{new Person1("xujian", 20), new Person1("xiewei", 10)};
        System.out.println("排序前\n");
        for (Person1 person1 : people1) {
            System.out.print(person1.getName() + " : " + person1.getAge() + ", ");
        }
        //implements Comparable，该类可以直接比较
        Arrays.sort(people1);
        System.out.println("\n排序后\n");
        for (Person1 person1 : people1) {
            System.out.print(person1.getName() + ":" + person1.getAge());
        }
        System.out.println("\n---------------------------------------------");
        //
        Person[] people2 = new Person[]{new Person("xujian", 20), new Person("xiewei", 10)};
        System.out.println("排序前\n");
        for (Person person : people2) {
            System.out.print(person.getName() + ":" + person.getAge());
        }
        //use Comparator, 比较时传入比较器
//        Arrays.sort(people2, new PersonComparator());
        //匿名内部类
        Arrays.sort(people2, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        //lambda
//        Arrays.sort(people2, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println("\n排序后\n");
        for (Person person : people2) {
            System.out.print(person.getName() + " : " + person.getAge() + ", ");
        }
    }

    //method2:
    public static class PersonCompartor implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge() - o2.getAge();
        }
    }
}

//method1: 实现Comparable接口,重写compareTo方法
class Person1 implements Comparable<Person1> {
    String name;
    int age;

    public Person1() {
    }

    public Person1(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person1 p) {
        return this.age - p.getAge();
    }

}

class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

