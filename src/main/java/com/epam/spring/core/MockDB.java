package com.epam.spring.core;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.epam.spring.core.model.Auditorium;
import com.epam.spring.core.model.Event;
import com.epam.spring.core.dto.Order;

public class MockDB {

	private Map<Event, Auditorium> shcedule;
	
	private Set<Order> booking;

	public MockDB() {
		this.booking = new HashSet<Order>();
		this.shcedule = new HashMap<Event, Auditorium>(); 
	} 
	
	
	public boolean addEvent(Event event, Auditorium auditorium){
		if (isTimeFree(event, auditorium)){
			shcedule.put(event, auditorium);
			return true;
		}		
		return false;
	}
	
	public boolean isTimeFree(Event event, Auditorium auditorium){
	    Iterator<Entry<Event, Auditorium>> it = shcedule.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<Event, Auditorium> pair = it.next();
	        if (auditorium.equals(pair.getValue())){
	        	Date startDate = pair.getKey().getStartDate();
	        	Date endDate = pair.getKey().getEndDate();
	        	if(!(startDate.after(event.getEndDate()) && endDate.before(event.getStartDate()))) {
	        	    return false;
	        	}
	        }
	    }
	    return true;
	}
	
	
	public boolean addOrder(List<Order> orders){
		if (!isOrderListContainExisted(orders)){ 
			for (Order order: orders){
				booking.add(order);				
			}
			return true;
		}
		return false;
	}
	
	public boolean isOrderListContainExisted(List<Order> orders){
		for (Order order: orders){
			if (isOrderExist(order)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isOrderExist(Order order){
		return booking.contains(order);
	}
	
}
