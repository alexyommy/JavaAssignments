package com.alexyom.dojos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
    private String name;
	
	@Future
	@NotNull
	@DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date eventDate;
	
    @NotBlank
    private String city;
    
    @NotBlank
	private String state;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //Attendees and Events
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_events", 
        joinColumns = @JoinColumn(name = "event_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> attendees;
    
    //Messages on Event
    @OneToMany(fetch=FetchType.LAZY, mappedBy="event", cascade = CascadeType.ALL)
    private List<Message> messages;
    
    //Planner of Event
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User planner;

	public Event() {
	}
	
	public Event(String name, Date eventDate, String city, String state) {
		this.name = name;
		this.eventDate = eventDate;
		this.city = city;
		this.state = state;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public User getPlanner() {
		return planner;
	}

	public void setPlanner(User planner) {
		this.planner = planner;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
}
