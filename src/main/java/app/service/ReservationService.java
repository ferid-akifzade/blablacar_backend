package app.service;

import app.libs.Driver;
import app.libs.Vehicle;
import app.repository.DriverRepository;
import app.repository.RideRepository;
import app.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    private final RideRepository rideRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;
    private boolean found = false;

    public ReservationService(RideRepository rideRepository, VehicleRepository vehicleRepository, DriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }


    public boolean reservation(int rideID, int seats, int clientID) {

        rideRepository.findById(rideID).stream()
                .filter(e -> {
                    Optional<Driver> driverId = driverRepository.findById(e.getDriver_id());
                    Optional<Vehicle> vehicleId = vehicleRepository.findById(driverId.orElse(new Driver("", "", "", "", "", "", -1)).getVehicle_id());
                    int currentSeats = vehicleId.orElse(new Vehicle("", 0)).getSeats();

                    return seats <= currentSeats;
                }).forEach(ride -> {
            Optional<Driver> driverId = driverRepository.findById(ride.getDriver_id());
            Optional<Vehicle> vehicleOpt = vehicleRepository.findById(driverId.orElse(new Driver("", "", "", "", "", "", -1)).getVehicle_id());
            Vehicle vehicle = vehicleOpt.orElse(new Vehicle("", -2));
            vehicle.setSeats(vehicle.getSeats() - seats);;
            vehicleRepository.save(vehicle);
            found = true;


        });

        return found;
    }
}
