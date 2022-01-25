package com.revature.repositories;

import com.revature.models.AbstractUser;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO {

	/**
	 * Should retrieve a User from the DB with the corresponding username or an
	 * empty optional if there is no match.
	 */
	public Optional<User> getByUsername(String username) {
		return Optional.empty();
	}

	/**
	 * <ul>
	 * <li>Should Insert a new User record into the DB with the provided
	 * information.</li>
	 * <li>Should throw an exception if the creation is unsuccessful.</li>
	 * <li>Should return a User object with an updated ID.</li>
	 * </ul>
	 *
	 * Note: The userToBeRegistered will have an id=0, and username and password
	 * will not be null. Additional fields may be null.
	 */
	public User create(User userToBeRegistered) {
		return userToBeRegistered;
	}
	/*public void insert(User newEmployee) {

		try (Connection conn = ConnectionFactory.getConnection()) {

			String sql = "INSERT INTO ers_users(ers_username, ers_password, user_email,user_role_id) VALUES (?, ?, ?, ?); ";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, newEmployee.getUsername());
			ps.setString(2, newEmployee.getPassword());
		    ps.setString(3, newEmployee.getemail());
			ps.setInt(4, newEmployee.getrole_Id());

			ps.executeUpdate();

			System.out.println("Employee " + newEmployee.getUsername() + " created. Welcome Reimbursement!");

		} catch (SQLException e) {
			System.out.println("Add employee failed! :(");
			e.printStackTrace();
		}

	}*/

public List<User> getEmployees() { 
		
		try(Connection conn = ConnectionFactory.getConnection()){ 
			
			ResultSet rs = null;
			
			String sql = "SELECT * FROM ers_users;";
			Statement statement = conn.createStatement();
			
			
			rs = statement.executeQuery(sql);
			List<User> employeeList = new ArrayList<>();
			while(rs.next()) {
				
				
				User e = new User(
	rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
	rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"),
	rs.getInt("user_role_id"));
	
						employeeList.add(e);
		
			}
						
			
			return employeeList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting employees!");
			e.printStackTrace();
		}
		
		return null; 
		
	}

public User getEmployeeById(int users_id) {
	try(Connection conn = ConnectionFactory.getConnection()){
		String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, users_id);
		
		ResultSet rs = ps.executeQuery();

		AbstractUser resultEmployee = new AbstractUser();
		
		while(rs.next()) {
			User c = new User(
					rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
					rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"),
					rs.getInt("user_role_id"));
					
					
			
			resultEmployee = c;
		}
		
		return (User) resultEmployee;
	} catch(SQLException e) {
		System.out.println("Gathering the employee! has failed.");
		e.printStackTrace();
	}
	return null;
}
	public void insertEmployee(User newEmployee) {

		try (Connection conn = ConnectionFactory.getConnection()) {

String sql = "INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email,user_role_id) VALUES (?, ?, ?, ?, ?, ?); ";
            int nrole=11145;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newEmployee.getUsername());
			ps.setString(2, newEmployee.getPassword());
			ps.setString(3, newEmployee.getfirstname());
			ps.setString(4, newEmployee.getlastname());
			ps.setString(5, newEmployee.getemail());
			//ps.setInt(6, newEmployee.getrole_Id());
			ps.setInt(6, nrole);
			ps.executeUpdate();

			System.out.println("Employee " + newEmployee.getUsername() + " created. Welcome Reimbursement!");

		} catch (SQLException e) {
			System.out.println("Add employee failed! :(");
			e.printStackTrace();
		}

	}
	public User updateEmployee(User newEmployee) {
		try(Connection conn  = ConnectionFactory.getConnection()) {
			String sql = "UPDATE ers_users SET ers_username= ?, ers_password = ?, user_first_name = ?,"
					+ " user_last_name = ?,user_email = ?,user_role_id = ? WHERE ers_users_id  = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			int nrole=11145;
			
			ps.setString(1, newEmployee.getUsername());
			ps.setString(2, newEmployee.getPassword());
			ps.setString(3, newEmployee.getfirstname());
			ps.setString(4, newEmployee.getlastname());
			ps.setString(5, newEmployee.getemail());
			//ps.setInt(6, newEmployee.getrole_Id());
			ps.setInt(6, nrole);
			ps.setInt(7, newEmployee.getId());
			ps.executeUpdate();
			System.out.println("We updated");
		/*	String sqlCheck = "SELECT * FROM ers_users WHERE ers_users_id = ?";
			//Statement s = conn.createStatement();
			//ResultSet rs = s.executeQuery(sqlCheck);
			PreparedStatement psc = conn.prepareStatement(sqlCheck);
			ps.setInt(1, newEmployee.getId());
			ResultSet rs = psc.executeQuery();
			while(rs.next()) {
			User Employee = new User(
					rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
					rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"),
					rs.getInt("user_role_id"));
					
			
			return Employee;
			}*/
			} catch(SQLException e) {
				System.out.println("Updating has failed.");
				e.printStackTrace();
			}
		return null;
	}

	
	public boolean deleteEmployee(int id) {
		try(Connection conn  = ConnectionFactory.getConnection()) {
			String sql = "delete from ers_users WHERE ers_users_id  = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setInt(1, id);
			
			ps.executeUpdate();
			System.out.println("Delete the employee!!");
			return true;
			
			} catch(SQLException e) {
				System.out.println("delete has failed.");
				e.printStackTrace();
				return false;
			}
	}

	@SuppressWarnings("unchecked")
	public List<User> getUser(String username, String password) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?"
					+ " and ers_password = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			
			ResultSet rs = ps.executeQuery();

			List<User> resultEmployee = new ArrayList<>();
			
			while(rs.next()) {
				User c = new User(
						rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"),
						rs.getInt("user_role_id"));
						
						
				
				resultEmployee.add(c);
			}
			
			return resultEmployee;
		} catch(SQLException e) {
			System.out.println("Gathering the employee! has failed.");
			e.printStackTrace();
		}

		return null;
	}

}
