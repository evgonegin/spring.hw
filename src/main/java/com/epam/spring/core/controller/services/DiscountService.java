package com.epam.spring.core.controller.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epam.spring.core.controller.DiscountStrategy;
import com.epam.spring.core.dto.Order;
import com.epam.spring.core.model.User;

public class DiscountService {

	@Autowired
	@Qualifier("BirthdayStrategy")
	DiscountStrategy bs;
	
	@Autowired
	@Qualifier("EveryTicketStrategy")
	DiscountStrategy ets;
	
	public int  getDiscount(User user, List<Order> list){
		List<DiscountStrategy> discountList = new LinkedList<>();
		discountList.add(bs);
		discountList.add(ets);
		int bestDiscount = 0;
		for (DiscountStrategy ds :discountList){
			int discount = ds.getDiscount(user, list);
			if (bestDiscount<discount){
				bestDiscount = discount;
			}
		}
		return bestDiscount;
	}
}
