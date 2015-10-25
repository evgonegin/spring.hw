package com.epam.spring.core.dao.mock;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.epam.spring.core.model.Auditorium;
import com.epam.spring.core.model.Event;
import com.epam.spring.core.model.User;
import com.epam.spring.core.dto.Order;

@Repository
public class MockDB {

	private int userCounter;
	
	private int eventCounter;
	
	private int orderCounter;	
	
	private Map<Event, Auditorium> shcedule;
	
	private Set<Order> booking;
	
	private Set<User> users;
	
	private Set<Auditorium> auditoriums;
	
	@PostConstruct
    public void init(){
		this.booking = new HashSet<Order>();
		this.shcedule = new HashMap<Event, Auditorium>(); 
		this.users = new HashSet<User>();
		this.auditoriums = new HashSet<Auditorium>();
	}
	
	public MockDB() {
	} 
	
	public Set<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		user.setId(userCounter);
		userCounter+=1;
		this.users.add(user);
	}
	
	public void removeUser(User user){
		this.users.remove(user);
	}

	public Set<Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void addAuditorium(Auditorium auditorium) {
		this.auditoriums.add(auditorium);
	}

	public void removeAuditorium(Auditorium auditorium){
		this.auditoriums.remove(auditorium);
	}
	
	public Map<Event, Auditorium> getShcedule() {
		return shcedule;
	}

	public void addEvent(Event event, Auditorium auditorium) {
		event.setId(eventCounter);
		eventCounter +=1;  
		this.shcedule.put(event, auditorium);
	}

	public void removeEvent(Event event) {
		this.shcedule.remove(event);
	}
	
	public Set<Order> getOrders() {
		return booking;
	}

	public void addOrder(Order order) {
		order.setId(orderCounter);
		orderCounter+=1;
		this.booking.add(order);
	}
	
	public void removeOrder(Order order){
		this.booking.remove(order);
	}


	
	
}
