package com.revature.repositories;

import com.revature.models.AbstractReimbursement;
import com.revature.models.AbstractUser;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {

	/**
	 * Should retrieve a Reimbursement from the DB with the corresponding id or an
	 * empty optional if there is no match.
	 */
	public void insertrmEmployee(Reimbursement newEmployee) {

		try (Connection conn = ConnectionFactory.getConnection()) {

String sql = "INSERT INTO ers_reimbursement(reimb_amout, reimb_submitted,"
		+ "  reimb_description,reimb_author,"
		+ "reimb_status_id,reimb_type_id) VALUES (?, now(), ?, ?, ?, ?); ";
            
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, newEmployee.getamount());
			ps.setString(2, newEmployee.getDescription());
			ps.setInt(3, newEmployee.getAuthor());
			ps.setInt(4, newEmployee.getstatusid());
			ps.setInt(5, newEmployee.getTypeid());
			ps.executeUpdate();

		//	System.out.println("Employee " + newEmployee.getUsername() + " created. Welcome Reimbursement!");

		} catch (SQLException e) {
			System.out.println("Add employee failed! :(");
			e.printStackTrace();
		}

	}
	
	
	public List<Reimbursement> getById(int id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
		
			ResultSet rs = ps.executeQuery();
			//AbstractReimbursement resultEmployee = new AbstractReimbursement();
			List<Reimbursement> resultEmployee = new ArrayList<>();
			while (rs.next()) {

				Reimbursement r = new Reimbursement(

		rs.getInt("reimb_id"), rs.getInt("reimb_amout"),
		new Date(rs.getTimestamp("reimb_submitted").getTime()),
		new Date(rs.getTimestamp("reimb_resolved").getTime()), rs.getString("reimb_description"),
		rs.getInt("reimb_receipt"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
		rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));

				
				resultEmployee.add(r);
			}
			
			return resultEmployee;
			
			//Optional<Reimbursement>rsid=Optional.of(r);
			
	
			
		} catch(SQLException e) {
			System.out.println("Gathering the employee! has failed.");
			e.printStackTrace();
		}
		return null;
	//	return Optional.empty();
		
	}

	/**
	 * Should retrieve a List of Reimbursements from the DB with the corresponding
	 * Status or an empty List if there are no matches.
	 */
	public List<Reimbursement> getByStatus(Status status) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			ResultSet rs = null;

			String sql = "SELECT * FROM ers_reimbursement where reimb_status_id = ? ;";

			PreparedStatement ps = conn.prepareStatement(sql);
			int nst = 0;
			if(status.equals("PENDING")) {
				nst=0;
			}
			System.out.println(nst);
			ps.setInt(1,nst);
			rs = ps.executeQuery();
			List<Reimbursement> employeeList = new ArrayList<>();
			

			while (rs.next()) {

				Reimbursement r = new Reimbursement(

			rs.getInt("reimb_id"), 
			rs.getInt("reimb_amout"),
			//new Date(rs.getTimestamp("reimb_submitted").getTime()),
			rs.getDate("reimb_submitted"),
			//new Date(rs.getTimestamp("reimb_resolved").getTime()),
			rs.getDate("reimb_resolved"),
			rs.getString("reimb_description"),
			rs.getInt("reimb_receipt"), 
			rs.getInt("reimb_author"),
			rs.getInt("reimb_resolver"),
			rs.getInt("reimb_status_id"), 
			rs.getInt("reimb_type_id"));
				//int id, int amount, Date submitted, Date resolved, String description, int receipt, int author,
				//int resolver, int statusid, int typeid
				employeeList.add(r);

			}

			return employeeList;

		} catch (SQLException e) {
			System.out.println("Something went wrong selecting employees!");
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	/**
	 * <ul>
	 * <li>Should Update an existing Reimbursement record in the DB with the
	 * provided information.</li>
	 * <li>Should throw an exception if the update is unsuccessful.</li>
	 * <li>Should return a Reimbursement object with updated information.</li>
	 * </ul>
	 */
	public Reimbursement update(Reimbursement unprocessedReimbursement) {
		try(Connection conn  = ConnectionFactory.getConnection()) {
			/*String sql = "UPDATE ers_reimbursement SET reimb_amout= ?, "
					+ " reimb_description = ?,reimb_receipt = ?,reimb_author = ?,reimb_resolver = ?,reimb_status_id = ?,reimb_type_id =? WHERE reimb_id  = ?";*/
			
			String sql = "UPDATE ers_reimbursement SET reimb_status_id = ? WHERE reimb_id  = ?";
			
			PreparedStatement rs = conn.prepareStatement(sql);
			rs.setInt(1,unprocessedReimbursement.getstatusid());
			rs.setInt(2,unprocessedReimbursement.getId());
			
			/*rs.setInt(1, unprocessedReimbursement.getamount());
			//rs.setInt(2,(java.sql.Timestamp) unprocessedReimbursement.getsubmitted());
			//rs.setInt(3,(java.sql.Timestamp) unprocessedReimbursement.getresolved());
			rs.setString(2,unprocessedReimbursement.getDescription());
			rs.setInt(3,unprocessedReimbursement.getreceipt());
			rs.setInt(4,unprocessedReimbursement.getAuthor());
			rs.setInt(5,unprocessedReimbursement.getResolver());
			rs.setInt(6,unprocessedReimbursement.getstatusid());
			rs.setInt(7,unprocessedReimbursement.getTypeid());
			rs.setInt(8,unprocessedReimbursement.getId());*/
			
			rs.executeUpdate();
			System.out.println("We updated");
			
		} catch(SQLException e) {
			System.out.println("Updating has failed.");
			e.printStackTrace();
		}
		return null;
	}

	// meena
	public List<Reimbursement> getAllEmployees() {

		try (Connection conn = ConnectionFactory.getConnection()) {

			ResultSet rs = null;

			String sql = "SELECT * FROM ers_reimbursement where reimb_id=? and reimb_amout >?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,2);
			ps.setInt(2,200);

			rs = ps.executeQuery();
			List<Reimbursement> employeeList = new ArrayList<>();
			

			while (rs.next()) {

				Reimbursement r = new Reimbursement(

						rs.getInt("reimb_id"), rs.getInt("reimb_amout"),
						new Date(rs.getTimestamp("reimb_submitted").getTime()),
						new Date(rs.getTimestamp("reimb_resolved").getTime()), rs.getString("reimb_description"),
						rs.getInt("reimb_receipt"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));

				employeeList.add(r);

			}

			return employeeList;

		} catch (SQLException e) {
			System.out.println("Something went wrong selecting employees!");
			e.printStackTrace();
		}

		return null;

	}
	
	
	
	public List<Reimbursement> getAllEmployeesall() {

		try (Connection conn = ConnectionFactory.getConnection()) {

			ResultSet rs = null;

			String sql = "SELECT * FROM ers_reimbursement;";

			Statement statement = conn.createStatement();

			rs = statement.executeQuery(sql);
			
			List<Reimbursement> employeeList = new ArrayList<>();
			

			while (rs.next()) {

				Reimbursement r = new Reimbursement(

						rs.getInt("reimb_id"), 
						rs.getInt("reimb_amout"),
						rs.getDate("reimb_submitted"),
						rs.getDate("reimb_resolved"),
						//new Date(rs.getTimestamp("reimb_submitted").getTime()),
						//new Date(rs.getTimestamp("reimb_resolved").getTime()), 
						rs.getString("reimb_description"),
						rs.getInt("reimb_receipt"), 
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"));

				employeeList.add(r);

			}

			return employeeList;

		} catch (SQLException e) {
			System.out.println("Something went wrong selecting employees!");
			e.printStackTrace();
		}

		return null;

}
}
