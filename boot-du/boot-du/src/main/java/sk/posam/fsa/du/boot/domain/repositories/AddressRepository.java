package sk.posam.fsa.du.boot.domain.repositories;

import sk.posam.fsa.du.boot.domain.Address;

public interface AddressRepository {
    Address read(long id);
}
