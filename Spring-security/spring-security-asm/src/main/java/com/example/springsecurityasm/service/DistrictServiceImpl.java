package com.example.springsecurityasm.service;

import com.example.springsecurityasm.entity.District;
import com.example.springsecurityasm.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<District> getAll() {
        return districtRepository.findAll();
    }
}
