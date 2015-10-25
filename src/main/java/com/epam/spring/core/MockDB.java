package com.epam.spring.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	private Set<Event> shcedule;
	
	private Set<Order> booking;
	
	private Set<User> users;
	
	private Set<Auditorium> auditoriums;
	
    public void init(){
		this.booking = new HashSet<Order>();
		this.shcedule = new HashSet<Event>(); 
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
	
	public Set<Event> getShcedule() {
		return shcedule;
	}

	public void addEvent(Event event) {
		event.setId(eventCounter);
		eventCounter +=1;  
		this.shcedule.add(event);
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

//	public boolean addEvent(Event event, Auditorium auditorium){
//		if (isTimeFree(event, auditorium)){
//			shcedule.put(event, auditorium);
//			return true;
//		}		
//		return false;
//	}
	
	
	
//	public boolean isTimeFree(Event event, Auditorium auditorium){
//	    Iterator<Entry<Event, Auditorium>> it = shcedule.entrySet().iterator();
//	    while (it.hasNext()) {
//	        Entry<Event, Auditorium> pair = it.next();
//	        if (auditorium.equals(pair.getValue())){
//	        	Date startDate = pair.getKey().getStartDate();
//	        	Date endDate = pair.getKey().getEndDate();
//	        	if(!(startDate.after(event.getEndDate()) && endDate.before(event.getStartDate()))) {
//	        	    return false;
//	        	}
//	        }
//	    }
//	    return true;
//	}
	
	
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
