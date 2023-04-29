package sk.posam.fsa.du.boot.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.du.boot.domain.Country;
import sk.posam.fsa.du.boot.domain.repositories.CountryRepository;

import java.util.Optional;

@Repository
public class CountryRepositoryImpl implements CountryRepository {
    @Autowired
    private CountryCrudRepository countryCrudRepository;
    @Override
    public Country read(long id) {
        Optional<Country> country = countryCrudRepository.findById(id);
        return country.get();
    }
}
