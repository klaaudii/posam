package sk.posam.fsa.du.boot.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.du.boot.domain.Customer;
import sk.posam.fsa.du.boot.domain.repositories.CustomerRepository;

import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private CustomerCrudRepository customerCrudRepository;
    @Override
    public Customer read(long id) {
        Optional<Customer> customer = customerCrudRepository.findById(id);
        return customer.get();
    }
}
