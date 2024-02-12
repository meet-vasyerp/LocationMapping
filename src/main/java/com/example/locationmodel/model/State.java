package com.example.locationmodel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class State {
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY )
		private Long stateId;
		@Column(name="state_name")
		private String stateName;
		
		@ManyToOne
		private Country country;
}
