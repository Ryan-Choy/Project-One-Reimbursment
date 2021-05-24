package com.revature.models;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Reimbursement {
	private Integer reimbId;
	private BigDecimal amount;
	private Timestamp dateSubmitted;
	private Timestamp dateResolved;
	private String description;

	
	//user id
	private Integer author;
	
	//manager id
	private Integer resolver;
	private Integer statusId;
	private Integer typeId;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(Integer reimbId, BigDecimal amount, Timestamp dateSubmitted, Timestamp dateResolved,
			String description, Integer author, Integer resolver, Integer statusId, Integer typeId) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	public Integer getReimbId() {
		return reimbId;
	}
	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Timestamp getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(Timestamp dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public Timestamp getDateResolved() {
		return dateResolved;
	}
	public void setDateResolved(Timestamp dateResolved) {
		this.dateResolved = dateResolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAuthor() {
		return author;
	}
	public void setAuthor(Integer author) {
		this.author = author;
	}
	public Integer getResolver() {
		return resolver;
	}
	public void setResolver(Integer resolver) {
		this.resolver = resolver;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	

}
	