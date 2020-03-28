package com.biat.springwebflux.msscbrewery.web.model;

import lombok.*;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CustomerDto {
    private UUID id;
    private String name;
}
