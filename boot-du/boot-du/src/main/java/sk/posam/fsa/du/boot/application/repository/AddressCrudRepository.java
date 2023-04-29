package sk.posam.fsa.du.boot.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.du.boot.domain.Address;

public interface AddressCrudRepository extends CrudRepository<Address, Long> {
}
