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

//	private Connection connection;
//	
//	public BookDaoJdbcImpl() {
//		connection = ConnectionFactory.getConnection();
//	}

	
	
	
//	@Override
//	public List<Trainee> getAllBooks() throws DaoException {
//		List<Trainee> books = new ArrayList<>();
//		String sql = "select * from books";
//		try (Connection connection = ConnectionFactory.getConnection();
//				PreparedStatement psmt = connection.prepareStatement(sql);
//				ResultSet rs = psmt.executeQuery()) {
//			while (rs.next()) {
//				books.add(new Trainee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			throw new DaoException("Record couldn't be fetched. Please try again.", e);
//		}
//		return books;
//	}
//
//	@Override
//	public Trainee addBook(Trainee book) throws DaoException {
//		String sql = "insert into books(isbn, title, author, price) values(?,?,?,?)";
//		try (Connection connection = ConnectionFactory.getConnection();
//				PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//			psmt.setString(1, book.getIsbn());
//			psmt.setString(2, book.getTitle());
//			psmt.setString(3, book.getAuthor());
//			psmt.setDouble(4, book.getPrice());
//
//			psmt.executeUpdate();
//			try (ResultSet rs = psmt.getGeneratedKeys()) {
//				if (rs.next()) {
//					book.setId(rs.getInt(1));
//				}
//			} catch (SQLException e) {
//				// TODO: handle exception
//				throw new DaoException("Failed to add book", e);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			throw new DaoException("Record couldn't be added. Please try again.", e);
//		}
//		return book;
//	}
//
//	@Override
//	public void deleteBook(int id) throws DaoException {
//		// TODO Auto-generated method stub
//		String sql = "delete from books WHERE id=?";
//		try (Connection connection = ConnectionFactory.getConnection();
//				PreparedStatement psmt = connection.prepareStatement(sql)) {
//			psmt.setInt(1, id);
//			int rowsAffected = psmt.executeUpdate();
//			if (rowsAffected == 0) {
//				throw new DaoException("No book found with id" + id, null);
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			throw new DaoException("Record couldn't be deleted. Please try again.", e);
//		}
//	}
//
//	@Override
//	public void updateBook(int id, Trainee book) throws DaoException {
//		// TODO Auto-generated method stub
//		String sql = "update books SET isbn=?, title=?, author=?, price=? where id=?";
//		try (Connection connection = ConnectionFactory.getConnection();
//				PreparedStatement psmt = connection.prepareStatement(sql)) {
//			psmt.setString(1, book.getIsbn());
//			psmt.setString(2, book.getTitle());
//			psmt.setString(3, book.getAuthor());
//			psmt.setDouble(4, book.getPrice());
//			psmt.setInt(5, id);
//			int rowsAffected = psmt.executeUpdate();
//			if (rowsAffected == 0) {
//				throw new DaoException("No book found with id" + id, null);
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			throw new DaoException("Record couldn't be updated. Please try again.", e);
//		}
//	}
//
//	@Override
//	public Trainee getBookById(int id) throws DaoException {
//		// TODO Auto-generated method stub
//		Trainee book = null;
//		String sql = "select * from books where id=?";
//		try (Connection connection = ConnectionFactory.getConnection();
//				PreparedStatement psmt = connection.prepareStatement(sql);) {
//			psmt.setInt(1, id);
//
//			try (ResultSet rs = psmt.executeQuery()) {
//				if (rs.next()) {
//					book = new Trainee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
//				} else {
//					throw new DaoException("No book found with id" + id, null);
//				}
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			throw new DaoException("Record couldn't be found. Please try again.", e);
//		}
//		return book;
//	}

}
