package com.epam.spring.core.controller.services;

import java.util.List;

import com.epam.spring.core.model.Auditorium;

public class AuditoriumService {

	private List<Auditorium> auditoriums;

	public AuditoriumService() {
	}

	public List<Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(List<Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}
	
	
	
	
}
