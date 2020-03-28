package com.biat.springwebflux.msscbrewery.web.Service;

import com.biat.springwebflux.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveBeer(BeerDto beerDto);

    void updatebeerId(UUID beerId,BeerDto beerDto);

    void deleteByid(UUID beerId);
}
