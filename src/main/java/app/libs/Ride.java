package app.libs;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String from_place;
    private String to_place;
    private String comment;
    private String date;
    private int price;
    private int client_id;
    private int driver_id;
}
