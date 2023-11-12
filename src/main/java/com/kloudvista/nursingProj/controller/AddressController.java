package com.kloudvista.nursingProj.controller;


import com.kloudvista.nursingProj.domain.Address;
import com.kloudvista.nursingProj.dto.AddressDto;
import com.kloudvista.nursingProj.repository.AddressRepository;
import com.kloudvista.nursingProj.service.AddressService;
import com.kloudvista.nursingProj.service.AddressServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressServiceImpl;

    @PostMapping("/save")   // http://localhost:9080/address/save
    public ResponseEntity saveAddress(@RequestBody AddressDto addressDto){
        addressServiceImpl.saveAddress(addressDto);
        return  new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/get-by/{country}")  //http://localhost:9080/get-by/{}
    public ResponseEntity<List<Address>>  getByCountry(@PathVariable String country){
        List<Address> country1 = addressServiceImpl.getByCountry(country);
        return new ResponseEntity<>(country1, HttpStatus.OK);
    }

    @GetMapping("/get-all")  //http://localhost:9080/get-all
    public ResponseEntity<List<Address>>  getByProvince(){
        List<Address> addresses = addressServiceImpl.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
}
