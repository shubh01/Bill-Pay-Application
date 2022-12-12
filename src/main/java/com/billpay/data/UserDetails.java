package com.billpay.data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Shubhashish Tiwari
 *
 */
@Entity
@Table
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String emailId;

	@Column
	private Date createdOn;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
