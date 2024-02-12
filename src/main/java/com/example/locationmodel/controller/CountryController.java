package com.example.locationmodel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.locationmodel.dto.CountryDto;
import com.example.locationmodel.service.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
	@Autowired
	public CountryService countryService;
	
	@GetMapping("/")
	public ResponseEntity<List<CountryDto>> getAllCountries(){
		return ResponseEntity.ok(countryService.fetchAll());
	}
	
	@GetMapping("/getCountryById")
	public CountryDto getCountryById(@RequestParam Long countryId) {
		return countryService.getCountryById(countryId);
	}
	
	@PostMapping({"/addCountry","/updateCountry"})
	public String addCountry(@RequestBody CountryDto countryDto) {
		countryService.addCountry(countryDto);
		return "Success !";
	}
	
	@DeleteMapping("/deleteCountryById")
	public String deleteCountryById(@RequestParam Long countryId) {
		countryService.deleteCountryById(countryId);
		return "Deleted!";
	}

}
