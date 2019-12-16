package app.service;
import app.libs.Driver;
import app.libs.Ride;
import app.libs.Vehicle;
import app.repository.DriverRepository;
import app.repository.RideRepository;
import app.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
    public Iterable<Ride> findAll(String departure, String destination, String datetime,int seatnum){
        Iterable<Ride> all = rideRepository.findAll();
        Stream<Ride> rideStream = StreamSupport.stream(all.spliterator(), false)
                .filter(e -> e.getFrom_place().equals(departure))
                .filter(e -> e.getTo_place().equals(destination))
                .filter(e -> e.getDate().equals(datetime));
        rideStream.map(e->{
            Optional<Driver> byId = driverRepository.findById(e.getDriver_id());
            Optional<Integer> integer = byId.map(Driver::getVehicle_id);
            Iterable<Vehicle> all1 = vehicleRepository.findAll();
            Stream<Vehicle> vehicleStream=StreamSupport.stream(all.spliterator(),false)
                    .filter(e->e.)

            return 1;
        });


        driverRepository.findById()
    }



}
