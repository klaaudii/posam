package sk.posam.fsa.du.boot.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.du.boot.api.CustomerDto;
import sk.posam.fsa.du.boot.api.DvdRentalApi;
import sk.posam.fsa.du.boot.application.assembler.CustomerAssembler;
import sk.posam.fsa.du.boot.application.repository.CustomerCrudRepository;
import sk.posam.fsa.du.boot.domain.Customer;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@RestController
public class DvdRentalApiController implements DvdRentalApi {

    final String orderByAsc = "asc";
    final String orderByDesc = "desc";

    @Autowired
    private CustomerCrudRepository customerCrudRepository;

    private CustomerAssembler customerAssembler = new CustomerAssembler();
    @Override
    public CustomerDto one(Long id) {
        Optional<Customer> actor = customerCrudRepository.findById(id);
        return actor.map(customerAssembler::toDto)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public Iterable<CustomerDto> all(String lastNameFilter, String firstNameFilter) {
        if (lastNameFilter != null && firstNameFilter != null){
            return customerAssembler.toDto(customerCrudRepository.
                    findByLastNameAndFirstName(lastNameFilter, firstNameFilter));
        } else if (lastNameFilter != null && !lastNameFilter.isEmpty()) {
            return customerAssembler.toDto(customerCrudRepository.findByLastName(lastNameFilter));
        } else if (firstNameFilter != null && !firstNameFilter.isEmpty()) {
            return customerAssembler.toDto(customerCrudRepository.findByFirstName(firstNameFilter));
        } else {
            return customerAssembler.toDto(customerCrudRepository.findAll());
        }
    }

    @Override
    public Iterable<CustomerDto> getByActive() {
        return customerAssembler.toDto(customerCrudRepository.findByActiveBool(true));
    }

    @Override
    public Iterable<CustomerDto> getAllByOrderBy(String orderByLastNameFilter){
        if (orderByLastNameFilter.equals(orderByDesc)){
            return customerAssembler.toDto(customerCrudRepository.findAllByOrderByLastNameDesc());
        } else {
            return customerAssembler.toDto(customerCrudRepository.findAllByOrderByLastNameAsc());
        }
    }

    @Override
    public Iterable<CustomerDto> getOlderCustomers(Integer yearsFilter){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -yearsFilter);
        Date xYearsAgo = cal.getTime();
        return customerAssembler.toDto(customerCrudRepository.findAllOlderThan(xYearsAgo));
    }


    @Override
    public CustomerDto newCustomer(CustomerDto dto) {
        dto.lastUpdate=new Date();
        Customer newCustomer = customerCrudRepository.save(customerAssembler.fromDto(dto));
        return customerAssembler.toDto(newCustomer);
    }


    @Override
    public CustomerDto replaceCustomer(CustomerDto dto, Long id) {

        return customerCrudRepository.findById(id)
                .map(actor -> {
                    actor.setFirstName(dto.firstName);
                    actor.setLastName(dto.lastName);
                    Customer newCustomer = customerCrudRepository.save(actor);
                    return customerAssembler.toDto(newCustomer);
                })
                .orElseGet(() -> {
                    dto.id=id;
                    Customer newCustomer = customerCrudRepository.save(customerAssembler.fromDto(dto));
                    return customerAssembler.toDto(newCustomer);
                });
    }

    @Override
    public void deleteCustomer( Long id) {
        customerCrudRepository.deleteById(id);
    }
}
