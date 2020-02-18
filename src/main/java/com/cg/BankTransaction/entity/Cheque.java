package com.cg.BankTransaction.entity;

import java.time.LocalDate;

/**
 * 
 * @author poojith
 *This class is an entity class which contains cheque details.
 */
public class Cheque {
	private String chequeId;
	private String chequeNum;
	private String chequeAccountNo;
	private String chequeBankName;
	private String chequeIFSC;
	private LocalDate chequeIssueDate;
	private String chequeStatus;
	
	public Cheque() {
		
	}
	
	public Cheque(String chequeAccountNo, LocalDate chequeIssueDate) {
		super();
		this.chequeAccountNo = chequeAccountNo;
		this.chequeIssueDate = chequeIssueDate;
	}

	public Cheque(String chequeId, String chequeNum, String chequeAccountNo, String chequeBankName, String chequeIFSC,
			LocalDate chequeIssueDate, String chequeStatus) {
		super();
		this.chequeId = chequeId;
		this.chequeNum = chequeNum;
		this.chequeAccountNo = chequeAccountNo;
		this.chequeBankName = chequeBankName;
		this.chequeIFSC = chequeIFSC;
		this.chequeIssueDate = chequeIssueDate;
		this.chequeStatus = chequeStatus;
	}
	public String getChequeId() {
		return chequeId;
	}
	public void setChequeId(String chequeId) {
		this.chequeId = chequeId;
	}
	public String getChequeNum() {
		return chequeNum;
	}
	public void setChequeNum(String chequeNum) {
		this.chequeNum = chequeNum;
	}
	public String getChequeAccountNo() {
		return chequeAccountNo;
	}
	public void setChequeAccountNo(String chequeAccountNo) {
		this.chequeAccountNo = chequeAccountNo;
	}
	public String getChequeBankName() {
		return chequeBankName;
	}
	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}
	public String getChequeIFSC() {
		return chequeIFSC;
	}
	public void setChequeIFSC(String chequeIFSC) {
		this.chequeIFSC = chequeIFSC;
	}
	public LocalDate getChequeIssueDate() {
		return chequeIssueDate;
	}
	public void setChequeIssueDate(LocalDate chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}
	public String getChequeStatus() {
		return chequeStatus;
	}
	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}
	

}
