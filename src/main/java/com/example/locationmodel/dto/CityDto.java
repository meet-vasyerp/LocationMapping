package com.example.locationmodel.dto;

import com.example.locationmodel.model.State;

import lombok.Data;

@Data
public class CityDto {

	private Long cityId;
	private String cityName;
	
	private State state;

}
