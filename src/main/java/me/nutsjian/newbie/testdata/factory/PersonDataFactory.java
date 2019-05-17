package me.nutsjian.newbie.testdata.factory;

import me.nutsjian.newbie.testdata.entity.Person;
import me.nutsjian.newbie.testdata.vo.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class PersonDataFactory {

    public static List<Person> generateList(int howmuch) {
        List<Person> personList = new ArrayList<>();
        Person person;
        for (int i=0; i<howmuch; i++) {
            person = new Person();
            person.setId(i+1);
            person.setName("nutsjian"+i);
            person.setAge(FactoryUtils.generateRangeRandomInt(22, 50));
            person.setSalary(FactoryUtils.generateRangeRandomInt(3000, 30000));

            personList.add(person);
        }
        printData(personList);
        return personList;
    }

    public static void printData(List<Person> personList) {
        personList.forEach(System.out::println);
    }

    public static void printVO(List<PersonVO> personList) {
        personList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        generateList(100);
    }
}
