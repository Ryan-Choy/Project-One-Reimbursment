package com.revature.exception;

import java.math.BigDecimal;

public class ERSvalidations {
	
	/*TODO: validate user (user name[50], password[50], first and last name[100], email[150])
	 * Reimbursement (amount, description[250], type id [int])
	*/
	public static boolean isValidUserName(String username) {
		if (username != null && username.matches("\\w{1,50}")) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean isValidPassword(String pass) {
		// [^\s] stands for no whitespace character, prevents spaces from being used
		if (pass != null && pass.matches("\\w{8,50}")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidEmail(String email) {
		String emailregex = "^(?=.{1,150}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		// #$%&'*+-/=? not allowed

		if (email != null && email.matches(emailregex)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidName(String name) {
		if (name != null && name.matches("[a-zA-Z]{1,50}")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidAmount(BigDecimal amount) {
		if (amount.compareTo(new BigDecimal(0)) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidId(Integer id) {
		if (id != null && id >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidDescription(String description) {
		if(description != null && description.matches(".{1,250}")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
