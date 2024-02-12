package com.example.locationmodel.service;

import java.util.List;

import com.example.locationmodel.dto.CountryDto;

public interface CountryService {
	List<CountryDto> fetchAll();
	
	CountryDto getCountryById(Long countryId);
	
	void addCountry(CountryDto countryDto);
	
	void deleteCountryById(Long countryId);
}
