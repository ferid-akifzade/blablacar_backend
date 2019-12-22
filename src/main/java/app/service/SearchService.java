package app.service;

import app.libs.Ride;
import app.repository.DriverRepository;
import app.repository.RideRepository;
import app.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SearchService {
    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;

    public SearchService(RideRepository rideRepository, DriverRepository driverRepository, VehicleRepository vehicleRepository) {
        this.rideRepository = rideRepository;
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
    }

    // custom methods spring data
    public List<Ride> findAll(String departure, String destination, String datetime) {
        Iterable<Ride> all = rideRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .filter(e -> e.getFrom_place().equals(departure))
                .filter(e -> e.getTo_place().equals(destination))
                .filter(e -> e.getDate().equals(datetime))
                .collect(Collectors.toList());
    }

    public List<Ride> getAll() {
        return (List<Ride>) rideRepository.findAll();
    }
}
