package com.biat.springwebflux.msscbrewery.web.model.v2;

import lombok.*;

import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDtoV2 {
    private UUID id;
    private String beerName;
    private BeerDtoEnum beerStyle;
    private Long ubc;

}
