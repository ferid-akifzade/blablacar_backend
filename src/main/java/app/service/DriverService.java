package app.service;

import app.libs.Driver;
import app.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DriverService implements DriverRepository {

    private DriverRepository driverRepository;
@Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public <S extends Driver> S save(S s) {
        return driverRepository.save(s);
    }

    @Override
    public <S extends Driver> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Driver> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Driver> findAll() {
        return null;
    }

    @Override
    public Iterable<Driver> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Driver driver) {

    }

    @Override
    public void deleteAll(Iterable<? extends Driver> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
