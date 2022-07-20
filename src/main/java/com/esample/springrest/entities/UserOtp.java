package com.esample.springrest.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// UserDetails
   // - id , name, email, phone_no , created_at , updated_at

@Entity
public class UserOtp {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="otp")
	private String otp;
	@Column(name="moblie_number")
	private String mobileNumber;
	@Column(name="genrated_at")
	private Date genratedAt;
	@Column(name="expiry_time")
	private Date expiryTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getGenratedAt() {
		return genratedAt;
	}
	public void setGenratedAt(Date genratedAt) {
		this.genratedAt = genratedAt;
	}
	public Date getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}
	

}
