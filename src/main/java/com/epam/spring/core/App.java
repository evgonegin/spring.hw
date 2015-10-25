package com.epam.spring.core;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.core.model.Auditorium;
import com.epam.spring.core.model.Event;
import com.epam.spring.core.model.Rating;
import com.epam.spring.core.model.User;
import com.epam.spring.core.controller.services.AuditoriumService;
import com.epam.spring.core.controller.services.DiscountService;
import com.epam.spring.core.controller.services.EventService;
import com.epam.spring.core.dto.Order;

public class App 
{
    public static void main( String[] args )
    {
//    	User user = new User();
//    	List<Order> list = new LinkedList<>();
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	AuditoriumService auditoriumService = (AuditoriumService) ctx.getBean("AuditoriumService");
    	EventService eventService = (EventService) ctx.getBean("EventService");
    	createSchedule(eventService, auditoriumService);
    	printSchedule(auditoriumService);
    	
    	

    }
    
    private static void createSchedule(EventService eventService, AuditoriumService auditoriumService){
    	String msg = "Can't create event, because time is buzy. ";
    	/*Create Schedule start: */
    	DateTime startDate = new DateTime(2015, 1, 1, 10, 0, 0);
    	DateTime endDate = new DateTime(2015, 1, 1, 11, 0, 0);
    	Event event = new Event("Event1", startDate.toDate(), endDate.toDate(), 200, Rating.HIGH);
    	if (!eventService.addEvent(event, auditoriumService.getAuditoriums().get(0))){
    		printError(msg,event);
    	}	
    	startDate = new DateTime(2015, 1, 1, 12, 0, 0);
    	endDate = new DateTime(2015, 1, 1, 13, 0, 0);
    	event = new Event("Event2", startDate.toDate(), endDate.toDate(), 200, Rating.HIGH);
    	if (!eventService.addEvent(event, auditoriumService.getAuditoriums().get(0))){
    		printError(msg,event);
    	}
    	startDate = new DateTime(2015, 1, 1, 11, 30, 0);
    	endDate = new DateTime(2015, 1, 1, 13, 30, 0);
    	event = new Event("Event3_with_error", startDate.toDate(), endDate.toDate(), 200, Rating.HIGH);
    	if (!eventService.addEvent(event, auditoriumService.getAuditoriums().get(0))){
    		printError(msg,event);
    	}
    	startDate = new DateTime(2015, 1, 1, 11, 30, 0);
    	endDate = new DateTime(2015, 1, 1, 13, 30, 0);
    	event = new Event("Event4", startDate.toDate(), endDate.toDate(), 200, Rating.HIGH);
    	if (!eventService.addEvent(event, auditoriumService.getAuditoriums().get(1))){
    		printError(msg,event);
    	}
    	/*Create Schedule end. */
   	
    }
    
    private static void printSchedule(AuditoriumService auditoriumService){
    	Map<Auditorium, List<Event>> shedule= auditoriumService.getSchedule();
		Iterator<Entry<Auditorium, List<Event>>> it = shedule.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Auditorium, List<Event>> pair = it.next();
			printText("===", pair.getKey());
			for (Event e : pair.getValue()){
				printText("======", e);
			}
		}
    }
    
    private static void printError(String msg,Object obj){
    	System.out.println("ERROR: "+msg+" "+obj.toString()+"\n");
    }
    
    private static void printText(String msg,Object obj){
    	System.out.println("--> "+msg+" "+obj.toString()+"\n");
    }
}
