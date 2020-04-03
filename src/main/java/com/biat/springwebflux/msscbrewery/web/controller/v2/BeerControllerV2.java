package com.biat.springwebflux.msscbrewery.web.controller.v2;

import com.biat.springwebflux.msscbrewery.web.Service.V2.BeerServiceV2;
import com.biat.springwebflux.msscbrewery.web.model.BeerDto;
import com.biat.springwebflux.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Slf4j
@Validated
@RestController
@RequestMapping("/api/v2/beer")
@RequiredArgsConstructor
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;




    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeerId(@NotNull  @PathVariable("beerId") UUID beerId) {
        return new ResponseEntity(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody BeerDtoV2 beerDto) {
        log.debug("handler post ..........");
        val beerDtosave = beerServiceV2.saveBeer(beerDto);

        val httpHeaders = new HttpHeaders();
        httpHeaders.add("HeaderLocation", beerDto.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@Valid @RequestBody BeerDtoV2 beerDto) {
        beerServiceV2.updatebeerId(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("beerId") UUID beerId) {
        beerServiceV2.deleteByid(beerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorsHandle(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
