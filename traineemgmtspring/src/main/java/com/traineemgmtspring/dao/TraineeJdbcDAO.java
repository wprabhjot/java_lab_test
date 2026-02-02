package com.traineemgmtspring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.traineemgmtspring.entities.Trainee;

@Repository
@ConditionalOnProperty(name = "trainee.dao.type", havingValue = "jdbc")
public class TraineeJdbcDAO implements TraineeDAO{

	private JdbcTemplate jdbcTemplate;
	
	public TraineeJdbcDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into trainee(trainee_name, branch, percentage) values(?,?,?)",  new Object[] {trainee.getTrainee_name(), trainee.getBranch(), trainee.getPercentage()});
	}

	@Override
	public Trainee findTraineeById(int traineeId) {
		// TODO Auto-generated method stub
		Trainee trainee = jdbcTemplate.queryForObject("select * from trainee where trainee_id=?", new RowMapper<Trainee>() {

			@Override
			public Trainee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Trainee trainee = new Trainee();
	            trainee.setId(rs.getInt("trainee_id"));
	            trainee.setTrainee_name(rs.getString("trainee_name"));
	            trainee.setBranch(rs.getString("branch"));
	            trainee.setPercentage(rs.getDouble("percentage"));
	            return trainee;
			}
		}, traineeId);
		
		return trainee; 
	}

}
