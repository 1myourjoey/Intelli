package com.sky.repository;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AnswerDto {
    //mybatis 용 DTO

    private Long id;
    private List<AnswerData> dataList;
    private int age;
    private String name;
}
