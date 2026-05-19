package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
    private Integer id;
    private String name;
    private Integer age;
    private Integer depId;
}
