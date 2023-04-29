package sk.posam.fsa.du.boot.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.du.boot.domain.Address;
import sk.posam.fsa.du.boot.domain.Customer;
import sk.posam.fsa.du.boot.domain.repositories.AddressRepository;

import java.util.Optional;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    @Autowired
    private AddressCrudRepository addressCrudRepository;
    @Override
    public Address read(long id) {
        Optional<Address> address = addressCrudRepository.findById(id);
        return address.get();
    }
}
