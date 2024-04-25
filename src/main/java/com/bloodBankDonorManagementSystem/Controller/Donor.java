package com.bloodBankDonorManagementSystem.Controller;

import java.util.Date;

public class Donor {

	private String donorName;
	private int age;
	private String gender;
	private String bloodGroup;
	private String city;
	private String phno;
	private String email;
	private Date lastDonationDate;
	
	public Donor() {
		super();
	}

	public Donor(String donorName, int age, String gender, String bloodGroup, String city,
			 String phno, String email,Date lastDonationDate) {
		super();
		this.donorName = donorName;
		this.age = age;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.city = city;
		this.phno = phno;
		this.email = email;
		this.lastDonationDate=lastDonationDate;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastDonationDate() {
		return lastDonationDate;
	}

	public void setLastDonationDate(Date lastDonationDate) {
		this.lastDonationDate = lastDonationDate;
	}
	
	
}
