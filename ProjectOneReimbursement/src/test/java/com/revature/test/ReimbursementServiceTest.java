package com.revature.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.UserDAO;
import com.revature.exception.ERSexception;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import com.revature.services.ReimbursementServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ReimbursementServiceTest {
	private static final Integer id = 1;
	private static Reimbursement r = new Reimbursement();
	private static final int update = 2;
	private static List<Reimbursement> rList = new ArrayList<>();
	
	@Mock
	private static ReimbursementDAO daoMock;
	
	@InjectMocks 
	private static ReimbursementService rs = new ReimbursementServiceImpl();
	

	@Test
	public void viewReimbyId() {
		// employee: view all resolved reimbursement requests
		//same for pending reimbursement
		when(daoMock.viewReimbursement(id)).thenReturn(rList);
		assertNotNull(rs.viewReimbursement(id));
	}
	
	@Test
	public void viewReim() {

		when(daoMock.viewReimbursement()).thenReturn(rList);
		assertNotNull(rs.viewReimbursement());
	}
	
	@Test
	public void viewPendReimbyId() {
	
		when(daoMock.viewPendingReimbursement(id)).thenReturn(rList);
		assertNotNull(rs.viewPendingReimbursement(id));
	}
	
	@Test
	public void viewPendReim() {
	
		when(daoMock.viewPendingReimbursement()).thenReturn(rList);
		assertNotNull(rs.viewPendingReimbursement());
	}
	
	@Test
	public void submitReimbursement () throws ERSexception {
		r.setAmount(new BigDecimal(99999));
		assertNull(rs.submitReinRequest(r));
	}
	
	@Test
	public void updateReimbursementRight() throws ERSexception{
		when(daoMock.updateReimbursementRequest(update, id, id)).thenReturn(true);
		assertNotNull(rs.updateReimbursementRequest(update, id,id));
	}
	
	@Test
	public void viewReimbyEmp() {
		// employee: view all resolved reimbursement requests
		//same for pending reimbursement
		when(daoMock.viewReimbursementEmp(id)).thenReturn(rList);
		assertNotNull(rs.viewReimbursementEmp(id));
	}

}
