package com.miguelsouza.API_REST.service;

import com.miguelsouza.API_REST.exceptions.ResourceNotFoundException;
import com.miguelsouza.API_REST.model.Address;
import com.miguelsouza.API_REST.model.Client;
import com.miguelsouza.API_REST.repository.AddressRepository;
import com.miguelsouza.API_REST.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final AddressRepository addressRepository;
    private final ViaCepService service;

    public ClientService(ClientRepository repository, AddressRepository addressRepository, ViaCepService service) {
        this.repository = repository;
        this.addressRepository = addressRepository;
        this.service = service;
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void insert(Client client) {
        saveClientWithCep(client);
    }

    public void update(Long id, Client client) {

        Client entity = findById(id);

        entity.setName(client.getName());

        Address address = getAddressByCep(client.getAddress().getCep());

        entity.setAddress(address);

        repository.save(entity);
    }

    public void delete(Long id) {

        findById(id);

        repository.deleteById(id);
    }

    private void saveClientWithCep(Client client) {

        Address address = getAddressByCep(
                client.getAddress().getCep()
        );

        client.setAddress(address);

        repository.save(client);
    }


    private Address getAddressByCep(String cep) {

        Optional<Address> addressOptional =
                addressRepository.findById(cep);

        if (addressOptional.isPresent()) {
            return addressOptional.get();
        }

        Address address = service.consultCep(cep);

        return addressRepository.save(address);
    }

}
