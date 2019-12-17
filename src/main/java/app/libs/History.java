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
    private int client_id;
    private int ride_id;
    private int sits;
    public History(int client_id, int ride_id, int sits) {
        this.client_id = client_id;
        this.ride_id = ride_id;
        this.sits = sits;
    }
}
