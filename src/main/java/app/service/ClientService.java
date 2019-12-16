package app.service;

import app.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService  {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
