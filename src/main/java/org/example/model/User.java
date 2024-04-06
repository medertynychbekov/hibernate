package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(name = "last_name")
    String lastName;
    String email;
    String address;
    byte age;

    public User(String name, String lastName, String email, String address, byte age) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.age = age;
    }
}
