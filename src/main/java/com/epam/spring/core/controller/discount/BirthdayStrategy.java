package com.epam.spring.core.controller.discount;

import com.epam.spring.core.controller.DiscountStrategy;
import com.epam.spring.core.model.Event;
import com.epam.spring.core.model.User;

public class BirthdayStrategy implements DiscountStrategy {

	private int percent;
	
	public int getDiscount(User user, Event event) {
		// TODO Auto-generated method stub
		return 0;
	}

}
