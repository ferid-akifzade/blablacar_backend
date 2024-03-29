package app.service;

import app.libs.Client;
import app.libs.Driver;
import app.libs.User;
import app.libs.Vehicle;
import app.repository.ClientRepository;
import app.repository.DriverRepository;
import app.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;
    private final ClientRepository clientRepository;

    public RegisterService(VehicleRepository vehicleRepository, DriverRepository driverRepository, ClientRepository clientRepository) {
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
        this.clientRepository = clientRepository;
    }


    public int addVehicle(String model, int seats) {
        Vehicle vehicle = new Vehicle(model, seats);
        return vehicleRepository.save(vehicle).getId();
    }

    public Optional<User> register(String name, String surname, String email, String password, String radiobox, String gender, String phonenumber, String vehicle, int seats) {
        if (radiobox.equals("client")) {
            System.out.println("Entered client");
            Iterable<Client> allClients = clientRepository.findAll();
            for (Client client : allClients) {
                if (client.getEmail().equals(email)) return Optional.of(client);
            }
            return Optional.of(clientRepository.save(new Client(name, surname, email, password, gender, phonenumber)));
        } else {
            System.out.println("Entered driver");
            Iterable<Driver> allDrivers = driverRepository.findAll();
            for (Driver driver : allDrivers) {
                if (driver.getEmail().equals(email)) return Optional.of(driver);
            }
            return Optional.of(driverRepository.save(new Driver(name, surname, email, password, gender, phonenumber, addVehicle(vehicle, seats))));

        }
    }
}
