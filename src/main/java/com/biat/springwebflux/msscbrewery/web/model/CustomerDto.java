package com.biat.springwebflux.msscbrewery.web.model;

import lombok.*;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerDto {
    private UUID id;
    private String name;
}
