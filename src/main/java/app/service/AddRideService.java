package app.service;

import app.libs.Ride;
import app.repository.RideRepository;
import org.springframework.stereotype.Service;

@Service
public class AddRideService {
    private final RideRepository rideRepository;
    public AddRideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public void add(Ride ride)
    {
        rideRepository.save(ride);
    }
}
