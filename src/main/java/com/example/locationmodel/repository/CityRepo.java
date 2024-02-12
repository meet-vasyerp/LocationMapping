package com.example.locationmodel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.locationmodel.model.City;
import com.example.locationmodel.model.State;

public interface CityRepo extends JpaRepository<City, Long>{
	
	@Query(value = "select * from City c where c.state_state_id=?1", nativeQuery = true)
	public List<City> findCitiesByStateId(Long  stateId);

}
