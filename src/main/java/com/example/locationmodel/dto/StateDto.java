package com.example.locationmodel.dto;

import com.example.locationmodel.model.Country;

import lombok.Data;

@Data
public class StateDto {

	private Long stateId;
	private String stateName;
	
	private Country country;
}
