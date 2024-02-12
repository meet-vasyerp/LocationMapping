package com.example.locationmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.locationmodel.dto.StateDto;
import com.example.locationmodel.model.State;
import com.example.locationmodel.repository.StateRepo;

@Service
public class StateServiceImpl implements StateService{

	@Autowired
	public StateRepo stateRepo;
	
	@Override
	public List<StateDto> fetchAll() {
		List<State> states = stateRepo.findAll();
		List<StateDto> stateDto = new ArrayList<>();
		
		for (State state : states) {
			StateDto Dto = new StateDto();
			Dto.setStateId(state.getStateId());
			Dto.setStateName(state.getStateName());
			Dto.setCountry(state.getCountry());
			stateDto.add(Dto);
		}
		return stateDto;
	}

	@Override
	public void addState(StateDto  stateDto) {
		State state;
		if(stateDto.getStateId() == null)
			state = new State();
		else
			state = stateRepo.findById(stateDto.getStateId()).get();
		
		state.setStateId(stateDto.getStateId());
		state.setStateName(stateDto.getStateName());
		state.setCountry(stateDto.getCountry());
		stateRepo.save(state);
	}

	@Override
	public void deleteById(Long stateId) {
		stateRepo.deleteById(stateId);
	}

	@Override
	public StateDto getStateById(Long stateId) {
		State state=stateRepo.findById(stateId).get();
		StateDto stateDto = new StateDto();
		stateDto.setStateId(state.getStateId());
		stateDto.setStateName(state.getStateName());
		stateDto.setCountry(state.getCountry());
		return stateDto;
	}

	@Override
	public List<StateDto> getAllStateByCountryId(Long countryId) {
		List<State> states = stateRepo.findStateByCountryId(countryId);
		List<StateDto> stateDto = new ArrayList<>();
		for (State state : states) {
			StateDto statedto = new StateDto();
			statedto.setStateId(state.getStateId());
			statedto.setStateName(state.getStateName());
			statedto.setCountry(state.getCountry());
			stateDto.add(statedto);
		}
		return stateDto;
	}
		
	}
