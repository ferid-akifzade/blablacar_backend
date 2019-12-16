package app.service;

import app.libs.Driver;
import app.repository.DriverRepository;

public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void save() {
        driverRepository.save(new Driver());
    }


}
