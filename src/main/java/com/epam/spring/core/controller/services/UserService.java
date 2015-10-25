package com.epam.spring.core.controller.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epam.spring.core.dao.OrderDAO;
import com.epam.spring.core.dao.UserDAO;
import com.epam.spring.core.model.Event;
import com.epam.spring.core.model.User;
import com.epam.spring.core.dto.Order;


public class UserService {

	@Autowired
	@Qualifier("UserDAOMock")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("OrderDAOMock")
	OrderDAO orderDAO;
	
	public User add(String name, String email, Date birthday){
		User user = new User(name, email, birthday);
	    return (userDAO.add(user)) ? user:null;
	}
	
	public List<Order> getBookedTickets(User user){
		return orderDAO.getBookedTickets(user);
	}
	
	public List<Order> getBookedTickets(User user, Event event){
		return orderDAO.getBookedTickets(user, event);
	}
	
}
