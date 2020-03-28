package com.biat.springwebflux.msscbrewery.web.Service;

import com.biat.springwebflux.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    static void UpdateCustomerById(UUID customerId, CustomerDto customerDto) {
    }

   

    CustomerDto getCustomerById(UUID id);

    CustomerDto saveCustome(CustomerDto customerDto);

    void deleteByid(UUID customerId);

    void updateCustomerById(UUID customerId, CustomerDto customerDto);
}
