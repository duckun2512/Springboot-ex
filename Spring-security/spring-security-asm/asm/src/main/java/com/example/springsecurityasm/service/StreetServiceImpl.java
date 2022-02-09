package com.example.springsecurityasm.service;

import com.example.springsecurityasm.entity.Street;
import com.example.springsecurityasm.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    StreetRepository streetRepository;

    @Override
    public List<Street> getAll() {
        return streetRepository.findAll();
    }

    @Override
    public Optional<Street> findById(int id) {
        return streetRepository.findById(id);
    }

    @Override
    public Street update(int id, Street street) {
        Street exist = streetRepository.getById(id);
        if (exist == null){
            return null;
        }
        exist.setDescription(street.getDescription());
        exist.setDistrict(street.getDistrict());
        exist.setName(street.getName());
        exist.setStatus(street.getStatus());
        return streetRepository.save(exist);
    }

    @Override
    public List<Street> findByName(String name) {
        return streetRepository.findByName(name);
    }

    @Override
    public Street create(Street street) {
        street.setCreatedAt(LocalDate.now());
        return streetRepository.save(street);
    }

    @Override
    public List<Street> findByDistrict_id(int id) {
        return streetRepository.findStreetsByDistrict_id(id);
    }
}
