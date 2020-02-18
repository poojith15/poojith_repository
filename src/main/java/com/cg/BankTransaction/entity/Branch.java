package com.cg.BankTransaction.entity;

public class Branch {
	private String branchId;
	private String branchName;
	private String branchIFSC;
	private String branchAddress;
	
	public Branch() {
		
	}
	public Branch(String branchId, String branchName, String branchIFSC, String branchAddress) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchIFSC = branchIFSC;
		this.branchAddress = branchAddress;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchIFSC() {
		return branchIFSC;
	}
	public void setBranchIFSC(String branchIFSC) {
		this.branchIFSC = branchIFSC;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	@Override
	public String toString() {
		return "Branch Id:"+branchId+"Branch Name:"+branchName
				+"Branch IFSC:"+branchIFSC+"Branch Address:"+branchAddress;
	}
	

}
