package sk.posam.fsa.du.boot.api;

import sk.posam.fsa.du.boot.domain.Address;

import java.util.Date;

public class CustomerDto {
    public Long id;

    public String firstName;

    public String lastName;

    public String email;

    public Address addressId;

    public Boolean activeBool;

    public Date createDate;

    public Date lastUpdate;

    public Integer active;
}
