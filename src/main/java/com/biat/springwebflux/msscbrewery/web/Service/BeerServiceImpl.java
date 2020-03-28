package com.biat.springwebflux.msscbrewery.web.Service;

import com.biat.springwebflux.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy cat")
                .beerStyle("Pale pe")

                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return beerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updatebeerId(UUID beerId, BeerDto beerDto) {
        System.out.println("update beer");
    }

    @Override
    public void deleteByid(UUID beerId) {

    }
}
