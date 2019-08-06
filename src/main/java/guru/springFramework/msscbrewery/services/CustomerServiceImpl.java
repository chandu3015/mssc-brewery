package guru.springFramework.msscbrewery.services;

import guru.springFramework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public CustomerDto getCustomerByID(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("CHANDU").build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(customerDto.getId()).name(customerDto.getName()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("In customer update service");
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("In customer deletion service");
    }
}
