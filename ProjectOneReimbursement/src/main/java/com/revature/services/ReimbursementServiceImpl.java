package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.exception.ERSexception;
import com.revature.exception.ERSvalidations;
import com.revature.models.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {

	ReimbursementDAO rd = new ReimbursementDAOImpl();

	@Override
	public List<Reimbursement> viewReimbursement(Integer userId) {
		// employee: view all resolved reimbursement requests

		// TODO Auto-generated method stub
		return rd.viewReimbursement(userId);
	}

	@Override
	public List<Reimbursement> viewPendingReimbursement(Integer userId) {
		// employee: view their pending requests

		// TODO Auto-generated method stub
		return rd.viewPendingReimbursement(userId);
	}

	@Override
	public Reimbursement submitReinRequest(Reimbursement r) throws ERSexception {
		if(!ERSvalidations.isValidAmount(r.getAmount())) {
			throw new ERSexception("Entered amount: "+ r.getAmount()+" is invalid");
		}
		return rd.submitReinRequest(r);
	}

	@Override
	public List<Reimbursement> viewPendingReimbursement() {
		// manager: view all pending requests from all employees

		// TODO Auto-generated method stub
		return rd.viewPendingReimbursement();
	}

	@Override
	public List<Reimbursement> viewReimbursement() {
		// manager: view all resolved requests

		// TODO Auto-generated method stub
		return rd.viewReimbursement();
	}

	@Override
	public List<Reimbursement> viewReimbursementEmp(Integer userId) {
		// manager view requests from a single employee

		// TODO Auto-generated method stub
		return rd.viewReimbursementEmp(userId);
	}

	@Override
	public boolean updateReimbursementRequest(int update, Integer reimbId,Integer managId) {
		// TODO Auto-generated method stub
		return rd.updateReimbursementRequest(update, reimbId,managId);
	}

}
