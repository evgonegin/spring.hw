package com.epam.spring.core.controller;

import com.epam.spring.core.model.Event;
import com.epam.spring.core.model.User;

public interface DiscountStrategy {

	int getDiscount(User user, Event event);	
	
}
