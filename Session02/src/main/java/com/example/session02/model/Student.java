package com.example.session02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id;
    String name;
    boolean sex;
    LocalDate bod;
    String hometown;
    String className;
}
