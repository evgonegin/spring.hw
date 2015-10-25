package com.epam.spring.core.controller.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epam.spring.core.dao.EventDAO;
import com.epam.spring.core.model.Auditorium;
import com.epam.spring.core.model.Event;

public class AuditoriumService {

	@Autowired
	@Qualifier("EventDAOMock")
	EventDAO eventDAO;
	
	private List<Auditorium> auditoriums;

	public AuditoriumService() {
	}

	public List<Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(List<Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}
	
	public Map<Auditorium, List<Event>> getSchedule(){
		Map<Auditorium, List<Event>> result = new HashMap<>();
		for (Auditorium a: auditoriums){
			result.put(a, new LinkedList<Event>());
		}
		Iterator<Entry<Event, Auditorium>> it = eventDAO.getSchedule().entrySet().iterator();
		while (it.hasNext()) {
			Entry<Event, Auditorium> pair = it.next();
			result.get(pair.getValue()).add(pair.getKey());
		}
		return result;
	}
	
	
}
