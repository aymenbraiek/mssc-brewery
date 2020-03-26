package com.biat.springwebflux.msscbrewery.web.Service;

import com.biat.springwebflux.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CustomerServiceImpl implements  CustomerService{


    @Override
   public  CustomerDto getCustomerById(UUID id){
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("aymen braiek").build();

    }
}
