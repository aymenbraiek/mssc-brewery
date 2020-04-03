package com.biat.springwebflux.msscbrewery.mappers;

import com.biat.springwebflux.msscbrewery.domain.Customer;
import com.biat.springwebflux.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerdto(Customer customer);
    Customer customerdtoToCustomer(CustomerDto customerDto);
}
