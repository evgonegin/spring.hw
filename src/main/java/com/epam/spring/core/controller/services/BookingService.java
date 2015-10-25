package com.epam.spring.core.controller.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epam.spring.core.dao.OrderDAO;
import com.epam.spring.core.dto.Order;
import com.epam.spring.core.model.Auditorium;
import com.epam.spring.core.model.Event;
import com.epam.spring.core.model.User;

public class BookingService {

	private int vipPersent;
	
	private DiscountService discountService;
	
	@Autowired
	@Qualifier("OrderDAOMock")
	OrderDAO orderDAO;
		
	public int getTicketPrice(Event event, int seat, User user){
		Auditorium auditorium = event.getAuditorium();
		int price = event.getPrice();
		if (auditorium.getVipSeats().contains(new Integer(seat))){
			price = price+price*(vipPersent/100);
		}
		List<Order> list = new LinkedList<>();
		list.add(new Order(user,event,seat,price));
		return price - discountService.getDiscount(user, list);
	}

	public boolean bookTicket(Order order){
		List<Order> list = new LinkedList<>();
		list.add(order);
		discountService.setDiscount(order.getUser(), list);
		if (!orderDAO.getAll().contains(order)){
			orderDAO.add(order);
			return true;
		}		
		return false;
	}
	
	public int getVipPersent() {
		return vipPersent;
	}

	public void setVipPersent(int vipPersent) {
		this.vipPersent = vipPersent;
	}

	public DiscountService getDiscountService() {
		return discountService;
	}

	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}


	
}
