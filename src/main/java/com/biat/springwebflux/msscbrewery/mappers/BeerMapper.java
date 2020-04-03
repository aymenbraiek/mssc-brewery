package com.biat.springwebflux.msscbrewery.mappers;

import com.biat.springwebflux.msscbrewery.domain.Beer;
import com.biat.springwebflux.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerdtotobeer(Beer beer);
    Beer beertobeertdo(BeerDto beerDto);
}
