package sk.posam.fsa.du.boot.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
public interface DvdRentalApi {
    @GetMapping("/customers/{id}")
    CustomerDto one(@PathVariable Long id);

    @GetMapping("/customers")
    Iterable<CustomerDto> all(@RequestParam(name = "lastName", required = false) String lastNameFilter,
                              @RequestParam(name = "firstName", required = false) String firstNameFiler);

    @GetMapping("/customers/active")
    Iterable<CustomerDto> getByActive();

    @GetMapping("/customers/orderBy")
    public Iterable<CustomerDto> getAllByOrderBy(@RequestParam(name="lastName") String orderByLastNameFilter);

    @GetMapping("/customers/older-than")
    public Iterable<CustomerDto> getOlderCustomers(@RequestParam(name = "years", required = false) Integer yearsFilter);

    @PostMapping("/customers")
    CustomerDto newCustomer(@RequestBody CustomerDto newCustomer);

    @PutMapping("/customers/{id}")
    CustomerDto replaceCustomer(@RequestBody CustomerDto newCustomer, @PathVariable Long id);

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id);
}
