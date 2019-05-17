package me.nutsjian.newbie.stream;

import me.nutsjian.newbie.testdata.entity.Person;
import me.nutsjian.newbie.testdata.factory.PersonDataFactory;
import me.nutsjian.newbie.testdata.vo.PersonVO;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEx02 {

    // 需求：
    // 找出所有年龄是 30 岁的人，并把结果转成另外一个对象后保存成一个集合中
    // 通过 map 转换对象
    public static void main(String[] args) {
        List<Person> _testList = PersonDataFactory.generateList(50);

        List<PersonVO> newList = _testList.parallelStream()
                .filter(person -> person.getAge() == 30)
                .map(person -> {
                    PersonVO vo = new PersonVO();
                    vo.setId(person.getId());
                    vo.setName(person.getName());
                    vo.setAge(person.getAge());
                    vo.setSalary(person.getSalary());
                    return vo;
                }).collect(Collectors.toList());

        System.out.println("--------------------------- after handled data -----------------------------------");
        PersonDataFactory.printVO(newList);
    }

}
