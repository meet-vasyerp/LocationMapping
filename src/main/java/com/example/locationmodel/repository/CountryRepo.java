package com.example.locationmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locationmodel.model.Country;

public interface CountryRepo extends JpaRepository<Country, Long>{

}
