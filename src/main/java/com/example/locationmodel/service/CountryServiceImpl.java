package com.example.locationmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.locationmodel.dto.CountryDto;
import com.example.locationmodel.model.Country;
import com.example.locationmodel.repository.CountryRepo;
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	public CountryRepo countryRepo;
	
	@Override
	public List<CountryDto> fetchAll() {
		List<Country> countries = countryRepo.findAll();
		List<CountryDto> countryDto = new ArrayList<>();
		for (Country country : countries) {
			CountryDto cDto = new CountryDto();
			cDto.setCountyId(country.getCountryId());
			cDto.setCountryName(country.getCountryName());
			countryDto.add(cDto);
		}
		return countryDto;
	}

	@Override
	public CountryDto getCountryById(Long countryId) {
		Country country = countryRepo.findById(countryId).get();
		CountryDto countryDto = new CountryDto();
		countryDto.setCountyId(country.getCountryId());
		countryDto.setCountryName(country.getCountryName());
		return countryDto;
	}

	@Override
	public void addCountry(CountryDto countryDto) {
		Country country=new Country();
		country.setCountryId(countryDto.getCountyId());
		country.setCountryName(countryDto.getCountryName());
		countryRepo.save(country);
	}

	@Override
	public void deleteCountryById(Long countryId) {
		countryRepo.deleteById(countryId);
	}

}
