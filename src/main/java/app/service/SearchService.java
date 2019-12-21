package app.service;

import app.libs.Driver;
import app.libs.Ride;
import app.libs.Vehicle;
import app.repository.DriverRepository;
import app.repository.RideRepository;
import app.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    public List<Ride> findAll(String departure, String destination, String datetime, int seatnum) {
        Iterable<Ride> all = rideRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .filter(e -> e.getFrom_place().equals(departure))
                .filter(e -> e.getTo_place().equals(destination))
                .filter(e -> e.getDate().equals(datetime))
                .filter(e -> {
                    Optional<Driver> driverId = driverRepository.findById(e.getDriver_id());
                    Optional<Vehicle> vehicleId = vehicleRepository.findById(driverId.orElse(new Driver("","","","","","",-1)).getVehicle_id());
                    int seats = vehicleId.orElse(new Vehicle("", 0)).getSeats();
                    return seatnum <= seats;
                })
                .collect(Collectors.toList());
    }
    public List<Ride> getAll()
    {
        return (List<Ride>) rideRepository.findAll();
    }
}
