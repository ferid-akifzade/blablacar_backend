package app.libs;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String gender;
    private String phonenum;
    private int vehicle_id;

    public Driver(String name, String surname, String email, String password, String gender, String phonenum, int vehicle_id) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phonenum = phonenum;
        this.vehicle_id = vehicle_id;
    }
}
