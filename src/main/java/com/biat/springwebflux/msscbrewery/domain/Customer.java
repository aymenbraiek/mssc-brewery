package com.biat.springwebflux.msscbrewery.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Customer {
    private UUID id;
    @NotBlank
    @Size(min = 3,max = 12)
    private String name;
}
