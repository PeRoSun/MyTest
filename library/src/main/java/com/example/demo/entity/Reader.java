package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class Reader {
    private int id;
    private String name;
    private String username;
    private int age;
    private int sex;
    private String phone;
    private Date regdate;
    private int level=1;
    private int status=1;
    private int maxBrNum;
    private int maxBrDay;
    public Reader(){}
//    public Reader(int id, String name, int age, int sex, String phone) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//        this.phone = phone;
//    }

}
