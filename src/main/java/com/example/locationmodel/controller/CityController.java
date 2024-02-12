package com.example.locationmodel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.locationmodel.dto.CityDto;
import com.example.locationmodel.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {
	
	@Autowired
	public CityService cityService;
	
	@GetMapping("/")
	public ResponseEntity<List<CityDto>> getAllCities(){
		return ResponseEntity.ok(cityService.fetchAll());
	}
	
	@GetMapping("/getCityById")
	public CityDto getCityById(@RequestParam Long cityId) {
		return cityService.getCityById(cityId);
	}
	
	@PostMapping({"/addCity","/updateCity"})
	public String addCity(@RequestBody CityDto cityDto) {
		cityService.addCity(cityDto);
		return "Success";
	}
	
	@DeleteMapping("/deleteById")
	public String deleteById(@RequestParam Long cityId) {
		cityService.deleteById(cityId);
		return "Deleted!";
	}

	@GetMapping("/getCitiesByStateId/{stateId}")
	public ResponseEntity<List<CityDto>> getCitiesByStatId(@PathVariable Long stateId){
		return ResponseEntity.ok(cityService.findCityByStateId(stateId));
	}
}
