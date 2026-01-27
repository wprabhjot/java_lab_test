package com.traineemanagement.dao;

import java.sql.*;


import com.traineemanagement.dto.Trainee;
import com.traineemanagement.exceptions.DaoException;
import com.traineemanagement.util.ConnectionFactory;


public class TraineeDaoJdbcImpl implements TraineeDao {

	@Override
	public void addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		String sql = "insert into trainee(trainee_name, branch, percentage) values(?,?,?)";
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			psmt.setString(1, trainee.getTrainee_name());
			psmt.setString(2, trainee.getBranch());
			psmt.setDouble(3, trainee.getPercentage());

			psmt.executeUpdate();
			try (ResultSet rs = psmt.getGeneratedKeys()) {
				if (rs.next()) {
					trainee.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				// TODO: handle exception
				throw new DaoException("Failed to add book", e);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			throw new DaoException("Record couldn't be added. Please try again.", e);
		}
	}

	@Override
	public Trainee findTraineeById(int traineeId) {
		// TODO Auto-generated method stub
		Trainee trainee = null;
		String sql = "select * from trainee where trainee_id=?";
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement psmt = connection.prepareStatement(sql);) {
			psmt.setInt(1, traineeId);

			try (ResultSet rs = psmt.executeQuery()) {
				if (rs.next()) {
					trainee = new Trainee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
				} else {
					throw new DaoException("No trainee found with id" + traineeId, null);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DaoException("Record couldn't be found. Please try again.", e);
		}
		return trainee;
	}

}
