package com.sky.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name="answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "answer_data", joinColumns = @JoinColumn(name = "id"))
    @OrderColumn(name = "seq")
    private List<String> dataList;

    private int age;
    private String name;

    @Builder
    public AnswerEntity(List<String> dataList, int age, String name) {
        this.dataList = dataList;
        this.age = age;
        this.name = name;
    }

//    public static Answer toEntity(com.sky._sb0416.problem.Answer dto) {
//        return Answer.builder()
//                .dataList(dto.getDataList())
//                .age(dto.getAge())
//                .name(dto.getName())
//                .build();
//    }
}
