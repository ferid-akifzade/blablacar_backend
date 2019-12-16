package app.service;

import app.libs.Client;
import app.libs.Driver;
import app.repository.ClientRepository;
import app.repository.DriverRepository;
import org.springframework.stereotype.Service;



@Service
public class LoginService {
private DriverRepository driverRepository;
private ClientRepository clientRepository;
    public int check(String email, String password, String radiobox) {
        if(radiobox.equals("driver")){
            Iterable<Driver> allDrivers = driverRepository.findAll();
            for (Driver driver:
                    allDrivers) {
                if(driver.getEmail().equals(email)&&driver.getPassword().equals(password)) return driver.getId() ;
            }
        }
        else if(radiobox.equals("client")){
            Iterable<Client> allClients = clientRepository.findAll();
            for (Client client:
                    allClients) {
                if(client.getEmail().equals(email)&&client.getPassword().equals(password)) return client.getId();
            }
        }
        return -1;
    }
}
