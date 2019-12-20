package app.repository;

import app.libs.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {
    public Collection<Driver> findAllByName(String name);
}
