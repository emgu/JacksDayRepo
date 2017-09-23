package com.emgu.JacksDayRepo.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "activity") 

public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private long dateAndTime;
	private String type;
	private String details;
	
	public Activity() {}
	
	public Activity(int id, long dateAndTime, String type, String details) {
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.type = type;
		this.details = details;
	}
	
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public long getDateAndTime() {
		return dateAndTime;
	}
	@XmlElement
	public void setDateAndTime(long dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getType() {
		return type;
	}
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	public String getDetails() {
		return details;
	}
	@XmlElement
	public void setDetails(String details) {
		this.details = details;
	}
}
