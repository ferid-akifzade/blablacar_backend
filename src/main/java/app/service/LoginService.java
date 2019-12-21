package app.service;

import app.libs.Client;
import app.libs.Driver;
import app.libs.User;
import app.repository.ClientRepository;
import app.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginService {
private final DriverRepository driverRepository;
private final ClientRepository clientRepository;

    public LoginService(DriverRepository driverRepository, ClientRepository clientRepository) {
        this.driverRepository = driverRepository;
        this.clientRepository = clientRepository;
    }

    public Optional<User> check(String email, String password, String radiobox) {
        if(radiobox.equals("driver")){
            Iterable<Driver> allDrivers = driverRepository.findAll();
            for (Driver driver:
                    allDrivers) {
                if(driver.getEmail().equals(email)&&driver.getPassword().equals(password)) return Optional.of(driver);
            }
        }
        else if(radiobox.equals("client")){
            Iterable<Client> allClients = clientRepository.findAll();
            for (Client client:
                    allClients) {
                if(client.getEmail().equals(email)&&client.getPassword().equals(password)) return Optional.of(client);
            }
        }
        return Optional.empty();
    }
}
