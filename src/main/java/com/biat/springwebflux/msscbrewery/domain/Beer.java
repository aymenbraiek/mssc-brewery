package com.biat.springwebflux.msscbrewery.domain;

import com.biat.springwebflux.msscbrewery.web.model.v2.BeerDtoEnum;
import lombok.*;

import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {
    private UUID id;
    private String beerName;
    private BeerDtoEnum beerStyle;
    private Long ubc;
}
