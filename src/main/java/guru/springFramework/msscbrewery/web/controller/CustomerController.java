package guru.springFramework.msscbrewery.web.controller;

import guru.springFramework.msscbrewery.services.CustomerService;
import guru.springFramework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    CustomerService customerService;

    CustomerController(CustomerService customerService)
    {

        this.customerService=customerService;
    }



    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomerID(@PathVariable("customerId") UUID customerId)
    {

        return new ResponseEntity<>(customerService.getCustomerByID(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto)
    {
        CustomerDto savedCustomerDto= customerService.createCustomer(customerDto);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("location","/api/v1/customer/"+savedCustomerDto.getId());
        return new ResponseEntity(httpHeaders,HttpStatus.NO_CONTENT);
    }

    @PutMapping({"{/customerId}"})
    public ResponseEntity handlePut(@PathVariable("customerId") UUID customerId , @RequestBody CustomerDto customerDto)
    {
        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"/{customerId}"})
    public void deleteCustomer(@PathVariable("customerId") UUID customerId)
    {

        customerService.deleteCustomerById(customerId);
    }

}
