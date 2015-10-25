package com.epam.spring.core.controller.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.epam.spring.core.controller.DiscountStrategy;
import com.epam.spring.core.dao.OrderDAO;
import com.epam.spring.core.dto.Order;
import com.epam.spring.core.model.User;

public class EveryTicketStrategy implements DiscountStrategy {

	@Value("${everyTicket.percent}")
	private int percent;
	@Value("${everyTicket.ticketCount}")
	private int ticketCount;

	@Autowired
	@Qualifier("OrderDAOMock")
	OrderDAO orderDAO;

	@Override
	public void setDiscount(User user, List<Order> list) {
		int size = orderDAO.getBookedTickets(user).size();
		for (Order o : list) {
			size += 1;
			if (size % ticketCount == 0)
				o.setPrice(o.getPrice() - o.getPrice() * (percent / 100));
		}
	}

	public int getDiscount(User user, List<Order> list) {
		int price = 0;
		for (Order o : list) {
			price += o.getPrice();
		}

		int size = orderDAO.getBookedTickets(user).size();
		int sizeAll = size + list.size();
		int count = sizeAll / ticketCount - size / ticketCount;
		if (count > 0) {
			return price * (percent / 100 * count);
		}
		return 0;
	}

}
