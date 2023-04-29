package sk.posam.fsa.du.boot.domain;

public interface LocationService {
        boolean customerLivesInAddress(long customerId, long addressId);

        boolean customerLivesInCountry(long customerId, long countryId);
}
