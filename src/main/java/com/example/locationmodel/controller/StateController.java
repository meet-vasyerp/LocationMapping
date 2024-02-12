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

import com.example.locationmodel.dto.StateDto;
import com.example.locationmodel.service.StateService;

@RestController
@RequestMapping("/api/states")
public class StateController {

	@Autowired
	public StateService stateService;
	
	@GetMapping("")
	public ResponseEntity<List<StateDto>> getAllState(){
		return ResponseEntity.ok(stateService.fetchAll());
	}
	
	@PostMapping({"/addState","/updateState"})
	public String addState(@RequestBody StateDto stateDto) {
		stateService.addState(stateDto);
		return "State Added!";
	}
	
	@DeleteMapping("/deleteState")
	public String deleteState(@RequestParam Long stateId) {
		stateService.deleteById(stateId);
		return "State Deleted!";
	}
	
	@GetMapping("/getStateById")
	public ResponseEntity<StateDto> getStateById(@RequestParam Long stateId){
		return ResponseEntity.ok(stateService.getStateById(stateId));
	}
	
	@GetMapping("/getStatesByCountryId/{countryId}")
	public ResponseEntity<List<StateDto>> getStatesByCountryId(@PathVariable Long countryId){
		return ResponseEntity.ok(stateService.getAllStateByCountryId(countryId));
	}
}



