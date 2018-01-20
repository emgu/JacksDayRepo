package com.emgu.JacksDayRepo.ui;

import java.util.List;

import com.emgu.JacksDayRepo.data.DatabaseConnection;
import com.emgu.JacksDayRepo.model.Activity;

public class ActivityDao {

	private static DatabaseConnection connection;
	
	public ActivityDao() {
		connection = new DatabaseConnection();
	}
	
	public List<Activity> getAllActivities() {
		return connection.getAll();
	}
	
	public List<Activity> getSince(long time){
		return connection.getSince(time);
	}
	
	public List<Activity> getLast(int number){
		return connection.getLast(number);
	}
}
