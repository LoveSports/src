package edu.neu.lovesports.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

import edu.neu.lovesports.entity.User;

public class UserDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LoveSports");
	EntityManager em = factory.createEntityManager();
	
	
	public UserDAO() {	}

	// create User
	public User createUser(User user){
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}
	
	// readAllUsers
	public List<User> readAllUsers()
	{
		Query query = em.createQuery("select user from User user");
		return (List<User>) query.getResultList();
	}
	
	// readUserByUsername
	public User readUserByUsername(String username) {
		return em.find(User.class, username);
	}
	
	// updateUser
	public User updateUser(User user)
	{
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		return user;
	}
	
	// deleteUser
	public void deleteUser(String username) {
		em.getTransaction().begin();
		User user = em.find(User.class, username);
		em.remove(user);
		em.getTransaction().commit();
	}
	
//	public void setToken(String username, String token){
////		ConnectionDAO conn = new ConnectionDAO();
////		conn.getConnection();
//		String sql = "UPDATE user SET token = ? WHERE username = ?;";
//		try {
//			Connection conn = ds.getConnection();
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, token);
//			statement.setString(2, username);
//			statement.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		finally {
////			conn.closeConnection();
////			}
//	}
//	
//	public String getToken(String username){
////		ConnectionDAO conn = new ConnectionDAO();
////		conn.getConnection();
//		String token = null;
//		String sql = "SELECT token FROM user WHERE username = ?;";
//		try {
//			Connection conn = ds.getConnection();
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, username);
//			ResultSet result = statement.executeQuery();
//			result.next();
//			token = result.getString("token");			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		finally {
////			conn.closeConnection();
////			}
//		return token;
//	}
	
	public static void main(String[] arg)
	{
		UserDAO dao = new UserDAO();
		User user = new User("shen", "mima", "Hualong", "Shen", "email@email");
		dao.createUser(user);
	}
}
