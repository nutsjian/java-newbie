package me.nutsjian.newbie.testdata.entity;

import lombok.Data;

@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    // 薪资
    private Integer salary;
}
