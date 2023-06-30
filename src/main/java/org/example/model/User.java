package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Scanner;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}


