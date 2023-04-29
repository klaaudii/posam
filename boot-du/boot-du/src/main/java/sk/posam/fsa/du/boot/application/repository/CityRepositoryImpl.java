package sk.posam.fsa.du.boot.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.du.boot.domain.City;
import sk.posam.fsa.du.boot.domain.repositories.CityRepository;

import java.util.Optional;

@Repository
public class CityRepositoryImpl implements CityRepository {
    @Autowired
    private CityCrudRepository cityCrudRepository;
    @Override
    public City read(long id) {
        Optional<City> city = cityCrudRepository.findById(id);
        return city.get();
    }
}
