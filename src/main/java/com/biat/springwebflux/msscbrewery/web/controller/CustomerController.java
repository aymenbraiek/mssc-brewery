package com.biat.springwebflux.msscbrewery.web.controller;

import com.biat.springwebflux.msscbrewery.web.Service.CustomerService;
import com.biat.springwebflux.msscbrewery.web.Service.CustomerServiceImpl;
import com.biat.springwebflux.msscbrewery.web.model.BeerDto;
import com.biat.springwebflux.msscbrewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ReactiveTypeDescriptor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId)
    {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handlePost(CustomerDto customerDto)
    {
      CustomerDto customerDtosave=customerService.saveCustome(customerDto);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("HeaderLocation", customerDto.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }
    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId , @RequestBody CustomerDto customerDto)
    {
        customerService.updateCustomerById(customerId,customerDto);
        return new ResponseEntity((HttpStatus.NO_CONTENT));
    }
    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void handlDelete(@PathVariable("customerId") UUID customerId)
    {
        customerService.deleteByid(customerId);
    }

}
