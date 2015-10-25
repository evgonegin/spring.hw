package com.epam.spring.core.controller;

import java.util.List;

import com.epam.spring.core.dto.Order;
import com.epam.spring.core.model.User;

public interface DiscountStrategy {

	void setDiscount(User user, List<Order> list);	
	
	int getDiscount(User user, List<Order> list);
}
