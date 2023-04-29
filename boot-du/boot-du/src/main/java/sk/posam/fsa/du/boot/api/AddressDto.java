package sk.posam.fsa.du.boot.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sk.posam.fsa.du.boot.domain.Customer;

import java.util.Date;
import java.util.Set;

public class AddressDto {
    public Long id;

    public String address;

    public String address2;

    public String district;

    @JsonIgnore
    public Set<Customer> customers;

    public Long cityId;

    public String postalCode;

    public String phone;

    public Date lastUpdate;

}
