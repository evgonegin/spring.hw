package com.epam.spring.core.dao;

import java.util.List;
import java.util.Map;

import com.epam.spring.core.model.Auditorium;
import com.epam.spring.core.model.Event;

public interface EventDAO {

	boolean add(Event event, Auditorium auditorium);
	
	boolean remove(Event event);
	
	boolean update(Event event);
	
	Event findByID(int id);

	Event findByName(String name);
	
	List<Event> getAll();
	
	Map<Event, Auditorium> getSchedule();
}
