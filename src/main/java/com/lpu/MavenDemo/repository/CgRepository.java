package com.lpu.MavenDemo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lpu.MavenDemo.entity.AccTransaction;
import com.lpu.MavenDemo.entity.AccountManagement;
import com.lpu.MavenDemo.entity.Address;
import com.lpu.MavenDemo.entity.Branch;
import com.lpu.MavenDemo.entity.Cheque;
import com.lpu.MavenDemo.entity.Customer;

/**
 * 
 * @author poojith This is a Repository class which contains data for all entity
 *         classes in a map.
 */

public class CgRepository {
	public static final int ZERO = 0;
	public static Map<String, AccountManagement> accList = new HashMap<>();
	public static List<AccTransaction> transList1 = new ArrayList<>();
	public static List<AccTransaction> transList2 = new ArrayList<>();
	public static List<AccTransaction> transList3 = new ArrayList<>();
	public static List<AccTransaction> transList4 = new ArrayList<>();
	public static Map<String, Cheque> cheq = new HashMap<>();

	static {
		/**
		 * ----BRANCH
		 * Repository-----------------------------------------------------------------------------------------------------------------------------------------------
		 * Branch(String ,String ,String ,String)
		 * Branch(branchId,branchName,branchIFSC,branchAddress)
		 */
		Branch branch1 = new Branch("br1001", "KONDAREDDY BURG", "PCNA0001001", "KURNOOL");
		Branch branch2 = new Branch("br1002", "TEKKALI", "PCNA0001002", "SRIKAKULAM");
		Branch branch3 = new Branch("br1003", "NARASARAO PET", "PCNA0001003", "GUNTUR");
		Branch branch4 = new Branch("br1004", "MR PALLI", "PCNA0001001", "TIRUPATHI");

		/**
		 * ----ADDRESS
		 * Repository----------------------------------------------------------------------------------------------------------------------------------------------
		 * Address(String ,String ,String ,String ,String ,String ,String ,Branch)
		 * Address(addressId,addressLine1,addressLine2,addressCity,addressState,addressCountry,addressZipcode,branch)
		 */
		Address add1 = new Address("H No.12/9", "2nd line", "Amaravathi Nagar", "KURNOOL", "ANDHRA PRADESH", "INDIA",
				"523110", branch1);
		Address add2 = new Address("H No.14/6", "3rd line", "Amar Nagar", "SRIKAKULAM", "ANDHRA PRADESH", "INDIA",
				"523101", branch2);
		Address add3 = new Address("H No.356/5", "1st line", "Jyothi market", "GUNTUR", "ANDHRA PRADESH", "INDIA",
				"510110", branch3);
		Address add4 = new Address("H No.23/1", "4th line", "Maruthi Nagar", "TIRUPATHI", "ANDHRA PRADESH", "INDIA",
				"532008", branch4);

		LocalDate date1 = LocalDate.of(1996, 1, 12);
		LocalDate date2 = LocalDate.of(1996, 2, 22);
		LocalDate date3 = LocalDate.of(1996, 6, 22);
		LocalDate date4 = LocalDate.of(1996, 1, 20);
		LocalDate date5 = LocalDate.of(1996, 9, 12);

		/**
		 * ----CUSTOMER
		 * Repository-----------------------------------------------------------------------------------------------------------------------------------------------
		 * Customer(String ,String ,Address ,String ,String ,String ,String ,LocalDate)
		 * Customer(customerId,customerName,customerAddress,customerAadhar,customaerPan,customaerContact,customaerGender,customaerDob)
		 */
		Customer cust1 = new Customer("ct0001001", "Rao Ramesh", add1, "121156982034", "XVGY258945", "9638521472",
				"MALE", date1);
		Customer cust2 = new Customer("ct0001552", "Babu Suresh", add2, "125153315555", "FBTN651513", "9513563153",
				"MALE", date1);
		Customer cust3 = new Customer("ct0005133", "Amma Kumar", add3, "121211112546", "KJJK321543", "8984653165",
				"MALE", date1);
		Customer cust4 = new Customer("ct0008946", "Manasa Reddy", add4, "115511552165", "RTHF655588", "9865316645",
				"FEMALE", date1);

		/**
		 * ----TRANSACTION
		 * Repository------------------------------------------------------------------------------------------------------------------------------------------
		 * Transaction(String ,String ,double ,String ,LocalDate ,String ,String ,String
		 * ,double )
		 * Transaction(transAccountId,transType,transAmount,transOption,transDate,transChequeId,transFrom,transTo,transClosingBalance)
		 */
		AccTransaction tran1 = new AccTransaction("100000123456", "Credit", 5515.0, "slip", date5, "-", "Rao Ramesh",
				"self", 200065.26);
		AccTransaction tran2 = new AccTransaction("100000989565", "Debit", 89515.0, "slip", date5, "-", "Babu Suresh",
				"self", 305067.86);
		AccTransaction tran3 = new AccTransaction("100000248465", "Debiit", 95615.0, "slip", date5, "-", "Amma Kumar",
				"self", 500895.59);
		AccTransaction tran4 = new AccTransaction("100000985456", "Credit", 12500.0, "slip", date5, "-", "Manasa Reddy",
				"self", 850065.69);

		/**
		 * List of transactions for each account.
		 */
		transList1.add(tran1);
		transList2.add(tran2);
		transList3.add(tran3);
		transList4.add(tran4);

		/**
		 * ----ACCOUNT MANAGER
		 * Repository--------------------------------------------------------------------------------------------------------------------------------------
		 * AccountManagement(String ,Customer ,String ,String ,String ,double ,double
		 * ,LocalDate ,List<Transaction>)
		 * AccountManagement(accountId,accountHolder,accountBranchId,accountType,accountStatus,accountBalance,accountInterest,lastUpdated,trxns)
		 */
		AccountManagement account1 = new AccountManagement("100000123456", cust1, "br1001", "SAVINGS", "ACTIVE",
				200065.26, 0.0, date5, transList1);
		AccountManagement account2 = new AccountManagement("100000989565", cust2, "br1002", "CURRENT", "ACTIVE",
				305067.86, 0.0, date5, transList2);
		AccountManagement account3 = new AccountManagement("100000248465", cust3, "br1003", "CURRENT", "ACTIVE",
				500895.59, 0.0, date5, transList3);
		AccountManagement account4 = new AccountManagement("100000985456", cust4, "br1004", "SAVINGS", "ACTIVE",
				850065.69, 0.0, date5, transList4);
		/**
		 * Map of Account Management with accountId as a key.
		 */
		accList.put(account1.getAccountId(), account1);
		accList.put(account2.getAccountId(), account2);
		accList.put(account3.getAccountId(), account3);
		accList.put(account4.getAccountId(), account4);

		/**
		 * ----CHEQUE
		 * Repository-----------------------------------------------------------------------------------------------------------------------------------------------
		 * Cheque(String ,String ,String ,String ,String ,LocalDate ,String)
		 * Cheque(chequeId,chequeNum,chequeAccountNo,chequeBankName,chequeIFSC,chequeIssueDate,chequeStatus)
		 */
		Cheque cheque1 = new Cheque("11001", "984161", "100000123456", "PECUNIA", "PCNA0001001", date1, "SUCCESS");
		Cheque cheque2 = new Cheque("11002", "951512", "100000989565", "PECUNIA", "PCNA0001002", date2, "SUCCESS");
		Cheque cheque3 = new Cheque("11003", "555515", "100000248465", "PECUNIA", "PCNA0001003", date3, "SUCCESS");
		Cheque cheque4 = new Cheque("11004", "957665", "100000985456", "PECUNIA", "PCNA0001004", date4, "SUCCESS");
		Cheque cheque5 = new Cheque("11005", "957654", "100000985456", "PECUNIA", "PCNA0001004", date5, "FAILED");
		/**
		 * Map of cheque with cheque id as key.
		 */
		cheq.put(cheque1.getChequeId(), cheque1);
		cheq.put(cheque2.getChequeId(), cheque2);
		cheq.put(cheque3.getChequeId(), cheque3);
		cheq.put(cheque4.getChequeId(), cheque4);
		cheq.put(cheque5.getChequeId(), cheque5);
	}
}
