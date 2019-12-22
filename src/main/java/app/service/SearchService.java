package app.service;

import app.libs.Driver;
import app.libs.Ride;
import app.repository.DriverRepository;
import app.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SearchService {
    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;

    public SearchService(RideRepository rideRepository, DriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.driverRepository = driverRepository;
    }

    // custom methods spring data
    public List<HashMap<String, Object>> findAll(String departure, String destination, String datetime) {
        Iterable<Ride> all = rideRepository.findAll();
        List<Ride> collect = StreamSupport.stream(all.spliterator(), false)
                .filter(e -> e.getFrom_place().equals(departure))
                .filter(e -> e.getTo_place().equals(destination))
                .filter(e -> e.getDate().equals(datetime))
                .collect(Collectors.toList());
        List<HashMap<String, Object>> data = new LinkedList<>();
        for (Ride oneRide : collect) {
            HashMap<String, Object> tmp = new HashMap<>();
            tmp.put("id", oneRide.getId());
            tmp.put("from_place", oneRide.getFrom_place());
            tmp.put("to_place", oneRide.getTo_place());
            tmp.put("comment", oneRide.getComment());
            tmp.put("date", oneRide.getDate());
            tmp.put("price", oneRide.getPrice());
            Optional<Driver> driverOPT = driverRepository.findById(oneRide.getDriver_id());
            driverOPT.ifPresent(driver -> {
                tmp.put("name", driver.getName());
                tmp.put("surname", driver.getSurname());
                tmp.put("gender", driver.getGender());
                tmp.put("phonenum", driver.getPhonenum());
                tmp.put("vehicle_id", driver.getVehicle_id());
            });
            data.add(tmp);
        }
        return data;
    }

    public List<Ride> getAll() {
        return (List<Ride>) rideRepository.findAll();
    }
}
