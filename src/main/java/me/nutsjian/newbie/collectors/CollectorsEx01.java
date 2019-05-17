package me.nutsjian.newbie.collectors;

import me.nutsjian.newbie.testdata.entity.Person;
import me.nutsjian.newbie.testdata.factory.PersonDataFactory;

import java.util.*;
import java.util.stream.Collector;

public class CollectorsEx01 {

    public static void main(String[] args) {
        List<Person> _testList = PersonDataFactory.generateList(100);
        TreeMap<Integer, List<Person>> map = _testList.stream().collect(
                TreeMap::new,
                (tm, item) -> {
                    if (null != tm.get(item.getAge())) {
                        tm.get(item.getAge()).add(item);
                    } else {
                        List<Person> list = new ArrayList<>();
                        list.add(item);
                        tm.put(item.getAge(), list);
                    }
                },
                (one, two) -> {
                }
        );

        System.out.println(map);

//        _testList.stream().collect
    }

}
