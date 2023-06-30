package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int number;
    private String model;

    public Car(String name, int number, String model) {
        this.name = name;
        this.number = number;
        this.model = model;
    }
}
