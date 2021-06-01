package com.alexyom.dojos.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexyom.dojos.models.Event;
import com.alexyom.dojos.models.Message;
import com.alexyom.dojos.models.User;
import com.alexyom.dojos.repositories.EventRepository;
import com.alexyom.dojos.repositories.MessageRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;
	@Autowired
	private MessageRepository mRepo;
	
	//Get All Events
	public List<Event> getEvents() {
		return this.eRepo.findAll();
	}
	
	//Get All Events in State
	public List<Event> allEventsWithState(String state) {
		return this.eRepo.findByStateOrderByEventDateDesc(state);
	}
	
	//Get All Events NOT in State
	public List<Event> allEventsNotState(String state) {
		return this.eRepo.findByStateIsNot(state);
	}
	
	//Find Event By id
	public Event findById(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	//Create
	public Event create(Event event) {
		return this.eRepo.save(event);
	}
	
	//Update
	public Event update(Event event) {
		return this.eRepo.save(event);
	}
	
	//Delete
	public void delete(Long id) {
		this.eRepo.deleteById(id);
	}
	
	//Comment on Event
	public void comment(User author, String comment, Event event) {
		this.mRepo.save(new Message(author, comment, event));
	}
	
	//Delete Comment on Event
	public void deleteComment(Long id) {
		this.mRepo.deleteById(id);
	}
	
	//Manage Attendees (Optional)
	public void manageAttendees(Event event, User user, boolean isJoining) {
		if (isJoining) {
			event.getAttendees().add(user);
		} else {
			event.getAttendees().remove(user);
		}
		this.eRepo.save(event);
	}
	
	//Add Attendee to Event
	public void addAttendee(Event event, User user) {
		List<User> attendees = event.getAttendees();
		attendees.add(user);
		this.eRepo.save(event);
	}
	
	//Remove Attendee from Event
	public void removeAttendee(Event event, User user) {
		List<User> attendees = event.getAttendees();
		attendees.remove(user);
		this.eRepo.save(event);
	}
}
