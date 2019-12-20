package app.repository;
import app.libs.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends CrudRepository<Ride, Integer> {
}
