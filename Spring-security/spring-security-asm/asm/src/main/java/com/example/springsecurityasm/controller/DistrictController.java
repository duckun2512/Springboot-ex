package com.example.springsecurityasm.controller;

import com.example.springsecurityasm.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/districts")
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(districtService.getAll(), HttpStatus.OK);
    }
}
