package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserDAO {

	User login(String userName, String password);

	User findById(Integer userid);
	// employees
	boolean updateProfile(User u);

	// just in case
	// User viewProfile();
	// managers
	List<User> viewAllEmployees();
}
