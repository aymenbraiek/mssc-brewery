package com.biat.springwebflux.msscbrewery.web.Service;

import com.biat.springwebflux.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
