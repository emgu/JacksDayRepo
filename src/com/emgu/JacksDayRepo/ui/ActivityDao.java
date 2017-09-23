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
}
