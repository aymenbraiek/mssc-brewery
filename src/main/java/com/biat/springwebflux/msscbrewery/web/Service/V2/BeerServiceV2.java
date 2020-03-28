package com.biat.springwebflux.msscbrewery.web.Service.V2;

import com.biat.springwebflux.msscbrewery.web.model.BeerDto;
import com.biat.springwebflux.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    Object getBeerById(UUID beerId);

    BeerDto saveBeer(BeerDtoV2 beerDto);

    void updatebeerId(UUID beerId, BeerDtoV2 beerDto);

    void deleteByid(UUID beerId);
}
