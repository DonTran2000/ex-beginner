package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private Integer age;
    private String comment;
}
