package app.service;
import app.libs.Driver;
import app.libs.Ride;
import app.libs.Vehicle;
import app.repository.DriverRepository;
import app.repository.RideRepository;
import app.repository.VehicleRepository;
import org.springframework.stereotype.Service;

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
    public List<Ride> findAll(String departure, String destination, String datetime, int seatnum){
        Iterable<Ride> all = rideRepository.findAll();
        Stream<Ride> rideStream = StreamSupport.stream(all.spliterator(), false)
                .filter(e -> e.getFrom_place().equals(departure))
                .filter(e -> e.getTo_place().equals(destination))
                .filter(e -> e.getDate().equals(datetime));
        rideStream.map(e->{
            Optional<Driver> byId = driverRepository.findById(e.getDriver_id());
            Optional<Integer> integer = byId.map(Driver::getVehicle_id);
            Iterable<Vehicle> all1 = vehicleRepository.findAll();
           return   StreamSupport.stream(all1.spliterator(),false)
                    .filter(v->v.getSits()>=seatnum)
                    .collect(Collectors.toList());

        });
       throw new IllegalArgumentException("No such ride for your search");
    }



}
