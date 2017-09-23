package com.emgu.JacksDayRepo.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.emgu.JacksDayRepo.model.Activity;
import com.emgu.JacksDayRepo.model.ActivityRowMapper;
import com.mysql.jdbc.Driver;

public class DatabaseConnection {
	
    private static final String URL = "jdbc:mysql://mn19.webd.pl/krguznic_JacksDay";
    private static final String USERNAME = "krguznic_JacksDa";
    private static final String PASSWORD = "$nufk!n";
    
    private JdbcTemplate jdbcTemplate;
    
    public DatabaseConnection(){
    	createDataSource().ifPresent(dataSource -> {
    		jdbcTemplate = new JdbcTemplate(dataSource);
    		});
    }

    private Optional<SimpleDriverDataSource> createDataSource() {
        try {
            return Optional.of(new SimpleDriverDataSource(new Driver(), URL, USERNAME, PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

	public List<Activity> getAll() {
        String sqlSelect = "SELECT * FROM activity";
        return jdbcTemplate.query(sqlSelect, new ActivityRowMapper());

	}
	
	public List<Activity> getActivitySince(long time){
        String sqlSelect = "SELECT * FROM activity where time <= " + time;
        return jdbcTemplate.query(sqlSelect, new ActivityRowMapper());
	}

    public void save(Activity activity){
            String sqlInsert = "INSERT INTO activity "
                    + "(`time`, `type`, `details`, `icon`)"
                    + " VALUES (?, ?, ?, ?)";

            jdbcTemplate.update(sqlInsert,
                    activity.getDateAndTime(),
                    activity.getType(),
                    activity.getDetails());
    }
}
