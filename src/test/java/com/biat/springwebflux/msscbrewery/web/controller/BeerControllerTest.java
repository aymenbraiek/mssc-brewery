package com.biat.springwebflux.msscbrewery.web.controller;

import com.biat.springwebflux.msscbrewery.web.Service.BeerService;

import static org.mockito.ArgumentMatchers.anyVararg;
import static org.mockito.BDDMockito.given;

import com.biat.springwebflux.msscbrewery.web.model.BeerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.any;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.then;


import java.util.UUID;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @MockBean
    BeerService beerService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    @Before
    public void setUp() {

        validBeer = BeerDto.builder().id(UUID.randomUUID())
                .beerName("Beer1")
                .beerStyle("PALE_ALE")
                .ubc(123456789012L)
                .build();
        System.out.println("bonjou"+validBeer.toString());
    }

    @Test
    public void getBeer() throws Exception {
        validBeer = BeerDto.builder().id(UUID.randomUUID())
                .beerName("Beer1")
                .beerStyle("PALE_ALE")
                .ubc(123456789012L)
                .build();
System.out.println("beer not null"+validBeer.toString());
        BDDMockito.given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(validBeer.getId().toString())))
        .andExpect(MockMvcResultMatchers.jsonPath("$.beerName", is("Beer1")));
    }

    @Test
    public void handlePost() throws Exception {
        //given

        BeerDto beerDto = getBeerDto();
       beerDto.setId(null);
        BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveBeer((any()))).willReturn(savedDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void handleUpdate() throws Exception {
        //given

       BeerDto beerDto=getBeerDto();
       beerDto.setId(null);
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        //when
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        then(beerService).should().updatebeerId(any(), any());

    }
     BeerDto  getBeerDto()
     {
         return  BeerDto.builder().id(UUID.randomUUID())
             .beerName("Beer1")
             .beerStyle("PALE_ALE")
             .ubc(123456789012L)
             .build();
     }
}