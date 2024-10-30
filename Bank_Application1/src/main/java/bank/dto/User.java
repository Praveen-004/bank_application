package bank.dto;

import java.util.Random;

public class User {
	private String fname, lname, password, email;
	private int age;
	private long phone, aadhar;
	private long accountNo;
	
	Random random = new Random();

	public User(String fname, String lname, String password, String email, int age, long phone, long aadhar) {
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.age = age;
		this.aadhar = aadhar;
		this.accountNo = 1000000000L + Math.abs(random.nextLong() % 1000000000L); // Generates 10-digit account number
	}
	

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	
	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", password=" + password + ", email=" + email + ", age="
				+ age + ", phone=" + phone + ", aadhar=" + aadhar + ", accountNo=" + accountNo + "]";
	}
}
