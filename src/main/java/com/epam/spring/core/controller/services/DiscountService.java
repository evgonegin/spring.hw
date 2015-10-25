package com.epam.spring.core.controller.services;

import java.util.List;

import com.epam.spring.core.controller.DiscountStrategy;
import com.epam.spring.core.dto.Order;
import com.epam.spring.core.model.User;

public class DiscountService {

	private List<DiscountStrategy> discountList;

	public List<DiscountStrategy> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<DiscountStrategy> discountList) {
		this.discountList = discountList;
	}

	public int getDiscount(User user, List<Order> list) {
		int bestDiscount = 0;
		for (DiscountStrategy ds : discountList) {
			int discount = ds.getDiscount(user, list);
			if (bestDiscount < discount) {
				bestDiscount = discount;
			}
		}
		return bestDiscount;
	}

	public void setDiscount(User user, List<Order> list) {
		int bestDiscount = 0;
		DiscountStrategy bestDS = null;
		for (DiscountStrategy ds : discountList) {
			int discount = ds.getDiscount(user, list);
			if (bestDiscount < discount) {
				bestDiscount = discount;
				bestDS = ds;
			}
		}
		if (bestDS != null) {
			bestDS.setDiscount(user, list);
		}
	}
}
