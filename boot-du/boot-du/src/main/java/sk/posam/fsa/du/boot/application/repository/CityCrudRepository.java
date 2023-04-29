package sk.posam.fsa.du.boot.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.du.boot.domain.City;

public interface CityCrudRepository extends CrudRepository<City, Long> {
}
