package com.example.secondwebexperiment.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    Integer id = 0;
    String name = null;
    Integer age = 0;
}
