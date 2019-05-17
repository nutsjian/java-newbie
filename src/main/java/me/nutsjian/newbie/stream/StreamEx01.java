package me.nutsjian.newbie.stream;

import me.nutsjian.newbie.testdata.entity.Person;
import me.nutsjian.newbie.testdata.factory.PersonDataFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx01 {

    // 需求：
    // 找出所有年龄是 30 岁的人，并按照薪水从高到底排序，得到一个新的集合
    public static void main(String[] args) {
        Stream<String> loans = Stream.of("Car Loan", "Home Loan", "Personal Loan");
        Object[] objectArray = loans.toArray();
        System.out.println(Arrays.toString(objectArray));

        List<Person> _testList = PersonDataFactory.generateList(100);
//        withoutStream(_testList);
        withStream(_testList);
    }

    // 不使用 stream ，操作非常繁琐
    // wrong way
    private static void withoutStream(List<Person> list) {
        List<Person> personList = new ArrayList<>();
        for(Person person: list){
            if(person.getAge() == 30){
                personList.add(person);
            }
        }
        Collections.sort(personList, (t1, t2) -> t2.getSalary().compareTo(t1.getSalary()));

        System.out.println("--------------------------- after handled data -----------------------------------");
        PersonDataFactory.printData(personList);
    }


    // right way
    private static void withStream(List<Person> list) {
        List<Person> sortedPersonList = list.parallelStream()
                .filter(t -> t.getAge() == 30)
                // 按照薪水倒序 reversed ，正序的话无需 reversed
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println("--------------------------- after handled data -----------------------------------");
        PersonDataFactory.printData(sortedPersonList);
    }

}
