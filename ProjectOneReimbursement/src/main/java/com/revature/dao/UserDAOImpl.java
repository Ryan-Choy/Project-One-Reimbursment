package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.DatabaseConnect;

public class UserDAOImpl implements UserDAO {

	@Override
	public User login(String userName, String password) {
		User log = new User();
		String sql = "SELECT * FROM ers.ers_users WHERE (ers_username,ers_password) = (?,?)";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);
			
			ps.setString(1, userName);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				log.setUserId(rs.getInt("ers_users_id"));
				log.setUserName(userName);
				log.setPassword(password);
				log.setFirstName(rs.getString("user_first_name"));
				log.setLastName(rs.getString("user_last_name"));
				log.setEmail(rs.getString("user_email"));
				log.setRoleId(rs.getInt("ers_user_role_id"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return log;
	}

	@Override
	public boolean updateProfile(User u) {
		User up = new User();
		
		String sql = "UPDATE ers.ers_users SET (ers_username, ers_password,user_email) = (?,?,?) WHERE ers_users_id = ?";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);
			
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setInt(4, u.getUserId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<User> viewAllEmployees() {
		List<User> empList = new ArrayList<>();
		String sql = "SELECT * FROM ers.ers_users WHERE ers_user_role_id = 1 ORDER BY ers_users_id";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User emp = new User();
				emp.setUserId(rs.getInt("ers_users_id"));
				emp.setUserName(rs.getString("ers_username"));
				emp.setRoleId(rs.getInt("ers_user_role_id"));
				emp.setPassword(rs.getString("ers_password"));
				emp.setFirstName(rs.getString("user_first_name"));
				emp.setLastName(rs.getString("user_last_name"));
				emp.setEmail(rs.getString("user_email"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empList;
	}

	@Override
	public User findById(Integer userid) {
		User log = new User();
		String sql = "SELECT * FROM ers.ers_users WHERE ers_users_id = ?";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);
			
			ps.setInt(1, userid);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				log.setUserId(rs.getInt("ers_users_id"));
				log.setUserName(rs.getString("ers_username"));
				log.setPassword(rs.getString("ers_password"));
				log.setFirstName(rs.getString("user_first_name"));
				log.setLastName(rs.getString("user_last_name"));
				log.setEmail(rs.getString("user_email"));
				log.setRoleId(rs.getInt("ers_user_role_id"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return log;
	}

	

}
