package com.revature.test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.dao.UserDAO;
import com.revature.exception.ERSexception;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

import org.mockito.InjectMocks;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	private static final String uName = "rchoy42";
	private static final String pWord = "pass1";
	private static final Integer id = 1;
	private static User u = new User();
	
	@Mock
	private static UserDAO daoMock;

	@InjectMocks
	private static UserService us = new UserServiceImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		u.setUserName(uName);
		u.setPassword(pWord);
	}
	
	@Test
	public void loginCorrect() throws ERSexception{
		//login
		when(daoMock.login(uName, pWord)).thenReturn(u);
		assertNotNull(us.login(uName, pWord));
	}
	
	@Test
	public void loginWrong() throws ERSexception{
		//login
		
		assertNull(us.login(uName, "sdfsdfsdfsdf"));
	}
	
	//find by id
	@Test
	public void findbyIdRight() {
		when(daoMock.findById(id)).thenReturn(u);
		assertNotNull(us.findById(id));
	}
	@Test
	public void findbyIdWrong() {
		
		assertNull(us.findById(0));
	}
	
	
	//update
	@Test
	public void updateTestRight() throws ERSexception{
		when(daoMock.updateProfile(u)).thenReturn(true);
		u.setUserName("bigNoodle");
		u.setPassword("BIIIGWOROD");
		u.setEmail("test@gmail.com");
		u.setUserId(1);
		u.setFirstName("aaaaaa");
		u.setLastName("bbbbbbbbbb");
		u.setRoleId(2);
		
		
		assertNotNull(us.updateProfile(u));
	}
	
	
	@Test(expected = ERSexception.class)
	public void updateTestWrong() throws ERSexception{
//		doNothing().when(daoMock).updateProfile(any(User.class));
//		us.updateProfile(new User());
//		verify(daoMock,times(1)).updateProfile(any(User.class));
		//enter nothing

		assertNull(us.updateProfile(new User()));
	}
	
	@Test
	public void getEmpList() {
		List<User> uList = new ArrayList<>();
		
		when(daoMock.viewAllEmployees()).thenReturn(uList);
		
		assertNotNull(us.viewAllEmployees());
	}
	
	



}
