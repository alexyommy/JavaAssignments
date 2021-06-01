package com.alexyom.license.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="licenses")
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer number;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date exirationDate;
	private String state;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	public License() {
		
	}
	public String getNumberAsString() {
		int numZeros = 7 - String.valueOf(this.number).length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numZeros; i++)
			sb.append('0');
		return String.format("%s%d", sb, this.number);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Date getExirationDate() {
		return exirationDate;
	}
	public void setExirationDate(Date exirationDate) {
		this.exirationDate = exirationDate;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getExpirationDateFormatted() {
		SimpleDateFormat fm = new SimpleDateFormat("MM/dd/yyyy");
		return fm.format(this.exirationDate);
	}
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PostPersist
	protected void onupdated() {
		this.updatedAt = new Date();
	
	}

}