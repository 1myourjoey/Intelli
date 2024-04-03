package com.sky._sb0402_2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
public class Member {
    private int id;
    private String name;
}
