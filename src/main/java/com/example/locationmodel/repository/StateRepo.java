package com.example.locationmodel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.locationmodel.model.State;

public interface StateRepo extends JpaRepository<State, Long> {
	
	@Query(value = "select * from state s where s.country_country_id=?1", nativeQuery = true)
	public List<State> findStateByCountryId(Long countryId);

}
