package com.example.springsecurityasm.controller;

import com.example.springsecurityasm.entity.Street;
import com.example.springsecurityasm.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/streets")
public class StreetController {
    @Autowired
    StreetService streetService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(@RequestParam(name = "districtId", defaultValue = "-1") int districtId,
                                          @RequestParam(name = "name", required = false) String name) {
        return new ResponseEntity<>(streetService.getAll(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "search/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name) {
        return new ResponseEntity<>(streetService.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Street street) {
        return new ResponseEntity<>(streetService.create(street), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id) {
        Optional<Street> optionalStreet = streetService.findById(id);
        if (optionalStreet.isPresent()) {
            return new ResponseEntity<>(optionalStreet.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Street street) {
        return new ResponseEntity<>(streetService.update(id, street), HttpStatus.ACCEPTED);
    }
}
