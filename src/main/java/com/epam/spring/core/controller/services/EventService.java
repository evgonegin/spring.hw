package com.epam.spring.core.controller.services;

import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epam.spring.core.dao.EventDAO;
import com.epam.spring.core.model.Auditorium;
import com.epam.spring.core.model.Event;

public class EventService {

	@Autowired
	@Qualifier("EventDAOMock")
	EventDAO eventDAO;

	public boolean addEvent(Event event, Auditorium auditorium) {
		if (isTimeFree(event, auditorium)) {
			eventDAO.add(event, auditorium);
			return true;
		}
		return false;
	}

	public boolean isTimeFree(Event event, Auditorium auditorium) {
		Iterator<Entry<Event, Auditorium>> it = eventDAO.getSchedule().entrySet().iterator();
		while (it.hasNext()) {
			Entry<Event, Auditorium> pair = it.next();
			if (auditorium.equals(pair.getValue())) {
				Date startDate = pair.getKey().getStartDate();
				Date endDate = pair.getKey().getEndDate();
				if (!(startDate.after(event.getEndDate()) && endDate.before(event.getStartDate()))) {
					return false;
				}
			}
		}
		return true;
	}

}
