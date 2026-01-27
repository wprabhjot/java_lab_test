package com.traineemanagement.dao;

import com.traineemanagement.dto.Trainee;
import com.traineemanagement.exceptions.DaoException;
import com.traineemanagement.util.EMFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class TraineeDaoJpaImpl implements TraineeDao {

	@Override
	public void addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		EntityManager em = EMFactory.getEntityManager();
      EntityTransaction tx = em.getTransaction();

      try {
          tx.begin();
          em.persist(trainee);
          tx.commit();
      } catch (PersistenceException e) {
      	if (tx.isActive()) tx.rollback();
          throw new DaoException("Failed to add trainee: " + trainee.getTrainee_name(), e);
      } finally {
          em.close();
      }
	}

	@Override
	public Trainee findTraineeById(int traineeId) {
		// TODO Auto-generated method stub
		EntityManager em = EMFactory.getEntityManager();
		try {
			Trainee trainee = em.find(Trainee.class, traineeId);
			if(trainee==null) {
				throw new DaoException("No trainee found with id " + traineeId, null);
			}
			return trainee;
		} catch (PersistenceException e) {
			// TODO: handle exception
			 throw new DaoException("Failed to fetch trainee with id " + traineeId, e);
		} finally {
			em.close();
		}
	}

   
//	@Override
//	public List<Trainee> getAllBooks() {
//		// TODO Auto-generated method stub
//		EntityManager em = EMFactory.getEntityManager();
//		try {
//			List<Trainee> books = em.createQuery("select b from Book b", Trainee.class).getResultList();
//			return books;
//		} catch (PersistenceException e) {
//			// TODO: handle exception
//			throw new DaoException("Failed to fetch all books", e);
//		}
//	}
//	
//	@Override
//    public Trainee addBook(Trainee book){
//        EntityManager em = EMFactory.getEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        try {
//            tx.begin();
//            em.persist(book);
//            tx.commit();
//            return book;
//        } catch (PersistenceException e) {
//        	if (tx.isActive()) tx.rollback();
//            throw new DaoException("Failed to add book: " + book.getTitle(), e);
//        } finally {
//            em.close();
//        }
//    }
//
//
//	@Override
//	public void deleteBook(int id){
//		// TODO Auto-generated method stub
//		EntityManager em = EMFactory.getEntityManager();
//        EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			Trainee book = em.find(Trainee.class, id);
//			if(book==null) {
//				throw new DaoException("No book found with id " + id, null);	
//			}
//			em.remove(book);
//			tx.commit();
//		} catch (PersistenceException e) {
//			// TODO: handle exception
//			if (tx.isActive()) tx.rollback();
//			throw new DaoException("Failed to delete book with id " + id, e);
//		} finally {
//			em.close();
//		}
//	}
//
//	@Override
//	public void updateBook(int id, Trainee book) throws DaoException {
//		// TODO Auto-generated method stub
//		EntityManager em = EMFactory.getEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try {
//			tx.begin();
//			Trainee existingBook = em.find(Trainee.class, id);
//			if(existingBook==null) {
//				throw new DaoException("No book found with id " + id, null);
//			}
//			existingBook.setIsbn(book.getIsbn());
//            existingBook.setTitle(book.getTitle());
//            existingBook.setAuthor(book.getAuthor());
//            existingBook.setPrice(book.getPrice());
//			em.merge(existingBook);
//			tx.commit();
//		} catch (PersistenceException e) {
//			// TODO: handle exception
//			if (tx.isActive()) tx.rollback();
//			throw new DaoException("Failed to update book with id " + id, e);
//		} finally {
//			em.close();
//		}
//	}
//
//	@Override
//	public Trainee getBookById(int id) throws DaoException {
//		// TODO Auto-generated method stub
//		EntityManager em = EMFactory.getEntityManager();
//		try {
//			Trainee book = em.find(Trainee.class, id);
//			if(book==null) {
//				throw new DaoException("No book found with id " + id, null);
//			}
//			return book;
//		} catch (PersistenceException e) {
//			// TODO: handle exception
//			 throw new DaoException("Failed to fetch book with id " + id, e);
//		} finally {
//			em.close();
//		}
//	}
}
