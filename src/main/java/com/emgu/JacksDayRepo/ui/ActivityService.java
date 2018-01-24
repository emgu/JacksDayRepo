package com.emgu.JacksDayRepo.ui;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.emgu.JacksDayRepo.model.Activity;

@Path("/ActivityService")
public class ActivityService {
	   ActivityDao activityDao = new ActivityDao();

	   @GET 
	   @Path("/activities")
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<Activity> getActivities(){ 
	      return activityDao.getAllActivities();
	   }  
	   
	   @GET 
	   @Path("/activities/number = {number}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<Activity> getLast(@PathParam("number") int number){ 
	      return activityDao.getLast(number);
	   }
}

// /JacksDayRepo/rest/ActivityService/activities