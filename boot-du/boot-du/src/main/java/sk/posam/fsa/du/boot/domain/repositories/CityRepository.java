package sk.posam.fsa.du.boot.domain.repositories;

import sk.posam.fsa.du.boot.domain.City;

public interface CityRepository {
    City read(long id);
}
