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
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int user_id;
    private int ride_id;

    public History(int user_id, int ride_id) {
        this.user_id = user_id;
        this.ride_id = ride_id;
    }
}
