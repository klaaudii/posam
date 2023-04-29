package sk.posam.fsa.du.boot.application.repository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.fsa.du.boot.domain.Address;
import sk.posam.fsa.du.boot.domain.Country;
import sk.posam.fsa.du.boot.domain.Customer;
import sk.posam.fsa.du.boot.domain.LocationService;
import sk.posam.fsa.du.boot.domain.repositories.AddressRepository;
import sk.posam.fsa.du.boot.domain.repositories.CountryRepository;
import sk.posam.fsa.du.boot.domain.repositories.CustomerRepository;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Override
    @Transactional
    public boolean customerLivesInAddress(long customerId, long addressId) {
       Customer customer = customerRepository.read(customerId);
        Address address = addressRepository.read(addressId);
        return address.getCustomers().contains(customer);
    }

    @Override
    @Transactional
    public boolean customerLivesInCountry(long customerId, long countryId) {
        Customer customer = customerRepository.read(customerId);
        Country country = countryRepository.read(countryId);
        return country.getCities().stream().filter(city -> city.getAddresses().contains(customer.getAddress())).toList().size() > 0;
    }
}
