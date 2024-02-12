package com.example.locationmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.locationmodel.dto.CityDto;
import com.example.locationmodel.dto.StateDto;
import com.example.locationmodel.model.City;
import com.example.locationmodel.model.State;
import com.example.locationmodel.repository.CityRepo;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	public CityRepo cityRepo;
	
	@Override
	public List<CityDto> fetchAll() {
		List<City> cities = cityRepo.findAll();
		List<CityDto> citydto = new ArrayList<>();
		for (City city : cities) {
			CityDto cityDto = new CityDto();
			cityDto.setCityId(city.getCityId());
			cityDto.setCityName(city.getCityName());
			cityDto.setState(city.getState());
			citydto.add(cityDto);	
		}
		
		return citydto;
	}

	@Override
	public void addCity(CityDto cityDto) {
		City city=new City();
		city.setCityId(cityDto.getCityId());
		city.setCityName(cityDto.getCityName());
		city.setState(cityDto.getState());
		cityRepo.save(city);
	}

	@Override
	public void deleteById(Long cityId) {
		cityRepo.deleteById(cityId);
	}

	@Override
	public CityDto getCityById(Long cityId) {
		City city = cityRepo.findById(cityId).get();
		CityDto cityDto= new CityDto();
		cityDto.setCityId(city.getCityId());
		cityDto.setCityName(city.getCityName());
		cityDto.setState(city.getState());
		
		return cityDto;
	}

	@Override
	public List<CityDto> findCityByStateId(Long stateId) {
		List<City> cities = cityRepo.findCitiesByStateId(stateId);
		List<CityDto> cityD = new ArrayList<>();
		for (City city : cities) {
			CityDto citydto = new CityDto();
			citydto.setCityId(city.getCityId());
			citydto.setCityName(city.getCityName());
			citydto.setState(city.getState());
			cityD.add(citydto);
			
		}
		return cityD;
		
	}

	

}
