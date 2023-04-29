package sk.posam.fsa.du.boot.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.du.boot.domain.Country;

public interface CountryCrudRepository extends CrudRepository<Country, Long> {

}
