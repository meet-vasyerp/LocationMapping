package com.example.locationmodel.service;

import java.util.List;

import com.example.locationmodel.dto.CityDto;

public interface CityService {
	
	List<CityDto> fetchAll();
	
	void addCity(CityDto cityDto);
	
	void deleteById(Long cityId);
	
	CityDto getCityById(Long cityId);

	List<CityDto> findCityByStateId(Long stateId);
}
