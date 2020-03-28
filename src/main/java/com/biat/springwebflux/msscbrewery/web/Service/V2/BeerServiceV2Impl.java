package com.biat.springwebflux.msscbrewery.web.Service.V2;

import com.biat.springwebflux.msscbrewery.web.model.BeerDto;
import com.biat.springwebflux.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public Object getBeerById(UUID beerId) {
        return null;
    }

    @Override
    public BeerDto saveBeer(BeerDtoV2 beerDto) {
        return null;
    }

    @Override
    public void updatebeerId(UUID beerId, BeerDtoV2 beerDto) {

    }

    @Override
    public void deleteByid(UUID beerId) {

    }
}
