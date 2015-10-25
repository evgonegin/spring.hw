package com.epam.spring.core.dao.mock;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.spring.core.MockDB;
import com.epam.spring.core.dao.EventDAO;
import com.epam.spring.core.model.Event;

@Component(value = "EventDAOMock")
public class EventDAOMock implements EventDAO {

	@Autowired
	MockDB mockDB;
	
	public boolean add(Event event) {
		if (!mockDB.getShcedule().contains(event)) {
			mockDB.addEvent(event);
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(Event event) {
		for (Event e: mockDB.getShcedule()){
			if (event.equals(e)){
				mockDB.removeEvent(e);
				return true;
			}
		}
		return false;
	}

	public boolean update(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	public Event findByID(int id) {
		for (Event e: mockDB.getShcedule()){
			if (id == e.getId()){
				return e;
			}
		}
		return null;
	}

	public Event findByName(String name) {
		for (Event e: mockDB.getShcedule()){
			if (name.equals(e.getName())){
				return e;
			}
		}
		return null;
	}

	public List<Event> getAll() {
		return new LinkedList<Event>(mockDB.getShcedule());
	}

}
