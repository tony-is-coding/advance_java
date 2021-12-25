package com.cnc.jdk8stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Person {

    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区

    // 构造方法
    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }
    // 省略了get和set，请自行添加


    public static List<Person> exampleData() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 21, "male", "Beijing"));
        personList.add(new Person("Jack", 7000, 22, "male", "Shanghai"));
        personList.add(new Person("Lily", 7800, 23, "female", "Shanghai"));
        personList.add(new Person("Anni", 8200, 25, "female", "Beijing"));
        personList.add(new Person("Owen", 9500, 30, "male", "Beijing"));
        personList.add(new Person("Alisa", 7900, 28, "female", "Beijing"));
        personList.add(new Person("Jane", 10000, 28, "female", "Shenzhen"));
        personList.add(new Person("June", 9200, 24, "male", "Shenzhen"));
        return personList;
    }

}
