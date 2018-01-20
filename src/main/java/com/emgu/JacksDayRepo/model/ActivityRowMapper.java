package com.emgu.JacksDayRepo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ActivityRowMapper implements RowMapper{
    @Override
    public Activity mapRow(ResultSet result, int rowNum) throws SQLException {
        Activity activity = new Activity();
        activity.setId(result.getInt("id"));
        activity.setDateAndTime(result.getLong("time"));
        activity.setType(result.getString("type"));
        activity.setDetails(result.getString("details"));
        return activity;
    }
}
