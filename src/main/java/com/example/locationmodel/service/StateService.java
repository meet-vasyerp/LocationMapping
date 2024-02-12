package com.example.locationmodel.service;

import java.util.List;

import com.example.locationmodel.dto.StateDto;

public interface StateService {
	
	List<StateDto> fetchAll();
	
	void addState(StateDto stateDto);
	
	void deleteById(Long stateId);
	
	StateDto getStateById(Long stateId);
	
	List<StateDto> getAllStateByCountryId(Long countryId);
}
