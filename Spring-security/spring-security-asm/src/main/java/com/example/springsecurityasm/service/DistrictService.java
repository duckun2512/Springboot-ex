package com.example.springsecurityasm.service;

import com.example.springsecurityasm.controller.DistrictController;
import com.example.springsecurityasm.entity.District;

import java.util.List;

public interface DistrictService {
    List<District> getAll();
}
