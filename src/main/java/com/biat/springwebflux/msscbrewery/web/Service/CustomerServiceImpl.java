package com.biat.springwebflux.msscbrewery.web.Service;

import com.biat.springwebflux.msscbrewery.web.model.CustomerDto;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Slf4j
public class CustomerServiceImpl implements  CustomerService{


    @Override
   public  CustomerDto getCustomerById(UUID id){
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("aymen braiek").build();

    }

    @Override
    public CustomerDto saveCustome(CustomerDto customerDto) {
        return customerDto.builder().id(UUID.randomUUID())
    .build();
    }

    @Override
    public void deleteByid(UUID customerId) {
        System.out.println("delete  Customer");
        log.debug("delete loading.........");
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDto customerDto) {
        System.out.println("update Customer");
        log.debug("update loading ");
    }
}
