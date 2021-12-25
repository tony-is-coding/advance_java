package com.cnc.jdk8stream;


import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jdk8StreamApiTest {

    private final List<Person> exampleData = Person.exampleData();

    @Test
    public void testForeach() {
        exampleData.stream().filter(x -> x.getAge() > 24).forEach(System.out::println);
    }

    @Test
    public void testMatch() {
        // 匹配第一个
        Optional<Person> firstPerson = exampleData.stream().filter(x -> x.getAge() > 25).findFirst();
        System.out.println(firstPerson.orElse(null));
        // 匹配任意一个, 适用于并行流下
        Optional<Person> anyPerson = exampleData.stream().filter(x -> x.getAge() > 25).findAny();
        System.out.println(anyPerson.orElse(null));

        Boolean hasMatch = exampleData.stream().filter(x -> x.getAge() > 25).anyMatch(y -> y.getArea().equals("Shenzhen"));
        System.out.println(hasMatch);
    }

    @Test
    public void testAggregate() {
        // max
        Optional<Person> maxAge = exampleData.stream().max(Comparator.comparing(Person::getAge));
        Person maxP = maxAge.get();
        System.out.println(maxP.getAge());

        // min
        Optional<Person> minAge = exampleData.stream().min(Comparator.comparing(Person::getAge));
        Person minP = minAge.get();
        System.out.println(minP.getAge());

        // count

    }

    @Test
    public void testReduce() {
        // sum salarys
        Integer sumSalary1 = exampleData.stream().map(Person::getSalary).reduce(Integer::sum).orElse(0);
        Integer sumSalary2 = exampleData.stream().map(Person::getSalary).reduce(0, Integer::sum);
        Integer sumSalary3 = exampleData.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);
    }

    @Test
    public void testAve() {
        Double aveAge = exampleData.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println(aveAge);
    }

    @Test
    public void testPartitioningBy() {
        // 部分分组结果只会保留两个组,一个满足条件,一个不满足条件
        Map<Boolean, List<Person>> moreThen8000 = exampleData.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        System.out.println(moreThen8000);
    }

    @Test
    public void testGroupingBy() {
        Map<String, List<Person>> res = exampleData.stream().collect(Collectors.groupingBy(Person::getArea));
        System.out.println(res);
    }

    @Test
    public void testConcatLimitSkip() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + newList);
        System.out.println("limit：" + collect);
        System.out.println("skip：" + collect2);
    }


}
