package sk.posam.fsa.du.boot.application.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sk.posam.fsa.du.boot.domain.Customer;

import java.util.Date;
import java.util.List;

public interface CustomerCrudRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    List<Customer> findByActiveBool(Boolean activeBool);
    List<Customer> findByLastNameAndFirstName(String lastName, String firstName);
    List<Customer> findByFirstName(String firstName);
    List<Customer> findAllByOrderByLastNameAsc();
    List<Customer> findAllByOrderByLastNameDesc();
    @Query("SELECT c FROM Customer c WHERE c.createDate <= :date")
    Iterable<Customer> findAllOlderThan(@Param("date") Date date);
}
