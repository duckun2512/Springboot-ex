package com.example.springsecurityasm.service;

import com.example.springsecurityasm.entity.Street;

import java.util.List;
import java.util.Optional;

public interface StreetService {
    List<Street> getAll();
    Optional<Street> findById(int id);
    Street update(int id, Street street);
    List<Street> findByName(String name);
    Street create(Street street);
    List<Street> findByDistrict_id(int id);
}
