package com.biat.springwebflux.msscbrewery.web.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CustomerDto {
    private UUID id;
    @NotBlank
    @Size(min = 3,max = 12)
    private String name;
}
