package sk.posam.fsa.du.boot.application.assembler;

import sk.posam.fsa.du.boot.api.CustomerDto;
import sk.posam.fsa.du.boot.domain.Customer;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CustomerAssembler {

    public Collection<CustomerDto> toDto(Iterable<Customer> customers) {
        return StreamSupport.stream(customers.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public CustomerDto toDto(Customer customer) {
        CustomerDto result = new CustomerDto();

        result.id = customer.getId();
        result.firstName = customer.getFirstName();
        result.lastName = customer.getLastName();
        result.lastUpdate = customer.getLastUpdate();
        result.createDate = customer.getCreateDate();
        result.active = customer.getActive();
        result.activeBool = customer.getActiveBool();
        result.email = customer.getEmail();
        result.addressId = customer.getAddress();
        //result.storeId = customer.getStoreId();

        return result;
    }

    public Customer fromDto(CustomerDto dto){
        Customer result = new Customer();

        result.setId(dto.id);
        result.setFirstName(dto.firstName);
        result.setLastName(dto.lastName);
        result.setActive(dto.active);
        result.setActiveBool(dto.activeBool);
        result.setCreateDate(dto.createDate);
        result.setLastUpdate(dto.lastUpdate);
        result.setEmail(dto.email);
        //result.setStoreId(dto.storeId);
        return result;
    }
}
