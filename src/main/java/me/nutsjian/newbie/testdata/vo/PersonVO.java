package me.nutsjian.newbie.testdata.vo;

import lombok.Data;

@Data
public class PersonVO {
    private Integer id;
    private String name;
    private Integer age;
    // 薪资
    private Integer salary;
    private String mode = "vo mode";
}
