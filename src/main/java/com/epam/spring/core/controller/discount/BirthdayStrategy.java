package com.epam.spring.core.controller.discount;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.epam.spring.core.controller.DiscountStrategy;
import com.epam.spring.core.dto.Order;
import com.epam.spring.core.model.User;

public class BirthdayStrategy implements DiscountStrategy {

	@Value("${birthDay.percent}")
	private int percent;

	public void setDiscount(User user, List<Order> list) {
		Calendar cUser = Calendar.getInstance();
		Calendar cEvent = Calendar.getInstance();
		cEvent.setTime(new Date());
		for (Order o : list) {
			cUser.setTime(o.getUser().getBirthday());
			if (cEvent.get(Calendar.MONTH) == cUser.get(Calendar.MONTH)
					&& cEvent.get(Calendar.DAY_OF_MONTH) == cUser.get(Calendar.DAY_OF_MONTH)) {
				o.setPrice(o.getPrice() - o.getPrice() * (percent / 100));
			}
		}
	}

	public int getDiscount(User user, List<Order> list) {
		Calendar cUser = Calendar.getInstance();
		cUser.setTime(user.getBirthday());
		Calendar cEvent = Calendar.getInstance();
		cEvent.setTime(new Date());
		int price = 0;
		for (Order o : list) {
			price += o.getPrice();
		}
		if (cEvent.get(Calendar.MONTH) == cUser.get(Calendar.MONTH)
				&& cEvent.get(Calendar.DAY_OF_MONTH) == cUser.get(Calendar.DAY_OF_MONTH)) {
			return price * (percent / 100);
		}
		return 0;
	}
}
