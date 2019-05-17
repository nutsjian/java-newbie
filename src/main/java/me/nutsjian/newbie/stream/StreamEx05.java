package me.nutsjian.newbie.stream;

import me.nutsjian.newbie.testdata.entity.Person;
import me.nutsjian.newbie.testdata.factory.PersonDataFactory;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StreamEx05 {

    public static void main(String[] args) {
        String[] words = new String[]{"Hello", "World", "Hello"};
        List<String[]> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        a.forEach(System.out::println);

        List<String> b = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        b.forEach(System.out::print);

        // 通过 mapToInt 查找最大岁数
        List<Person> _testList = PersonDataFactory.generateList(10);
        OptionalInt maxAgeOptional =_testList.stream().mapToInt(Person::getAge).max();
        System.out.println(maxAgeOptional.orElse(9999));
    }

}
