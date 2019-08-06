package guru.springFramework.msscbrewery.services;

import guru.springFramework.msscbrewery.web.model.CustomerDto;


import java.util.UUID;


public interface CustomerService {

    CustomerDto getCustomerByID(UUID customerId);

    CustomerDto createCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomerById(UUID customerId);
}
