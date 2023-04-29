package sk.posam.fsa.du.boot.domain.repositories;

import sk.posam.fsa.du.boot.domain.Country;

public interface CountryRepository {
    Country read(long id);
}
