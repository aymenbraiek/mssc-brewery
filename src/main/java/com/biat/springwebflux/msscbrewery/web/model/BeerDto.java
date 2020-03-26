package com.biat.springwebflux.msscbrewery.web.model;

import lombok.*;

import java.util.UUID;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long ubc;

}
