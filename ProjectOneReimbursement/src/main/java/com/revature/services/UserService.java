package com.revature.services;

import java.util.List;

import com.revature.exception.ERSexception;
import com.revature.models.Reimbursement;

import com.revature.models.User;

public interface UserService {
	
	User login(String userName, String password);
	
	User findById(Integer userid);
	
	//employees
	boolean updateProfile(User u) throws ERSexception;

	//just in case
	//User viewProfile();
	//managers
	List<User> viewAllEmployees();

}
