package com.biat.springwebflux.msscbrewery.web.controller.v2;

import com.biat.springwebflux.msscbrewery.web.Service.V2.BeerServiceV2;
import com.biat.springwebflux.msscbrewery.web.model.BeerDto;
import com.biat.springwebflux.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeerId(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(BeerDtoV2 beerDto) {
        BeerDto beerDtosave = beerServiceV2.saveBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HeaderLocation",  beerDto.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        beerServiceV2.updatebeerId(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("beerId") UUID beerId)
    {
        beerServiceV2.deleteByid(beerId);
    }
}
