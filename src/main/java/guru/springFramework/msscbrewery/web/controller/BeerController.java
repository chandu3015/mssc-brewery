package guru.springFramework.msscbrewery.web.controller;

import guru.springFramework.msscbrewery.services.BeerService;
import guru.springFramework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    public final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId )
    {


        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }


    @PostMapping
    public  ResponseEntity handlePost(@RequestBody BeerDto beerDto)
    {

        BeerDto savedDto = beerService.saveNewBeer(beerDto);
        HttpHeaders httpHeaders =  new HttpHeaders();
        httpHeaders.add("location","/api/v1/beer/"+savedDto.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerDto)
    {
        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId)
    {
        beerService.deleteById(beerId);
    }


}
