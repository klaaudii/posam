package sk.posam.fsa.du.boot.domain.repositories;

import sk.posam.fsa.du.boot.domain.Customer;

public interface CustomerRepository {
    Customer read(long id);
}
