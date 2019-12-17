package app.libs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String from_place;
    private String to_place;
    private String comment;
    private String date;
    private int price;
    private int driver_id;

    public Ride(String from_place, String to_place, String comment, String date, int price,  int driver_id) {
        this.from_place = from_place;
        this.to_place = to_place;
        this.comment = comment;
        this.date = date;
        this.price = price;
        this.driver_id = driver_id;
    }
}
