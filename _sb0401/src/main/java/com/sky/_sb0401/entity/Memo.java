package com.sky._sb0401.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
    private String memoText;

}
