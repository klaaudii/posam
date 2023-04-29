package sk.posam.fsa.du.boot.application.assembler;

import sk.posam.fsa.du.boot.api.AddressDto;
import sk.posam.fsa.du.boot.api.CustomerDto;
import sk.posam.fsa.du.boot.domain.Address;
import sk.posam.fsa.du.boot.domain.City;
import sk.posam.fsa.du.boot.domain.Customer;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class AddressAssembler {
    public Collection<AddressDto> toDto(Iterable<Address> addresses) {
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public AddressDto toDto(Address address) {
        AddressDto result = new AddressDto();

        result.id = address.getId();
        result.address = address.getAddress();
        result.address2 = address.getAddress2();
        result.district = address.getDistrict();
        result.phone = address.getPhone();
        result.lastUpdate = address.getLastUpdate();
        result.cityId = address.getCity().getId();
        result.postalCode = address.getPostalCode();
        return result;
    }

    public Address fromDto(AddressDto dto){
        Address result = new Address();

        result.setId(dto.id);
        result.setPostalCode(dto.postalCode);
        result.setPhone(dto.phone);
        result.setAddress(dto.address);
        result.setAddress2(dto.address2);
        result.setDistrict(dto.district);
        result.setLastUpdate(dto.lastUpdate);
        return result;
    }
}
