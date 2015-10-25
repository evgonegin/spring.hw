package com.epam.spring.core;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.core.model.Auditorium;
import com.epam.spring.core.model.User;
import com.epam.spring.core.controller.services.AuditoriumService;
import com.epam.spring.core.controller.services.DiscountService;
import com.epam.spring.core.dto.Order;

public class App 
{
    public static void main( String[] args )
    {
    	User user = new User();
    	List<Order> list = new LinkedList<>();
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	DiscountService ds = (DiscountService) ctx.getBean("DiscountService");
    	AuditoriumService as = (AuditoriumService) ctx.getBean("AuditoriumService");
    	ds.getDiscount(user, list);
    	
        System.out.println( "Hello World!" );
    }
    
}
