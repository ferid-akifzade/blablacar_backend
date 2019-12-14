package app.libs;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String model;
    private String img;
    private int sits;

    public Vehicle(String model, String img, int sits) {
        this.model = model;
        this.img = img;
        this.sits = sits;
    }
}
